package christmas.domain;

import java.util.Set;

public class OrderSheet {
    private final int SPECIAL_DISCOUNT=1000;
    private final Orders orders;
    private final VisitDate visitDate;


    public OrderSheet(Orders orders, VisitDate visitDate) {
        this.orders = orders;
        this.visitDate = visitDate;
    }

    public int calculateSpecialDiscount(){
        if(SpecialDays.isSpecialDay(visitDate)){
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

    public boolean hasGiveAway() {
        return orders.hasGiveAway();
    }
}


