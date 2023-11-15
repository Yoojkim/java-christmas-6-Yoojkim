package christmas.domain;

import christmas.util.DiscountWeekType;
import christmas.util.ErrorMessage;
import christmas.util.WeekCalculator;


public class VisitDate {
    private final int MIN = 1;
    private final int MAX = 31;
    private final int CHRISTMAS = 25;
    private final int YEAR = 2023;
    private final int MONTH = 12;
    private final int START_CHRISTMAS_DISCOUNT = 1000;
    private final int CHRISTMAS_INCREASE_VALUE = 100;

    private int visitDate;

    public VisitDate(int date) {
        validateDate(date);
        this.visitDate = date;
    }

    public int getVisitDate() {
        return visitDate;
    }

    public DiscountWeekType getWeekType() {
        return WeekCalculator.calculateWeekType(YEAR, MONTH, visitDate);
    }

    public int calculateChristmasDiscount() {
        if (!isChristMasDiscountTarget()) {
            return 0;
        }

        return START_CHRISTMAS_DISCOUNT + (visitDate - 1) * CHRISTMAS_INCREASE_VALUE;
    }

    private boolean isChristMasDiscountTarget() {
        return visitDate <= CHRISTMAS;
    }

    private void validateDate(int date) {
        if (date < MIN || date > MAX) {
            throw new IllegalArgumentException(ErrorMessage.VISIT_DATE_RANGE.getMessage());
        }
    }

    //todo: compare hashcode


    @Override
    public int hashCode() {
        return visitDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VisitDate)) {
            return false;
        }

        VisitDate objVisitDate = (VisitDate) obj;
        return visitDate == objVisitDate.getVisitDate();
    }
}
