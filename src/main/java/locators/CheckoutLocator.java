package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutLocator {
    private final WebDriver driver;
    private WebDriverWait wait;
    private String idProduct = "3";

    public CheckoutLocator(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }
}
