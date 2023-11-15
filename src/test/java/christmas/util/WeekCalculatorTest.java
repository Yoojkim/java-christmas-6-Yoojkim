package christmas.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeekCalculatorTest {

    private final int[] weekendDates = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30};
    private final int YEAR = 2023;
    private final int MONTH = 12;
    private final int START = 1;
    private final int END = 31;

    @Test
    void 주말_테스트() {
        for (int weekendDate : weekendDates) {
            WeekCalculator.calculateWeekType(YEAR, MONTH, weekendDate);
            Assertions.assertThat(WeekCalculator.calculateWeekType(YEAR, MONTH, weekendDate))
                    .isEqualTo(DiscountWeekType.WEEKEND);
        }
    }

    @Test
    void 평일_테스트() {
        Set<Integer> weekendSet = new HashSet<>();
        for (int weekendDate : weekendDates) {
            weekendSet.add(weekendDate);
        }

        for (int weekDayDate = START; weekDayDate <= END; weekDayDate++) {
            if (weekendSet.contains(weekDayDate)) {
                continue;
            }
            WeekCalculator.calculateWeekType(YEAR, MONTH, weekDayDate);
            Assertions.assertThat(WeekCalculator.calculateWeekType(YEAR, MONTH, weekDayDate))
                    .isEqualTo(DiscountWeekType.WEEKDAY);
        }

    }
}
