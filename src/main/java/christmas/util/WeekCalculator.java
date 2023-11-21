package christmas.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekCalculator {
    private WeekCalculator() {
    }

    public static DiscountWeekType calculateWeekType(final int year, final int month, final int dayOfMonth) {
        int weekNumber = getDayOfWeekNumber(year, month, dayOfMonth);

        if (weekNumber == 5 || weekNumber == 6) {
            return DiscountWeekType.WEEKEND;
        }

        return DiscountWeekType.WEEKDAY;
    }

    private static int getDayOfWeekNumber(final int year, final int month, final int dayOfMonth) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek.getValue();
    }
}
