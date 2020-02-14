package screens.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.common.BaseScreen;
import screens.interfaces.AllReceiptsScreen;

import java.util.List;

public class AndroidAllReceiptsScreen extends BaseScreen implements AllReceiptsScreen {
	
	private String title = "com.lunchit.android.beta:id/title";
	private String doneButton = "com.lunchit.android.beta:id/done_button";
	private String currentMonth = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]";
	private String currentMonth2 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]";
	
	//private String lastReceipt="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout";
	private String receiptDatils = "v_receipt_detail";
	private String lista = "android.widget.RelativeLayout";
	
	public AndroidAllReceiptsScreen(AndroidDriver driver) {
		super(driver);
	}
	
	@Override
	public void selectCurrentMonth() {
		
		sleep(3000);
		
		try {
			List<WebElement> list = driver.findElementsByClassName(lista);
			if (list.size() > 0) {
				list.get(0).click();
				System.out.println("Current month selected");
			} else {
				
				System.out.println("No months");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void selectLastReceipt() {
		sleep(3000);
		try {
			List<WebElement> receiptsElements = driver.findElementsById(receiptDatils);
			if (receiptsElements.size() > 0) {
				receiptsElements.get(0).click();
				System.out.println("Last receipt selected");
			} else {
				System.out.println("No elements");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void submit() {
		waitAndClick(By.id(doneButton));
		
	}
	
	@Override
	public void checkScreenFormat() {
		sleep(1000);
		
		//pending to add more assertions
	}
}
