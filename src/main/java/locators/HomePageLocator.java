package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageLocator {
    private final WebDriver driver;
    private WebDriverWait wait;
    private String linkEspecialOffer = "a[translate='SPACIAL_OFFER']";
    private String btnSeeOffer = "see_offer_btn";
    private String btnSearch = "menuSearch";
    private String fieldSearch = "autoComplete";
    private String loadPage = "div[style='display: none; opacity: 0;']";


    public HomePageLocator(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 45);
    }

    public void clickOnOptionSpecialOffer() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(loadPage)));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(linkEspecialOffer))).click();

    }

    public void clickOnButtonSeeOffer() {

        wait.until(ExpectedConditions.elementToBeClickable(By.id(btnSeeOffer))).click();

    }

    public void clickOnButtonSearch() {

        wait.until(ExpectedConditions.elementToBeClickable(By.id(btnSearch))).click();
    }

    public void search(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldSearch))).sendKeys(product);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldSearch))).sendKeys(Keys.ENTER);
    }
}
