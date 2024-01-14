package test.DemoApp.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import test.base_screen.BaseScreen;

public class HomeScreen extends BaseScreen {
    private final By sideMenuButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView");
    private final By loginOptionInSideMenu = AppiumBy.xpath("//android.widget.TextView[@text=\"Log In\"]") ;
    private final By firstProductIcon = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView") ;
    private final By productsTitle = AppiumBy.xpath("//android.widget.TextView[@text=\"Products\"]") ;
    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }
        public void clickOnSideMenuButton(){
            findElement(sideMenuButton).click();
    }
    public LoginScreen clickOnLoginOptionInSideMenu(){
        findElement(loginOptionInSideMenu).click();
        return new LoginScreen(driver) ;
    }
    public FirstProductScreen clickOnFirstProduct(){
        findElement(firstProductIcon).click();
        return new FirstProductScreen(driver);
    }
    public Boolean getProductsTitle(){
     return findElement(productsTitle).isDisplayed();
    }
}
