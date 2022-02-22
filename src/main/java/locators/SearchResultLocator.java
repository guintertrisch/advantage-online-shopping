package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultLocator {
    private final WebDriver driver;
    private WebDriverWait wait;
    private String idProduct = "3";
    private String amount = "a[class='productPrice ng-binding']";

    public SearchResultLocator(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }


    public void selectProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idProduct))).click();
    }

    public float getAmountUnitary() {
        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(amount))).getText().replace("$", "");
        return Float.parseFloat(String.valueOf(value));
    }
}
