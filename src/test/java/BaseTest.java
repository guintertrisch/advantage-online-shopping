import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseTest {
    public WebDriver driver;
    public Connection con;
    public HomePageLocator home;
    //public CheckoutLocators checkout;


    @BeforeEach
    public void setUpTest()throws SQLException {
        con = DbConnection.getConnection();
       // Browser browsers = new Browser();
        //driver = browsers.getDriver("chrome");
        //driver.get("https://advantageonlineshopping.com/");
       // home = new HomePageLocator(driver);
        // checkout = new CheckoutLocators(driver);

    }

    @AfterEach
    public void browserClose() throws SQLException {
        //driver.close();
        //driver.quit();
        con.close();
    }
}
