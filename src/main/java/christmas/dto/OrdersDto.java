package christmas.dto;

import christmas.domain.Order;
import christmas.domain.Orders;

import java.util.ArrayList;
import java.util.List;

public record OrdersDto (List<OrderDto> orders) {
    public static OrdersDto from(Orders orders) {
        List<OrderDto> orderDtos = new ArrayList<>();

        for (Order order : orders.getOrders()) {
            orderDtos.add(OrderDto.from(order));
        }

        return new OrdersDto(orderDtos);
    }
}
