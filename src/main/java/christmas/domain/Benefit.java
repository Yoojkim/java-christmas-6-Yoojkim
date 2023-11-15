package christmas.domain;

import christmas.util.Badge;
import christmas.util.Menu;

public class Benefit {
    private final int GIVEAWAY_QUANTITY = 1;
    private final Menu giveAway;
    private final int christMasDiscount;
    private final int weekDiscount;
    private final int specialDiscount;

    public Benefit(Builder builder) {
        giveAway = builder.giveAway;
        christMasDiscount = builder.christMasDiscount;
        weekDiscount = builder.weekDiscount;
        specialDiscount = builder.specialDiscount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Badge getBadge() {
        return Badge.getBadge(getAllDiscount());
    }

    public int getAllDiscount() {
        return christMasDiscount + weekDiscount + specialDiscount + (giveAway.getCost() * GIVEAWAY_QUANTITY);
    }

    public Menu getGiveAway() {
        return giveAway;
    }

    public int getChristMasDiscount() {
        return christMasDiscount;
    }

    public int getWeekDiscount() {
        return weekDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public int getGiveAwayQuantity() {
        return GIVEAWAY_QUANTITY;
    }

    public static class Builder {
        private Menu giveAway = Menu.NONE;
        private int christMasDiscount = 0;
        private int weekDiscount = 0;
        private int specialDiscount = 0;

        public Builder() {
        }

        public Builder giveAway(Menu giveAway) {
            this.giveAway = giveAway;
            return this;
        }

        public Builder christMasDiscount(int christMasDiscount) {
            this.christMasDiscount = christMasDiscount;
            return this;
        }

        public Builder weekDiscount(int weekDiscount) {
            this.weekDiscount = weekDiscount;
            return this;
        }

        public Builder specialDiscount(int specialDiscount) {
            this.specialDiscount = specialDiscount;
            return this;
        }

        public Benefit build() {
            return new Benefit(this);
        }
    }
}