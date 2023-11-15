package christmas.domain;

import christmas.util.Badge;
import christmas.util.Menu;

public class Benefit {
    boolean hasGiveAway = false;
    int christMasDiscount = 0;
    int weekDiscount = 0;
    int specialDiscount = 0;

    public Benefit() {
    }

    public Benefit(boolean hasGiveAway, int christMasDiscount, int weekDiscount, int specialDiscount) {
        this.hasGiveAway = hasGiveAway;
        this.christMasDiscount = christMasDiscount;
        this.weekDiscount = weekDiscount;
        this.specialDiscount = specialDiscount;
    }

    public Badge getBadge(Menu giveAway) {
        int discountSum = christMasDiscount + weekDiscount + specialDiscount;

        if (hasGiveAway) {
            discountSum += giveAway.getCost();
        }

        return Badge.getBadge(discountSum);
    }
}

