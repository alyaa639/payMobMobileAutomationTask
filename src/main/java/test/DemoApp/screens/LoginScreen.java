package test.DemoApp.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import test.base_screen.BaseScreen;

public class LoginScreen extends BaseScreen {
    private final By userNameAndPasswordHeader = AppiumBy.xpath("//android.widget.TextView[@text=\"bob@example.com\"]");
    private final By loginButton = AppiumBy.xpath("(//android.widget.TextView[@text=\"Login\"])[2]");
    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }
    public void clickOnUseNmaeAndPasswordHeader(){
        findElement(userNameAndPasswordHeader).click();
    }
    public HomeScreen clickOnLoginButton(){
        findElement(loginButton).click();
        return new HomeScreen(driver);

    }
}
