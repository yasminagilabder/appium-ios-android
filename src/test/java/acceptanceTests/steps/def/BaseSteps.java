package acceptanceTests.steps.def;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.android.*;
import screens.interfaces.*;
import screens.ios.IOSLoginScreen;
import util.category.Category;
import util.driver.ThreadLocalDriver;
import util.exception.*;

public class BaseSteps {
	private static final String LOGGING = "login";
	private static final String PASSWORD = "password";
	private static final String ADD_RECEIPT = "addreceipt";
	private static final String GALLERY = "gallery";
	private static final String VERIFY = "verifyreceipt";
	private static final String UPDATE_RECEIPT = "updatereceipt";
	private static final String SUBMIT_RECEIPT = "submitreceipt";
	private static final String ALL_RECEIPTS = "allreceipts";
	private static final String CURRENT_MONTH = "currentmonth";
	private static final String CATEGORY = "category";
	private static final String CATEGORY1_BUTTON = "category1";
	private static final String CATEGORY2_BUTTON = "category2";
	
	private static final String RECEIPT = "receipt";
	private static final String REFUND = "refund";
	private static final String DONE = "done";
	private static final String ADD_NEW = "addnew";
	private static final String FEEDBACK = "feedback";
	private static final String CLOSE = "close";
	private static final String LAST_RECEIPT = "lastreceipt";
	private static final String EDIT_RECEIPT = "editreceipt";
	private static final String UPDATE_AMOUNT = "amount";
	private static final String DELETE = "delete";
	private static final String SHOW_RECEIPT = "showreceipt";
	private static final String LOGOUT = "logout";
	private static final String UNKNOWN_SCREEN = "Unknown screen!!!";
	private static final String UNKNOWN_FIELD = "Unknown field!!!";
	private static final String UNKNOWN_LINK = "Unknown link!!";
	private static final String UNKNOWN_BUTTON = "Unknown button!!!";
	private static final String UNKNOWN_CATEGORY = "Unknown Category!!!";
	
	
	LoginScreen loginScreen;
	AddReceiptScreen addReceiptScreen;
	GalleryScreen galleryScreen;
	UpdateReceiptScreen updateReceiptScreen;
	RefundScreen refundScreen;
	FeedbackScreen feedbackScreen;
	AllReceiptsScreen allReceiptsScreen;
	EditReceiptScreen editReceiptScreen;
	CategoryScreen categoryScreen;
	EditReceiptCategoryScreen editReceiptCategoryScreen;
	
	
	public BaseSteps() {
		AppiumDriver appiumDriver = ThreadLocalDriver.getTLDriver();
		if (appiumDriver instanceof AndroidDriver) {
			loginScreen = new AndroidLoginScreen((AndroidDriver) appiumDriver);
			addReceiptScreen = new AndroidAddReceiptScreen(appiumDriver);
			galleryScreen = new AndroidGalleryScreen(appiumDriver);
			updateReceiptScreen = new AndroidUpdateReceiptScreen((AndroidDriver) appiumDriver);
			refundScreen = new AndroidRefundScreen((AndroidDriver) appiumDriver);
			feedbackScreen = new AndroidFeedbackScreen((AndroidDriver) appiumDriver);
			allReceiptsScreen = new AndroidAllReceiptsScreen((AndroidDriver) appiumDriver);
			editReceiptScreen = new AndroidEditReceiptScreen((AndroidDriver) appiumDriver);
			categoryScreen = new AndroidCategoryScreen(appiumDriver);
			editReceiptCategoryScreen=new AndroidEditReceiptCatScreen ((AndroidDriver) appiumDriver);
			
		} else {
			loginScreen = new IOSLoginScreen((IOSDriver) appiumDriver);
		}
	}
	
	@After()
	public void afterScenario(Scenario scenario) {
		
		/*AppiumDriver appiumDriver = ThreadLocalDriver.getTLDriver();
		appiumDriver.closeApp();*/
	}
	
	@Before()
	public void beforeScenario(Scenario scenario) {
		
		AppiumDriver appiumDriver = ThreadLocalDriver.getTLDriver();
		appiumDriver.launchApp();
	}
	
	@Given("^I am in (.*) Screen$")
	public void iAmOnScreen(String screen) throws Exception {
		switch (screen.toLowerCase()) {
			case LOGGING:
				loginScreen.checkScreenFormat();
				break;
			case ADD_RECEIPT:
				addReceiptScreen.checkScreenFormat();
				break;
			case GALLERY:
				galleryScreen.checkScreenFormat();
				break;
			case UPDATE_RECEIPT:
				updateReceiptScreen.checkScreenFormat();
				break;
			case REFUND:
				refundScreen.checkScreenFormat();
				break;
			case FEEDBACK:
				feedbackScreen.checkScreenFormat();
				break;
			case ALL_RECEIPTS:
				allReceiptsScreen.checkScreenFormat();
				break;
			case EDIT_RECEIPT:
				editReceiptScreen.checkScreenFormat();
				break;
			case CATEGORY:
				categoryScreen.checkScreenFormat();
				break;
			
			default:
				throw new UnknownScreenException(UNKNOWN_SCREEN);
		}
	}
	
	
	@Given("^I enter (.*) in field (.*)$")
	public void i_enter_value_in_field(String value, String field) throws Exception {
		switch (field.trim().toLowerCase()) {
			case LOGGING:
				loginScreen.enterLogin(value);
				break;
			case PASSWORD:
				loginScreen.enterPassword(value);
				break;
			default:
				throw new UnknownFieldException(UNKNOWN_FIELD);
		}
	}
	
	@When("^I click (.*) button$")
	public void i_click_login_button(String value) throws Throwable {
		switch (value.trim().toLowerCase()) {
			case LOGGING:
				loginScreen.submit();
				break;
			case ADD_RECEIPT:
				addReceiptScreen.submit();
				break;
			case GALLERY:
				galleryScreen.submit();
				break;
			case VERIFY:
				galleryScreen.verify();
				break;
			case SUBMIT_RECEIPT:
				updateReceiptScreen.submit();
				break;
			case DONE:
				refundScreen.done();
				break;
			case ADD_NEW:
				refundScreen.addNew();
				break;
			case CLOSE:
				feedbackScreen.submit();
				break;
			case DELETE:
				editReceiptScreen.deleteReceipt();
				break;
			case SHOW_RECEIPT:
				editReceiptScreen.viewReceipt();
				break;
			case CATEGORY1_BUTTON:
				categoryScreen.submit(Category.CATEGORY1);
				break;
			case CATEGORY2_BUTTON:
				categoryScreen.submit(Category.CATEGORY2);
				break;
			default:
				throw new UnknownButtonException(UNKNOWN_BUTTON);
		}
	}
	
	@Then("I update (.*) to (.*)$")
	public void i_update_amount_to(String field, String amount) throws UnknownFieldException {
		
		switch (field.trim().toLowerCase()) {
			case UPDATE_AMOUNT:
				updateReceiptScreen.updateAmount(amount.trim());
				break;
			default:
				throw new UnknownFieldException(UNKNOWN_FIELD);
		}
	}
	
	
	@When("^I click (.*) Link")
	public void i_click_link(String link) throws Throwable {
		switch (link.trim().toLowerCase()) {
			case RECEIPT:
				addReceiptScreen.clickReceiptsLink();
				break;
			case CURRENT_MONTH:
				allReceiptsScreen.selectCurrentMonth();
				break;
			case LAST_RECEIPT:
				allReceiptsScreen.selectLastReceipt();
				break;
			case LOGOUT:
				editReceiptScreen.clickSideMenu();
				break;
			default:
				throw new UnknownLinkException(UNKNOWN_LINK);
		}
	}
	
	@Then("I am in EditReceipt screen for Category: {int}")
	public void iAmInEditReceiptScreenForCategory(int cat) throws UnknownCategoryException {
		
		if (cat==1){
			editReceiptCategoryScreen.checkScreenFormat();
			editReceiptCategoryScreen.checkCategoryScreen(Category.CATEGORY1);
		}else if (cat==2){
			editReceiptCategoryScreen.checkScreenFormat();
			editReceiptCategoryScreen.checkCategoryScreen(Category.CATEGORY2);
		}else{
			throw new UnknownCategoryException(UNKNOWN_CATEGORY);
		}
		
		
		
	}
}
