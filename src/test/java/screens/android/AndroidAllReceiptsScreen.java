package screens.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.common.BaseScreen;
import screens.interfaces.AllReceiptsScreen;
import util.exception.NoItemsFoundException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class AndroidAllReceiptsScreen extends BaseScreen implements AllReceiptsScreen {
	
	private String title = "com.lunchit.android.beta:id/title";
	private String doneButton = "com.lunchit.android.beta:id/done_button";
	/*private String currentMonth = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]";
	private String currentMonth2 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]";*/
	
	//private String lastReceipt="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout";
	private String receiptDetails = "v_receipt_detail";
	private String lista = "android.widget.RelativeLayout";
	private static final String NO_ITEMS = "No items have been found!!!!";
	AndroidEditReceiptScreen androidEditReceiptScreen;
	public AndroidAllReceiptsScreen(AndroidDriver driver) {
		super(driver);
	}
	
	@Override
	public void checkScreenFormat() {
		sleep(1000);
		assertThat("Title is not present", isElementPresent(By.id(title)));
	}
	
	
	@Override
	public void selectCurrentMonth() {
	
		sleep(8000);
		
		List<WebElement> list = driver.findElementsByClassName(lista);
		list.get(0).click();
		System.out.println("Current month selected");
	}
	
	@Override
	public void selectLastReceipt() {
		sleep(3000);
		
		try {
			List<WebElement> receiptsElements = driver.findElementsById(receiptDetails);
			if (receiptsElements.size() > 0) {
				receiptsElements.get(0).click();
				System.out.println("Last receipt selected");
			} else {
				throw new NoItemsFoundException(NO_ITEMS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void DeleteAllReceiptsDay() {
		androidEditReceiptScreen = new AndroidEditReceiptScreen((AndroidDriver) driver);
		selectCurrentMonth();
		if (isElementPresent(By.id(androidEditReceiptScreen.getAmountValue()))) {
			androidEditReceiptScreen.deleteReceipt();
		}
		if (isElementPresent(By.id(receiptDetails))){
			int count = 0;
			List<WebElement> receiptsElements = waitAndFindElements(By.id(receiptDetails));
			int size = receiptsElements.size();
			System.out.println("receiptsElements.size() " + size);
			if (size != 0) {
				while (count < size - 1) {
					receiptsElements.get(0).click();
					androidEditReceiptScreen.deleteReceipt();
					sleep(2000);
					System.out.println("receipt: " + count + "deleted");
					count++;
					receiptsElements =waitAndFindElements(By.id(receiptDetails));
					
				}
				selectCurrentMonth();
				androidEditReceiptScreen.deleteReceipt();
			}
		}
		
		this.submit();
	}
	
	public void submit() {
		waitAndClick(By.id(doneButton));
	}
	
	
}
