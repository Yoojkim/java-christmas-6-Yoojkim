package christmas.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {
    @ParameterizedTest
    @ValueSource(strings = {"떡볶이", "인절미토스트"})
    void 없는_메뉴_주문(String menu) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Menu.createMenu(menu);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"제로콜라", "크리스마스파스타"})
    void 주문_메뉴_생성(String menu) {
        Menu.createMenu(menu);
    }
}
