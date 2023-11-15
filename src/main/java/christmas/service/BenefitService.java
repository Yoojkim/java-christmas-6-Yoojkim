package christmas.service;

import christmas.domain.Benefit;
import christmas.domain.OrderSheet;
import christmas.domain.SpecialDays;
import christmas.util.Badge;
import christmas.util.Menu;

public class BenefitService {
    private final Menu GIVEAWAY = Menu.CHAMPAGNE;

    public Benefit calculateBenefit(OrderSheet orderSheet) {
        if (!orderSheet.isEventTarget()) {
            return new Benefit();
        }

        int christMasDDayDiscountPrice = orderSheet.calculateChristmasDiscount();
        int weekDiscountPrice = orderSheet.calculateWeekDiscount();
        int specialDiscountPrice = orderSheet.calculateSpecialDiscount();
        boolean hasGiveAway = orderSheet.hasGiveAway();

        Badge badge = createBadge(hasGiveAway, christMasDDayDiscountPrice, weekDiscountPrice, specialDiscountPrice);
        return new Benefit(hasGiveAway, christMasDDayDiscountPrice, weekDiscountPrice, specialDiscountPrice);
    }

    private Badge createBadge(boolean hasGiveAway, int christMasDiscount, int weekTypeDiscount,
                              int specialDiscount) {
        int allDiscountPrice = christMasDiscount + weekTypeDiscount + specialDiscount;
        if (hasGiveAway) {
            allDiscountPrice += GIVEAWAY.getCost();
        }

        return Badge.getBadge(allDiscountPrice);
    }
}
