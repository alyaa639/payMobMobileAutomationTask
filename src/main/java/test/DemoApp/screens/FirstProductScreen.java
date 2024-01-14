package test.DemoApp.screens;

import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import test.base_screen.BaseScreen;

public class FirstProductScreen extends BaseScreen {
    private final By addToCartButton= AppiumBy.xpath("//android.widget.TextView[@text=\"Add To Cart\"]") ;
    private final By cartIcon = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView") ;
    public FirstProductScreen(AppiumDriver driver) {
        super(driver);
    }
    public void clickOnAddToCartButton(){
        findElement(addToCartButton).click();
    }
    public MyCartScreen  clickOnCartButton(){
        findElement(cartIcon).click();
        return new MyCartScreen(driver);
    }
}
