package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAndroid {

    public LoginPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.lunchit.android.beta:id/aet_email")
    private MobileElement loginField;

    @FindBy(id = "com.lunchit.android.beta:id/aet_password")
    private MobileElement passwordField;
    
 
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
