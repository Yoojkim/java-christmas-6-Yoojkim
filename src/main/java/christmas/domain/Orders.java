package christmas.domain;

import christmas.util.ErrorMessage;
import christmas.util.Menu;

import java.util.*;

public class Orders {
    private final int MAX_QUANTITY = 20;
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validateMenuDuplication(orders);
        validateMenuSize(orders);
        validateMenuType(orders);

        this.orders = orders;
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

    private void validateMenuType(List<Order> orders){
        boolean ordersHaveOnlyDrinkMenu = true;

        for(Order order:orders){
            if(order.isMenuNotDrinkType()){
                ordersHaveOnlyDrinkMenu = false;

                break;
            }
        }

        if(ordersHaveOnlyDrinkMenu){
            throw new IllegalArgumentException(ErrorMessage.ONLY_DRINK_TYPE_MENU.getMessage());
        }
    }
}
