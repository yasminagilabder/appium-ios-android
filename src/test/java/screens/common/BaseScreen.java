package screens.common;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BaseScreen {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BaseScreen(AppiumDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    protected void waitAndClick (By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    protected void click (By by) {
        waitVisibility(by);
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
    protected void waitAndClickbyAccessibility (String accessibilityId) {
        WebElement we=driver.findElementByAccessibilityId(accessibilityId);
        we.click();
        
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
        Assert.assertEquals(actual,expected, "Two texts are not equal!" + "Actual: " + actual + " Expected: " + expected);
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
