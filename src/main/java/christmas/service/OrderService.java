package christmas.service;

import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    public VisitDate createVisitDate(final String inputDate) {
        int date = parseStringToInt(inputDate, ErrorMessage.VISIT_DATE_RANGE);

        return new VisitDate(date);
    }

    public Orders createOrders(String inputOrders) {
        inputOrders = refineInputOrders(inputOrders);

        List<Order> orders = new ArrayList<>();

        String ordersSeparator = ",";
        String[] separatedOrders = inputOrders.split(ordersSeparator, -1);
        for (String inputOrder : separatedOrders) {
            orders.add(createOrder(inputOrder));
        }

        return new Orders(orders);
    }

    private Order createOrder(final String inputOrder) {
        String orderSeparator = "-";

        String[] separatedOrder = inputOrder.split(orderSeparator, -1);
        validateSeparatedOrderFormat(separatedOrder);

        return Order.createOrder(separatedOrder[0], parseStringToInt(separatedOrder[1], ErrorMessage.MENU_NOT_PROPER));
    }

    private void validateSeparatedOrderFormat(final String[] separatedOrder) {
        if (separatedOrder.length != 2) {
            throw new IllegalArgumentException(ErrorMessage.MENU_NOT_PROPER.getMessage());
        }
    }

    private Integer parseStringToInt(final String value, final ErrorMessage errorMessage) {
        Integer formattedValue = null;

        try {
            formattedValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }

        return formattedValue;
    }

    private String refineInputOrders(String inputOrders) {
        return inputOrders.replaceAll("\\s", "");
    }
}
