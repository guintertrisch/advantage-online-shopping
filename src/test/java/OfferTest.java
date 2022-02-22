import dto.OfferDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import utils.PaymentCalcultor;

import java.awt.*;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OfferTest extends BaseTest {


    @Test
    public void deveRetornarEspecificacoesComSucesso() throws InterruptedException {
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

        home.clicarNaOpcaoSpecialOffer();
        home.clicarNoBotaoSeeOffer();

        offerDetail.setColor(offerDtoExpected.getColor());
        offerDetail.addToCard();
        String colorActual = offerDetail.getColor();
        assertEquals(offerDtoExpected.getColor(), colorActual);
        System.out.println(offerDetail.getColor());


    }

    @Test
    public void checkout() throws InterruptedException {
        int quantity = 2;

        home.clicarNoBotaoSearch();
        home.pesquisar(offerDtoExpected.getName_product());
        Float amountUnitary = searchResult.getAmountUnitary();
        float amountExpected = PaymentCalcultor.getAmountPayment(quantity, amountUnitary);

        searchResult.selectProduct();
        offerDetail.setColor(Color.RED.toString());
        offerDetail.setQuantity(quantity);
        offerDetail.addToCard();
        offerDetail.clickOnCheckout();

       // offerDao.setOfferColor(Color.RED.toString(),offerDtoExpected.getIdmassas());



    }

    @AfterEach
    public void close() throws SQLException {
        con.close();
    }
}
