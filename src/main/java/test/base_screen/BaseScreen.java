package test.base_screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.driver.AppDriver;

import java.time.Duration;
import java.util.List;


public class BaseScreen  {
    protected AppiumDriver driver;
   private static WebDriverWait wait ;

    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(35)), this);
    }

    public static WebElement getElementByPartialText(String text) {
        String textXpath = "//*[contains(@text, \"" + text + "\")]";
        AppiumDriver driver = AppDriver.getAppDriver().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textXpath)));
        return  driver.findElement(By.xpath(textXpath));
    }

    public boolean checkElementExistenceByText(String text){
        WebDriverWait wait = new WebDriverWait(AppDriver.getAppDriver().getDriver(), Duration.ofSeconds(5)) ;
        return AppDriver.getAppDriver().getDriver().findElements(By.xpath("//*[@text='" + text + "']")).size() >= 1;
    }



    public static void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
    }



    public static WebElement findElementByListOfLocators(By[] locators) throws Exception {
        WebElement element = null ;

        for (By locator:locators) {
            try{
                WebDriverWait wait = new WebDriverWait(AppDriver.getAppDriver().getDriver(), Duration.ofSeconds(1));
                element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            }catch (Exception e){}
            if (element!=null)
                return element;
        }
        throw new Exception("NoSuchElement : can't locate the element with specified locators");
    }

    public static WebElement findElement(By locator){
        WebDriverWait wait = new WebDriverWait(AppDriver.getAppDriver().getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return AppDriver.getAppDriver().getDriver().findElement(locator) ;
    }

    public static List<WebElement> findElements(By locator) {
        WebDriverWait wait = new WebDriverWait(AppDriver.getAppDriver().getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return AppDriver.getAppDriver().getDriver().findElements(locator) ;
    }


    public void clear(WebElement element) {
        waitForElementToBeVisible(element);
        element.clear();
    }

    public void click(WebElement element) {
        waitForElementToBeVisible(element);
        element.click();
    }

}
