package christmas.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderServiceTest {
    private final OrderService orderService = new OrderService();

    @ParameterizedTest
    @ValueSource(strings = {"dd", "&", "34.8"})
    void 유효하지_않은_날짜_예외처리(String date) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            orderService.createVisitDate(date);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "32"})
    void 범위_벗어난_날짜_예외처리(String date) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            orderService.createVisitDate(date);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {",,,,", "-", "크리스마스파스타-1,", ",크리스마스파스타-2"})
    void 주문_빈칸입력_예외처리(String menu) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            orderService.createOrders(menu);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"크리스마스 파스타-1", "크리스마스파스타 - 2 "})
    void 주문시_빈칸입력_정제(String menu) {
        orderService.createOrders(menu);
    }

    @ParameterizedTest
    @ValueSource(strings = {"크리스마스 파스타-1,제로콜라 -3", "제로콜라-3,크리스마스파스타-3"})
    void 주문_생성_성공(String menu) {
        orderService.createOrders(menu);
    }

    @ParameterizedTest
    @ValueSource(strings = {"크리스마스 파스타-1,제로콜라 -30", "제로콜라-3,제로콜라-3"})
    void 주문_생성_실패(String menu) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            orderService.createOrders(menu);
        });
    }
}
