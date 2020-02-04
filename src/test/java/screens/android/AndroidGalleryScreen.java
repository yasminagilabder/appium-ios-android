package screens.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import screens.common.BaseScreen;
import screens.interfaces.GalleryScreen;

import static org.hamcrest.MatcherAssert.assertThat;

public class AndroidGalleryScreen extends BaseScreen implements GalleryScreen {
	
	
	private String pickFromGalleryButton = "com.lunchit.android.beta:id/galleryButton";
	private String firstReceiptinGallery = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView[1]";
	private String secondReceiptinGallery = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView[1]";
	private String verifyReceipt = "com.lunchit.android.beta:id/btnVerify";
	private String galleryThumb = "com.android.documentsui:id/icon_thumb";
	private String openButton = "More options";
	
	public AndroidGalleryScreen(AppiumDriver driver) {
		super(driver);
		
		
	}
	
	@Override
	public void checkScreenFormat() {
		assertThat("Gallery button is not present", isElementPresent(By.id(pickFromGalleryButton)));
	}
	
	@Override
	public void submit() {
		sleep(5000);
		waitAndClick(By.id(pickFromGalleryButton));
		System.out.println("Clicking pickFromGalleryButton....");
		sleep(4000);
		waitAndClick(By.id(galleryThumb));
		waitAndClickbyAccessibility(openButton);
		System.out.println("Selecting first receipt from gallery....");
		
	}
	
	@Override
	public void verify() {
		sleep(5000);
		waitAndClick(By.id(verifyReceipt));
		System.out.println("Receipt is verified....");
		
	}
}
