package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageLocator {
    private final WebDriver driver;
    private WebDriverWait wait;
    private String linkEspecialOffer = "a[translate='SPACIAL_OFFER']";
    private String btnSeeOffer = "see_offer_btn";


    public HomePageLocator(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void clicarNaOpcaoSpecialOffer() throws InterruptedException {
        Thread.sleep(10000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(linkEspecialOffer))).click();

    }

    public void clicarNoBotaoSeeOffer() throws InterruptedException {
        Thread.sleep(10000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(btnSeeOffer))).click();
    }
}
