package christmas.domain;

import christmas.util.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderTest {

    Order order = new Order(Menu.BBQ_RIB, new Quantity(2));

    @Test
    void Order_가격() {
        int expectedPrice = 108000;

        Assertions.assertEquals(order.getOrderPrice(), expectedPrice);
    }

    @Test
    void 중복_메뉴_주문() {
        Set<Menu> menuSet = new HashSet<>(List.of(Menu.BBQ_RIB, Menu.CAESAR_SALAD));

        Assertions.assertTrue(order.isOrderExist(menuSet));
    }

    @Test
    void 단일_메뉴_주문() {
        Set<Menu> menuSet = new HashSet<>(List.of(Menu.CHAMPAGNE, Menu.CAESAR_SALAD));

        Assertions.assertFalse(order.isOrderExist(menuSet));
    }

    @Test
    void 메뉴_set_update() {
        Set<Menu> menuSet = new HashSet<>(List.of(Menu.CHAMPAGNE, Menu.CAESAR_SALAD));
        order.updateOrderMenuSet(menuSet);

        Assertions.assertEquals(3, menuSet.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"라면", "떡볶이", "인절미빙수"})
    void 없는_메뉴_생성_예외(String menu) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Order.createOrder(menu, 1);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 입력불가_메뉴_갯수_생성_예외(int quantity) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Order.createOrder("제로콜라", quantity);
        });
    }

}
