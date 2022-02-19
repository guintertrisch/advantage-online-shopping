import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TestCon extends BaseTest {


    @Test
    public void vai() throws SQLException {

        BeanHandler<OfferDto> beanListHandler = new BeanHandler<>(OfferDto.class);
        QueryRunner runner = new QueryRunner();
        OfferDto offerDto = runner.query(con, "SELECT * FROM massas", beanListHandler);

        System.out.println(offerDto.getName_product());


    }


    @AfterEach
    public void close() throws SQLException {
        con.close();
    }
}
