package christmas.domain;

import christmas.util.DiscountWeekType;
import christmas.util.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderSheetTest {
    static OrderSheet orderSheet;

    @BeforeAll
    static void init() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Menu.BBQ_RIB, new Quantity(2)));
        orders.add(new Order(Menu.CHOCOLATE_CAKE, new Quantity(2)));

        VisitDate visitDate = new VisitDate(3);
        orderSheet = new OrderSheet(new Orders(orders), visitDate);
    }

    @Test
    void 전체_값_계산() {
        int expected = Menu.BBQ_RIB.getCost() * 2 + Menu.CHOCOLATE_CAKE.getCost() * 2;
        Assertions.assertEquals(expected, orderSheet.calculateAllPrice());
    }

    @Test
    void 요일타입_반환() {
        DiscountWeekType expected = DiscountWeekType.WEEKDAY;
        Assertions.assertEquals(expected, orderSheet.getWeekType());
    }

    @Test
    void 스페셜_할인() {
        int expected = 1000;
        Assertions.assertEquals(expected, orderSheet.calculateSpecialDiscount());
    }

    @Test
    void 이벤트_대상_확인() {
        Assertions.assertTrue(orderSheet.isEventTarget());
    }

    @Test
    void 크리스마스_할인() {
        int expected = 1200;
        Assertions.assertEquals(expected, orderSheet.calculateChristmasDiscount());
    }

    @Test
    void 요일_할인() {
        int expected = 2023 * 2;
        Assertions.assertEquals(expected, orderSheet.calculateWeekDiscount());
    }

    @Test
    void 증정이벤트_대상() {
        Assertions.assertNotEquals(Menu.NONE, orderSheet.calculateGiveAway());
    }
}
