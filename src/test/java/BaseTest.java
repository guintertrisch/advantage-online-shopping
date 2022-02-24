import dto.OfferDto;
import locators.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseTest {
    public WebDriver driver;
    public Connection con;
    public HomePageLocator home;
    public OfferDetailLocator offerDetail;
    public SearchResultLocator searchResult;
    public CheckoutLocator checkout;
    public CartLocator cart;
    public OfferDao offerDao;
    OfferDto offerDtoExpected;

    @BeforeEach
    public void setUpTest() throws SQLException {
        con = DbConnection.getConnection();
        offerDao = new OfferDao(con);
        offerDtoExpected = offerDao.getOffer();

        Browser browsers = new Browser();
        driver = browsers.getDriver("chrome");
        driver.get("https://advantageonlineshopping.com/");
        home = new HomePageLocator(driver);
        offerDetail = new OfferDetailLocator(driver);
        searchResult = new SearchResultLocator(driver);
        checkout = new CheckoutLocator(driver);
        cart = new CartLocator(driver);


    }

    @AfterEach
    public void browserClose() throws SQLException {
        driver.close();
        driver.quit();
        con.close();
    }
}
