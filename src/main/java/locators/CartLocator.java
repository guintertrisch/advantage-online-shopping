package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartLocator {
    private final WebDriver driver;
    private WebDriverWait wait;
    private String menuCart = "menuCart";
    private String remove = "div[class='removeProduct iconCss iconX']";
    private String messageEmpty = "label[class='center roboto-medium ng-scope']";

    public CartLocator(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 45);
    }

    public void clickOnCart() {

        wait.until(ExpectedConditions.elementToBeClickable(By.id(menuCart))).click();
    }

    public void removeProduct() {

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(remove))).click();
    }

    public String getMessageEmptyCart() {

        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(messageEmpty))).getText();
    }
}
