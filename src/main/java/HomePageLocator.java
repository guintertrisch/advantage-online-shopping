import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageLocator {
    private final WebDriver driver;
    private WebDriverWait wait;
    private String linkEspecialOffer = "a[ng-click*='special_offer_items']";
    private String btnSeeOffer = "see_offer_btn";


    public HomePageLocator(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void clicarNaOpcaoSpecialOffer() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(linkEspecialOffer)));
        //Actions actions = new Actions(driver);
        //actions.moveToElement(e).click().perform();
    }

    public void clicarNoBotaoSeeOffer() {
       wait.until(ExpectedConditions.elementToBeClickable(By.id(btnSeeOffer))).click();
    }
}
