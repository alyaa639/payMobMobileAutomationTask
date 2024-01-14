package test.DemoApp.test_cases.Buying_Product;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/java/test/DemoApp/test_cases/Buying_Product/BuyingProduct",
        glue = { "src/main/java/test/DemoApp/test_cases/Buying_Product/BuyingProductStepDefs"},
        plugin = { "html:reports/Login-Report.html"},
        monochrome = true
)

public class BuyingProductRunner extends AbstractTestNGCucumberTests {
}
