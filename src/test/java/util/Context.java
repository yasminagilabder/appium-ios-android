package util;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import screens.BaseScreen;

public class Context {

	private DesiredCapabilities capabilities;
	private AppiumDriver driver;
	private BaseScreen baseScreen;
	
	public DesiredCapabilities getCapabilities() {
		return capabilities;
	}
	
	public void setCapabilities(DesiredCapabilities capabilities) {
		this.capabilities = capabilities;
	}
	
	public AppiumDriver getDriver() {
		return driver;
	}
	
	public void setDriver(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public BaseScreen getBaseScreen() {
		return baseScreen;
	}
	
	public void setBaseScreen(BaseScreen baseScreen) {
		this.baseScreen = baseScreen;
	}
}
