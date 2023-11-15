package christmas.dto;

import christmas.domain.Order;

public record OrderDto(String menuName, int quantity) {
    public static OrderDto from(final Order order) {
        return new OrderDto(order.getMenu().getName(), order.getQuantity());
    }
}
