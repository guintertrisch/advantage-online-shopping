import dto.OfferDto;
import enums.ColorEnum;
import org.junit.jupiter.api.Test;
import utils.PaymentCalculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OfferTest extends BaseTest {


    @Test
    public void shouldReturnSpecsWithSuccess() {
        home.clickOnOptionSpecialOffer();
        home.clickOnButtonSeeOffer();

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
    public void shouldChangeColorWithSuccess() {

        home.clickOnOptionSpecialOffer();
        home.clickOnButtonSeeOffer();

        offerDetail.setColor(offerDtoExpected.getColor());
        offerDetail.addToCart();
        String colorActual = offerDetail.getColor();
        assertEquals(offerDtoExpected.getColor(), colorActual);

    }

    @Test
    public void shouldCompleteCheckoutWithSuccess() {
        int quantity = 6;

        home.clickOnButtonSearch();
        home.search(offerDtoExpected.getName_product());
        String amountUnitary = searchResult.getAmountUnitary();
        String amountExpected = PaymentCalculator.getAmountPayment(quantity, amountUnitary);

        searchResult.selectProduct();
        offerDetail.setColor(ColorEnum.PURPLE.getDescription());
        offerDetail.setQuantity(quantity);
        offerDetail.addToCart();
        offerDetail.clickOnCheckout();
        String amountActual = checkout.getTotalValue();

        assertEquals(amountExpected, amountActual);

        offerDao.setOfferColor(ColorEnum.PURPLE.getDescription(), offerDtoExpected.getIdmassas());

    }

    @Test
    public void shouldToRemoveProductOnCart() {
        String messageExpected = "Your shopping cart is empty";
        home.clickOnOptionSpecialOffer();
        home.clickOnButtonSeeOffer();
        offerDetail.addToCart();
        cart.clickOnCart();
        cart.removeProduct();

        String messageActual = cart.getMessageEmptyCart();

        assertEquals(messageExpected, messageActual);
    }

}
