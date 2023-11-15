package christmas.domain;

import christmas.util.Badge;
import christmas.util.Menu;

public class Benefit {
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
        int discountSum = christMasDiscount + weekDiscount + specialDiscount + giveAway.getCost();
        return Badge.getBadge(discountSum);
    }

    public static class Builder {
        private Menu giveAway;
        private int christMasDiscount;
        private int weekDiscount;
        private int specialDiscount;

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