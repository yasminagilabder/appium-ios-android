package screens.interfaces;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public interface LoginScreen extends CommonScreen{
	
	public void enterLogin(String login) ;
	
	public void enterPassword(String passwordValue);
	
	public void closeFireBase();
	
	
}
