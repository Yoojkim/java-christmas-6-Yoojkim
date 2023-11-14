package christmas.domain;

import christmas.util.ErrorMessage;

public class VisitDate {
    private final int MIN = 1;
    private final int MAX = 31;

    private int visitDate;

    public VisitDate(int date) {
        validateDate(date);
        this.visitDate = date;
    }

    private void validateDate(int date) {
        if (date < MIN || date > MAX) {
            throw new IllegalArgumentException(ErrorMessage.VISIT_DATE_RANGE.getMessage());
        }
    }

}
