package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class QuantityTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 유효하지_않은_메뉴갯수_예외처리(int quantity) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Quantity(quantity);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10, 20})
    void Quantity_생성(int quantity) {
        new Quantity(quantity);
    }
}
