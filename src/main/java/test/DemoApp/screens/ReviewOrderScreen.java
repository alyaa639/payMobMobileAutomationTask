package test.DemoApp.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import test.base_screen.BaseScreen;

public class ReviewOrderScreen extends BaseScreen {
    private final By placeOrderButton = AppiumBy.xpath("//android.widget.TextView[@text=\"Place Order\"]") ;
    public ReviewOrderScreen(AppiumDriver driver) {
        super(driver);
    }
    public CompleteCheckoutScreen clickOnPlaceOrderButton(){
        findElement(placeOrderButton).click();
        return new CompleteCheckoutScreen(driver) ;
    }
}
