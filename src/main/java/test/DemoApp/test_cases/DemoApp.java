package test.DemoApp.test_cases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import test.DemoApp.screens.*;

import java.time.Duration;

public class DemoApp {

    public HomeScreen home;
    public CheckoutScreen checkout;
    public CompleteCheckoutScreen completeCheckout;
    public FirstProductScreen firstProduct;
    public LoginScreen login;
    public MyCartScreen myCart ;
    public  PaymentScreen payment ;
    public ReviewOrderScreen reviewOrder;


    public DemoApp(AppiumDriver driver) {
        this.home = new HomeScreen(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver , Duration.ofSeconds(30)), this);
    }


}
