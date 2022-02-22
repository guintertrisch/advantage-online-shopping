import dto.OfferDto;
import locators.HomePageLocator;
import locators.OfferDetailLocator;
import locators.SearchResultLocator;
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

    }

    @AfterEach
    public void browserClose() throws SQLException {
        //driver.close();
        //driver.quit();
        con.close();
    }
}
