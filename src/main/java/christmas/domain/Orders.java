package christmas.domain;

import christmas.util.DiscountWeekType;
import christmas.util.ErrorMessage;
import christmas.util.Menu;

import java.util.*;

public class Orders {
    private final int MIN_PRICE_FOR_EVENT = 10000;
    private final int MIN_PRICE_FOR_GIVEAWAY = 120000;
    private final int MAX_QUANTITY = 20;
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validateMenuDuplication(orders);
        validateMenuSize(orders);
        validateNonDrinkType(orders);

        this.orders = orders;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public boolean isEventTarget() {
        if (getAllPrice() < MIN_PRICE_FOR_EVENT) {
            return false;
        }

        return true;
    }

    public boolean hasGiveAway() {
        if (getAllPrice() >= MIN_PRICE_FOR_GIVEAWAY) {
            return true;
        }

        return false;
    }

    public int getWeekTypeDiscountPrice(DiscountWeekType discountWeekType) {
        int discountPrice = 0;

        for (Order order : orders) {
            if (order.hasMenuType(discountWeekType.getMenuType())) {
                discountPrice += discountWeekType.getDiscountPrice() * order.getQuantity();
            }
        }

        return discountPrice;
    }

    private int getAllPrice() {
        int priceSum = 0;

        for (Order order : orders) {
            priceSum += order.getOrderPrice();
        }

        return priceSum;
    }

    private void validateMenuDuplication(List<Order> orders) {
        Set<Menu> menuSet = new HashSet<>();

        for (Order order : orders) {
            if (order.isOrderExist(menuSet)) {
                throw new IllegalArgumentException(ErrorMessage.MENU_NOT_PROPER.getMessage());
            }

            order.updateOrderMenuSet(menuSet);
        }
    }

    private void validateMenuSize(List<Order> orders) {
        int quantitySum = 0;

        for (Order order : orders) {
            quantitySum += order.getQuantity();

            if (quantitySum > MAX_QUANTITY) {
                throw new IllegalArgumentException(ErrorMessage.EXCEED_MAX_ORDER.getMessage());
            }
        }
    }

    private void validateNonDrinkType(List<Order> orders) {
        boolean ordersHaveOnlyDrinkMenu = true;

        for (Order order : orders) {
            if (!order.hasMenuType(Menu.MenuType.DRINK)) {
                ordersHaveOnlyDrinkMenu = false;
                break;
            }
        }

        if (ordersHaveOnlyDrinkMenu) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_DRINK_TYPE_MENU.getMessage());
        }
    }
}
