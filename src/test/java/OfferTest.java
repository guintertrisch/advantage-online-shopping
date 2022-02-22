import dto.OfferDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OfferTest extends BaseTest {


    @Test
    public void deveRetornarEspecificacoesComSucesso() throws InterruptedException {
        OfferDao offerDao = new OfferDao(con);
        OfferDto offerDtoExpected = offerDao.getOffer();
        home.clicarNaOpcaoSpecialOffer();
        home.clicarNoBotaoSeeOffer();

        OfferDto offerDtoAcutal = offerDetail.getDetailOffer();

        assertAll("Offer",
                () -> assertEquals(offerDtoExpected.getCustomization(), offerDtoAcutal.getCustomization()),
                () -> assertEquals(offerDtoExpected.getDisplay(), offerDtoAcutal.getDisplay()),
                () -> assertEquals(offerDtoExpected.getDisplay_resolution(), offerDtoAcutal.getDisplay_resolution()),
                () -> assertEquals(offerDtoExpected.getDisplay_size(), offerDtoAcutal.getDisplay_size()),
                () -> assertEquals(offerDtoExpected.getMemory(), offerDtoAcutal.getMemory()),
                () -> assertEquals(offerDtoExpected.getOperating_system(), offerDtoAcutal.getOperating_system()),
                () -> assertEquals(offerDtoExpected.getProcessor(), offerDtoAcutal.getProcessor()),
                () -> assertEquals(offerDtoExpected.getTouchscreen(), offerDtoAcutal.getTouchscreen()),
                () -> assertEquals(offerDtoExpected.getWeight(), offerDtoAcutal.getWeight())
        );

    }

    @Test
    public void deveAltearCor() throws InterruptedException {
        OfferDao offerDao = new OfferDao(con);
        OfferDto offerDtoExpected = offerDao.getOffer();

        home.clicarNaOpcaoSpecialOffer();
        home.clicarNoBotaoSeeOffer();

        offerDetail.setColor(offerDtoExpected.getColor());
        offerDetail.addToCard();

        System.out.println(offerDetail.getColor());


    }


    @AfterEach
    public void close() throws SQLException {
        con.close();
    }
}
