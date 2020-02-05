package screens.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import screens.common.BaseScreen;
import screens.interfaces.RefundScreen;
import screens.interfaces.UpdateReceiptScreen;

import static org.hamcrest.MatcherAssert.assertThat;

public class AndroidRefundScreen extends BaseScreen implements RefundScreen {
	
	
	private String animationLogo = "com.lunchit.android.beta:id/lottieAnimationView";
	private String refundAmount="com.lunchit.android.beta:id/refund";
	private String doneButton="com.lunchit.android.beta:id/done_button";
	private String addButton="com.lunchit.android.beta:id/add_button";
	
	
	public AndroidRefundScreen(AndroidDriver driver) {
		super(driver);
	}
	
	
	@Override
	public void checkScreenFormat() {
		sleep(10000);
		waitVisibility(By.id(animationLogo));
		waitVisibility(By.id(refundAmount));
	
	}
	
	@Override
	public void submit() {
		waitAndClick(By.id(doneButton));
		System.out.println("done button clicked...");
	
	}
}
