package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAndroid implements LoginPage {

    public LoginPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "main_search")
    private MobileElement loginField;

    @FindBy(id = "name")
    private MobileElement passwordField;
    
    @Override
    public void search(String name) {
    
    }
    
    @Override
    public void assertSearchResult(String expectedResult) {
    
    }
    
    @Override
    public void navigateToSearchResultDetails() {
    
    }


  /*  public void setLoginField(String name) {
        searchField.sendKeys(name);
    }

    public void assertSearchResult(String expectedResult) {
        Assert.assertEquals(expectedResult, firstSearchResultName.getText());
    }

    public void navigateToSearchResultDetails() {
        firstSearchResultName.click();
    }
*/
}
