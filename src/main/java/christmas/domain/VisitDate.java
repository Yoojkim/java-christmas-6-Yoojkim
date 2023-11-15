package christmas.domain;

import christmas.util.DiscountWeekType;
import christmas.util.ErrorMessage;
import christmas.util.WeekCalculator;

import java.util.Set;

public class VisitDate {
    private final int MIN = 1;
    private final int MAX = 31;
    private final int CHRISTMAS = 25;
    private final int YEAR = 2023;
    private final int MONTH = 12;

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

    //todo: Set 자료형 VisitDate
    public boolean isSpecialDiscountDate(Set<Integer> set) {
        if (set.contains(visitDate)) {
            return true;
        }

        return false;
    }

    public int getChristmasDDayDiscount() {
        if (!isChristMasDiscountTarget()) {
            return 0;
        }

        return 1000 + (visitDate - 1) * 100;
    }

    private boolean isChristMasDiscountTarget() {
        return visitDate <= CHRISTMAS;
    }

    private void validateDate(int date) {
        if (date < MIN || date > MAX) {
            throw new IllegalArgumentException(ErrorMessage.VISIT_DATE_RANGE.getMessage());
        }
    }

}
