package acceptanceTests.steps.def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import screens.LoginScreen;
import util.ThreadLocalDriver;

public class LoginSteps {
	
	LoginScreen loginScreen;
	
	public LoginSteps() {
		loginScreen = new LoginScreen(ThreadLocalDriver.getTLDriver());
	}
	
	@Given("^I enter (.*) in field (.*)$")
	public void i_enter_value_in_field(String value, String field) throws Exception {
		if (field.toLowerCase().equals("login")) {
			
			loginScreen.enterLogin(value);
		}else{
			if (field.toLowerCase().equals("password")){
				loginScreen.enterPassword(value);
			}else{
				throw new Exception("Unknown screen!!!");
			}
		}
	}
	

	@When("^I click (.*) button$")
	public void i_click_login_button(String value) throws Throwable {
		if (value.toLowerCase().equals("login")){
			loginScreen.clickLogin();
		}else{
			throw new Exception("Unknown button!!!");
		}
	}
	
	
	/*//Instantiations
	ProfileLoginScreen profileLoginScreen;
	LoginScreen loginScreen;
	PassCodeScreen passCodeScreen;
	MyProfileScreen myProfileScreen;
	
	//Screen Classes Initialization
	@Before
	public void setupLoginSteps () {
		System.out.println("Cucumber Before-login-test-cucumber");
		setupCucumber();
		profileLoginScreen = new ProfileLoginScreen(driver);
		loginScreen = new LoginScreen(driver);
		passCodeScreen = new PassCodeScreen(driver);
		myProfileScreen = new MyProfileScreen(driver);
		
	}
	
	@Given("^I have skipped Splash and Tutorial pages and I am on the job selection pages$")
	public void iHaveSkippedSplashAndTutorialPagesAndIAmOnTheJobSelectionPage() throws Throwable {
		System.out.println("Cucumber Given");
		// Write code here that turns the phrase above into concrete actions
		splashScreen.skipSplashScreen();
		tutorialScreen.skipTutorial();
	}
	
	@When("^I click İs Ariyorum button$")
	public void iClickİsAriyorumButton() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		selectionScreen.selectIsAriyorum();
		candidateMainScreen.allowNotification();
	}
	
	@And("^I go to Profilim page$")
	public void iGoToProfilimPage() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		candidateMainScreen.clickToProfile();
	}
	
	@And("^I click Giris Yap button$")
	public void iClickGirisYapButton() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		profileLoginScreen.clickLogin();
	}
	
	@And("^I fill \"([^\"]*)\" as my telephone number$")
	public void iFillAsMyTelephoneNumber(String arg0) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginScreen.enterPhoneNumber(arg0);
	}
	
	@And("^I click Giriş Yap button$")
	public void iClickGirişYapButton() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginScreen.clickLogin();
	}
	
	@And("^I give permission for SMS$")
	public void iGivePermissionForSMS() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		passCodeScreen.allowNotification();
	}
	
	
	@And("^I fill \"([^\"]*)\" as a login code$")
	public void iFillAsALoginCode(String arg0) throws Throwable {
		passCodeScreen.sendPassCode();
	}
	
	@And("^I click Tamam button$")
	public void iClickTamamButton() throws Throwable {
		passCodeScreen.finishLogin();
	}
	
	@Then("^I should see my profile page$")
	public void iShouldSeeMyProfilePage() throws Throwable {
		myProfileScreen.checkWorkExperienceTitle();
	}
	
	@After
	public synchronized void teardown () {
		// teardown();
		System.out.println("teardown'a girdi!");
	}*/
}
