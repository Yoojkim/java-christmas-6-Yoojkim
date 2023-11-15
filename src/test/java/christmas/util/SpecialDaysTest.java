package christmas.util;

import christmas.domain.VisitDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SpecialDaysTest {
    private final int[] specialDays = {3, 10, 17, 24, 25, 31};
    private final int START = 1;
    private final int END = 31;

    @Test
    void 스페셜할인_해당() {
        for (int specialDay : specialDays) {
            Assertions.assertThat(SpecialDays.isSpecialDay(new VisitDate(specialDay))).isTrue();
        }
    }

    @Test
    void 스페셜할인_해당안됨() {
        Set<Integer> specialDaySet = new HashSet<>();
        for (int specialDay : specialDays) {
            specialDaySet.add(specialDay);
        }

        for (int date = START; date <= END; date++) {
            if (specialDaySet.contains(date)) {
                continue;
            }

            Assertions.assertThat(SpecialDays.isSpecialDay(new VisitDate(date))).isFalse();
        }
    }
}
