import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageLocator {
    private WebDriver driver;
    private WebDriverWait wait;
    private String brigadeiroAddCarinho = "add-product-4-btn";
    private String rissoleMedioAddCarinho = "add-product-3-btn";
    private String alfajorChocolateAddCarinho = "add-product-5-btn";

    public HomePageLocator(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void clicarNaOpcaoSpecialOffer() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SPECIAL OFFER"))).click();

    }
}
