package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutLocator {
    private final WebDriver driver;
    private WebDriverWait wait;
    private String labelTotalValue = "span[class='roboto-medium totalValue ng-binding']";

    public CheckoutLocator(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 45);
    }

    public String getTotalValue() {
        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(labelTotalValue))).
                getText()
                .replace("$", "")
                .replace(",", ".")
                .replace(".", "");
        return value;
    }
}
