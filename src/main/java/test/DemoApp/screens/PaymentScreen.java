package test.DemoApp.screens;

import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import test.base_screen.BaseScreen;

public class PaymentScreen extends BaseScreen {
    private final By fullNameField = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]") ;
    private final By cardNumberField = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Card Number* input field\"]") ;
    private final By expieryDateField = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]") ;
    private final By securityCodeField = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Security Code* input field\"]") ;
    private final By reviewOrderButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Review Order button\"]") ;
    public PaymentScreen(AppiumDriver driver) {
        super(driver);
    }
    public void enterFullName(String name){
        findElement(fullNameField).sendKeys(name);
    }
    public void enterCardNumber(String cardNo){
        findElement(cardNumberField).sendKeys(cardNo);
    }
    public void enterExpieryDate(String expDate){
        findElement(expieryDateField).sendKeys(expDate);
    }
    public void enterSecurityCode(String secCode){
        findElement(securityCodeField).sendKeys(secCode);
    }
    public ReviewOrderScreen clickOnReviewOrderButton(){
        findElement(reviewOrderButton).click();
        return new ReviewOrderScreen(driver) ;
    }
}
