package screens.common;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Actions {

    protected AppiumDriver driver;
    protected WebDriverWait wait;


    public Actions(AppiumDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    protected void waitAndClick (By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    protected void click (By by) {
        driver.findElement(by).click();
    }

    protected void goBack(){
        driver.navigate().back();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected List<WebElement> waitAndFindElements (By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected WebElement waitAndFindElement (By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    protected void clickImage (String b64Template) {
        WebElement me=driver.findElement(MobileBy.image(b64Template));
        me.click();
    }
    protected WebElement waitByAccessibility (String accessibilityId) {
        return driver.findElementByAccessibilityId(accessibilityId);
    }

    protected String getText(By by) {
        return waitAndFindElement(by).getText();
    }

    protected void sendText (By by, String text) {
         waitAndFindElement(by).sendKeys(text);
    }
    protected void clearText (By by) {
        waitAndFindElement(by).clear();
    }

    protected void assertEquals (String actual, String expected) {
        Assert.assertEquals(actual,expected, "Texts are not equal!");
    }

    protected void waitVisibility (By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void sleep (long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
