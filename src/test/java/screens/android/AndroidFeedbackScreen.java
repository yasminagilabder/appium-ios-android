package screens.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import screens.common.BaseScreen;
import screens.interfaces.FeedbackScreen;
import util.category.Category;

public class AndroidFeedbackScreen extends BaseScreen implements FeedbackScreen {
	
	
	private String likeLogo = "com.lunchit.android.beta:id/likeFeedback";
	private String dilikeLogo="com.lunchit.android.beta:id/dontLikeFeedback";
	private String closeLogo="com.lunchit.android.beta:id/closeFeedback";
	
	public AndroidFeedbackScreen(AndroidDriver driver) {
		super(driver);
	}
	
	@Override
	public void checkScreenFormat() {
		sleep(10000);
		waitVisibility(By.id(likeLogo));
		waitVisibility(By.id(dilikeLogo));
	
	}
	@Override
	public void submit() {
		waitAndClick(By.id(closeLogo));
		System.out.println("Closing feedback window....");
	
	}
	
	@Override
	public void like() {
		waitAndClick(By.id(likeLogo));
		System.out.println("Like feedback is clicked....");
	}
	
	@Override
	public void dislike() {
		waitAndClick(By.id(dilikeLogo));
		System.out.println("DisLike feedback is clicked....");
	
	}
	
}
