package christmas.domain;

import christmas.util.Menu;
import christmas.util.SpecialDays;

public class OrderSheet {
    private final Menu GIVEAWAY = Menu.CHAMPAGNE;
    private final int SPECIAL_DISCOUNT = 1000;
    private final Orders orders;
    private final VisitDate visitDate;

    public OrderSheet(Orders orders, VisitDate visitDate) {
        this.orders = orders;
        this.visitDate = visitDate;
    }

    public int calculateSpecialDiscount() {
        if (SpecialDays.isSpecialDay(visitDate)) {
            return SPECIAL_DISCOUNT;
        }

        return 0;
    }

    public boolean isEventTarget() {
        return orders.isEventTarget();
    }

    public int calculateChristmasDiscount() {
        return visitDate.calculateChristmasDiscount();
    }

    public int calculateWeekDiscount() {
        return orders.getWeekTypeDiscountPrice(visitDate.getWeekType());
    }

    public Menu calculateGiveAway() {
        if (orders.hasGiveAway()) {
            return GIVEAWAY;
        }

        return Menu.NONE;
    }
}


