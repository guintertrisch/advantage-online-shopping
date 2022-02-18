import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestCon extends BaseTest{


    @BeforeEach
    public void setUp() throws SQLException {

    }

    @Test
    public void vai() throws SQLException {

        MapListHandler beanListHandler = new MapListHandler();

        QueryRunner runner = new QueryRunner();
        List<Map<String, Object>> list = runner.query(con, "SELECT * FROM massas", beanListHandler);

        System.out.println(list.get(0).get("idmassas"));

    }
    @Test
    public void ok(){
        home.clicarNaOpcaoSpecialOffer();

    }

    @AfterEach
    public void close() throws SQLException {
        con.close();
    }
}
