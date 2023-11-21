package christmas.domain;

import christmas.util.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BenefitTest {
    Benefit benefit = Benefit.builder()
            .giveAway(Menu.CHAMPAGNE)
            .christMasDiscount(1200)
            .weekDiscount(2023)
            .specialDiscount(1000)
            .build();

    @Test
    void 혜택_모든_할인() {
        int expected = benefit.getChristMasDiscount() + benefit.getSpecialDiscount() + benefit.getWeekDiscount()
                + Menu.CHAMPAGNE.getCost() * benefit.getGiveAwayQuantity();

        Assertions.assertEquals(expected, benefit.getAllDiscount());
    }
}
