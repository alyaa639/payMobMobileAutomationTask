package test.DemoApp.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import test.base_screen.BaseScreen;

public class MyCartScreen extends BaseScreen {
    private final By proceedToCheckoutButton = AppiumBy.xpath("//android.widget.TextView[@text=\"Proceed To Checkout\"]") ;
    public MyCartScreen(AppiumDriver driver) {
        super(driver);
    }
    public CheckoutScreen clickOnProceedToCheckout(){
        findElement(proceedToCheckoutButton).click();
        return new CheckoutScreen(driver) ;
    }
}
