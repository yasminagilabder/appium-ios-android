package screens.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import screens.common.BaseScreen;
import screens.interfaces.UpdateReceiptScreen;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

public class AndroidUpdateReceiptScreen extends BaseScreen implements UpdateReceiptScreen {
	
	
	private String amountValue = "com.lunchit.android.beta:id/amountValue";
	private String dateValue = "com.lunchit.android.beta:id/dateValue";
	private String legalTermsButton = "com.lunchit.android.beta:id/legalSwitch";
	private String submitButton = "com.lunchit.android.beta:id/submitButton";
	private AndroidDriver androidDriver;
	
	public AndroidUpdateReceiptScreen(AndroidDriver driver) {
		super(driver);
		androidDriver = (AndroidDriver) driver;
	}
	
	public void checkScreenFormat() {
		sleep(5000);
		assertThat("Amount is not present", isElementPresent(By.id(amountValue)));
		assertThat("Date is not present", isElementPresent(By.id(dateValue)));
	}
	
	public void submit() {
		waitAndClick(By.id(submitButton));
		System.out.println("Submit receipt...");
		
	}
	
	@Override
	public void updateAmount(String amount) {
		waitAndClick(By.id(amountValue));
		clearText(By.id(amountValue));
		sendText(By.id(amountValue), amount + "00");
		androidDriver.findElement(By.id(amountValue)).click();
		System.out.println("Receipt updated with correct amount....");
		swipingVertical();
		
		waitAndClick(By.id(legalTermsButton));
		System.out.println("Legal terms accepted...");
		
	}
	public void swipingVertical()  {
		sleep(8000);
		//Get the size of screen.
		Dimension size = androidDriver.manage().window().getSize();
		System.out.println(size);
		
		//Find swipe start and end point from screen's with and height.
		//Find starty point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);
		//Find endy point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		//Find horizontal point where you wants to swipe. It is in middle of screen width.
		int startx = size.width / 2;
		System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
		
		//Swipe from Bottom to Top.
		new TouchAction(androidDriver).press(PointOption.point(new Point(startx, starty))).moveTo(PointOption.point(new Point(starty, endy))).release().perform();
		//Swipe from Top to Bottom.
		
		
	}
	
	
}
