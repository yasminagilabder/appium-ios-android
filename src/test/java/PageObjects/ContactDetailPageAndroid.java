package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailPageAndroid implements ContactDetailPage {

    public ContactDetailPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "detail_name")
    private MobileElement contactName;

    public void assertContactName(String expectedName) {
        Assert.assertEquals(expectedName, contactName.getText());
    }
}
