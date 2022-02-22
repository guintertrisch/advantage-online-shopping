import dto.OfferDto;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class OfferDao {
    private static Connection connection;

    public OfferDao(Connection con) {
        this.connection = con;
    }

    public static OfferDto getOffer() {
        BeanHandler<OfferDto> beanListHandler = new BeanHandler<>(OfferDto.class);
        QueryRunner runner = new QueryRunner();
        OfferDto offerDto = new OfferDto();
        try {
            offerDto = runner.query(connection, "SELECT * FROM massas", beanListHandler);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offerDto;

    }

    public static OfferDto setOfferColor(String color, String id) {
        BeanHandler<OfferDto> beanListHandler = new BeanHandler<>(OfferDto.class);
        QueryRunner runner = new QueryRunner();
        OfferDto offerDto = new OfferDto();
        try {
            runner.update(connection, "UPDATE massas SET COLOR = ?  WHERE IDMASSAS = ?", color, id);
            offerDto = runner.query(connection, "SELECT * FROM massas", beanListHandler);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return offerDto;
    }
}
