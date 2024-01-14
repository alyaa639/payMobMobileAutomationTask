package test.DemoApp.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import test.base_screen.BaseScreen;

public class CompleteCheckoutScreen extends BaseScreen {
    private final By checkoutCompleteTitle = AppiumBy.xpath("//android.widget.TextView[@text=\"Checkout Complete\"]") ;
    public CompleteCheckoutScreen(AppiumDriver driver) {
        super(driver);
    }
    public String getCheckoutCompleteTitle(){
        return findElement(checkoutCompleteTitle).getText();

    }
}
