package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public interface LoginScreen {
	
	
	public void checkLoginScreenFormat();
	
	public void enterLogin(String login) ;
	
	public void enterPassword(String passwordValue);
	
	public void clickLogin() ;
	
	public void closeInstBug();
	
	public void closeFireBase();
	
}
