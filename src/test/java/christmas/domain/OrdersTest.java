package christmas.domain;

import christmas.util.DiscountWeekType;
import christmas.util.ErrorMessage;
import christmas.util.Menu;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OrdersTest {
    final Order drinkOrder1 = new Order(Menu.CHAMPAGNE, new Quantity(6));
    final Order drinkOrder2 = new Order(Menu.ZERO_COKE, new Quantity(15));
    final Order mainOrder1 = new Order(Menu.BBQ_RIB, new Quantity(15));
    final Order mainOrder2 = new Order(Menu.MUSHROOM_SOUP, new Quantity(1));
    List<Order> orders;

    @BeforeEach
    void beforeTest() {
        orders = new ArrayList<>();
    }

    @Test
    void 음료만_주문_불가() {
        orders.add(drinkOrder1);

        errorMessageTest(() -> {
            new Orders(orders);
        }, ErrorMessage.ONLY_DRINK_TYPE_MENU);
    }

    @Test
    void 메뉴_주문개수_초과() {
        orders.add(drinkOrder2);
        orders.add(mainOrder1);

        errorMessageTest(() -> {
            new Orders(orders);
        }, ErrorMessage.EXCEED_MAX_ORDER);
    }

    @Test
    void 중복메뉴_주문() {
        orders.add(mainOrder1);
        orders.add(mainOrder1);

        errorMessageTest(() -> {
            new Orders(orders);
        }, ErrorMessage.MENU_NOT_PROPER);
    }

    @Test
    void 이벤트_대상_아님() {
        orders.add(mainOrder2);
        Assertions.assertFalse(new Orders(orders).isEventTarget());
    }

    @Test
    void 이벤트_대상() {
        orders.add(mainOrder1);
        Assertions.assertTrue(new Orders(orders).isEventTarget());
    }

    @Test
    void 증정_이벤트_대상() {
        orders.add(mainOrder1);
        Assertions.assertTrue(new Orders(orders).hasGiveAway());
    }

    @Test
    void 증정_이벤트_미대상() {
        orders.add(mainOrder2);
        Assertions.assertFalse(new Orders(orders).hasGiveAway());
    }

    @Test
    void 평일_요일할인() {
        orders.add(new Order(Menu.CHOCOLATE_CAKE, new Quantity(3)));
        int expected = 2023 * 3;
        Assertions.assertEquals(expected, new Orders(orders).getWeekTypeDiscountPrice(DiscountWeekType.WEEKDAY));
    }

    @Test
    void 평일_요일할인_0원() {
        orders.add(mainOrder1);
        Assertions.assertEquals(0, new Orders(orders).getWeekTypeDiscountPrice(DiscountWeekType.WEEKDAY));
    }

    @Test
    void 주말_요일할인() {
        orders.add(mainOrder1);
        int expected = 2023 * mainOrder1.getQuantity();
        Assertions.assertEquals(expected, new Orders(orders).getWeekTypeDiscountPrice(DiscountWeekType.WEEKEND));
    }

    private void errorMessageTest(ThrowableAssert.ThrowingCallable executable, ErrorMessage errorMessage) {
        org.assertj.core.api.Assertions.assertThatThrownBy(executable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage.getMessage());
    }
}
