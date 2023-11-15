package christmas.domain;

import christmas.util.DiscountWeekType;
import christmas.util.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VisitDateTest {

    @ParameterizedTest
    @ValueSource(ints = {32, 42, 100})
    void 초과_날짜_VisitDate_생성(int date) {
        errorMessageTest(() -> {
            new VisitDate(date);
        }, ErrorMessage.VISIT_DATE_RANGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    void 미만_날짜_visitDate_생성(int date) {
        errorMessageTest(() -> {
            new VisitDate(date);
        }, ErrorMessage.VISIT_DATE_RANGE);
    }

    @Test
    void visitDate_생성() {
        for (int date = 1; date <= 31; date++) {
            new VisitDate(date);
        }
    }

    @Test
    void 요일타입_반환() {
        Set<Integer> weekendSet = new HashSet<>(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));

        for (int date = 1; date <= 31; date++) {
            if (weekendSet.contains(date)) {
                Assertions.assertThat(new VisitDate(date).getWeekType()).isEqualTo(DiscountWeekType.WEEKEND);

                continue;
            }

            Assertions.assertThat(new VisitDate(date).getWeekType()).isEqualTo(DiscountWeekType.WEEKDAY);
        }
    }

    @Test
    void 크리스마스_할인금액_계산() {
        int date = 25;
        int expectedChristmasDiscount = 3400;

        VisitDate visitDate = new VisitDate(date);

        Assertions.assertThat(visitDate.calculateChristmasDiscount())
                .isEqualTo(expectedChristmasDiscount);
    }

    private void errorMessageTest(ThrowableAssert.ThrowingCallable executable, ErrorMessage errorMessage) {
        org.assertj.core.api.Assertions.assertThatThrownBy(executable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage.getMessage());
    }
}
