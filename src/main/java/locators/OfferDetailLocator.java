package locators;

import dto.OfferDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OfferDetailLocator {
    private final WebDriver driver;
    private WebDriverWait wait;
    private String customization = "label[class*='value ng-binding']";
    private String btnSeeOffer = "see_offer_btn";
    private String colorPurple = "span[class='bunny productColor ng-scope PURPLE']";
    private String colorRed = "span[class='bunny productColor ng-scope RED']";
    private String colorGray = "span[class='bunny productColor ng-scope GRAY']";
    private String colorYellow = "span[class='bunny productColor ng-scope YELLOW']";
    private String colorBlack = "span[class='bunny productColor ng-scope BLACK']";
    private String colorBlue = "span[class='bunny productColor ng-scope BLUE']";
    private String addToCart = "button[name='save_to_cart']";
    private String color = "span[class='ng-binding']";
    private String increment = "div[increment-value-attr='+']";
    private String checkOutPopUp = "checkOutPopUp";


    public OfferDetailLocator(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public OfferDto getDetailOffer() {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(customization)));
        OfferDto offerDtoActual = new OfferDto();
        offerDtoActual.setCustomization(elements.get(0).getText().trim());
        offerDtoActual.setDisplay(elements.get(1).getText().trim());
        offerDtoActual.setDisplay_resolution(elements.get(2).getText().trim());
        offerDtoActual.setDisplay_size(elements.get(3).getText().trim());
        offerDtoActual.setMemory(elements.get(4).getText().trim());
        offerDtoActual.setOperating_system(elements.get(5).getText().trim());
        offerDtoActual.setProcessor(elements.get(6).getText().trim());
        offerDtoActual.setTouchscreen(elements.get(7).getText().trim());
        offerDtoActual.setWeight(elements.get(8).getText().trim());

        return offerDtoActual;
    }

    public void addToCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(addToCart))).click();
    }

    public String getColor() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(color))).getText();
    }

    public void setColor(String color) {
        switch (color) {
            case "GRAY":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(colorGray))).click();
                break;
            case "RED":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(colorRed))).click();
                break;

        }
    }

    public void setQuantity(int quantity) {
        for (int i = 1; i < quantity; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(increment))).click();
        }

    }

    public void clickOnCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(checkOutPopUp))).click();
    }
}
