package christmas.domain;

import christmas.util.Badge;

public class Benefit {
    boolean hasGiveAway = false;
    int christMasDiscount = 0;
    int weekDiscount = 0;
    int specialDiscount = 0;
    Badge badge = Badge.NONE;

    public Benefit() {
    }

    public Benefit(boolean hasGiveAway, int christMasDiscount, int weekDiscount, int specialDiscount, Badge badge) {
        this.hasGiveAway = hasGiveAway;
        this.christMasDiscount = christMasDiscount;
        this.weekDiscount = weekDiscount;
        this.specialDiscount = specialDiscount;
        this.badge = badge;
    }
}

