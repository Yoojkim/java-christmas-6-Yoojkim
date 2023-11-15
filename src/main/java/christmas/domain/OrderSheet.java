package christmas.domain;

import java.util.Set;

public class OrderSheet {
    private final Orders orders;
    private final VisitDate visitDate;

    public OrderSheet(Orders orders, VisitDate visitDate) {
        this.orders = orders;
        this.visitDate = visitDate;
    }

    public boolean isEventTarget() {
        return orders.isEventTarget();
    }

    public int calculateChristMasDDayDiscount() {
        return visitDate.getChristmasDDayDiscount();
    }

    public int calculateWeekDiscount() {
        return orders.getWeekTypeDiscountPrice(visitDate.getWeekType());
    }

    public int calculateSpecialDiscount() {
        Set<Integer> set = Set.of(3, 10, 17, 24, 25, 31);

        if (visitDate.isSpecialDiscountDate(set)) {
            return 1000;
        }

        return 0;
    }

    public boolean hasGiveAway() {
        return orders.hasGiveAway();
    }
}


