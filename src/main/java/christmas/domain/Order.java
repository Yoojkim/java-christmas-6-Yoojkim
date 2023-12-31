package christmas.domain;

import christmas.util.Menu;

import java.util.Set;

public class Order {
    private final Menu menu;
    private final Quantity quantity;

    public Order(Menu menu, Quantity quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public static Order createOrder(String inputMenuName, int inputQuantity) {
        Menu orderMenu = Menu.createMenu(inputMenuName);
        Quantity orderQuantity = new Quantity(inputQuantity);

        return new Order(orderMenu, orderQuantity);
    }

    public int getOrderPrice() {
        return menu.getCost() * quantity.getQuantity();
    }

    public boolean isOrderExist(Set<Menu> orderMenuSet) {
        return orderMenuSet.contains(menu);
    }

    public void updateOrderMenuSet(Set<Menu> orderMenuSet) {
        orderMenuSet.add(menu);
    }

    public boolean hasMenuType(Menu.MenuType menuType) {
        return menu.getType() == menuType;
    }

    public int getQuantity() {
        return quantity.getQuantity();
    }

    public Menu getMenu() {
        return menu;
    }
}
