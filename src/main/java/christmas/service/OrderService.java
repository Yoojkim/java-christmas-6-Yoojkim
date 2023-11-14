package christmas.service;

import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public VisitDate createVisitDate(String inputDate) {
        int date = parseStringToInt(inputDate);

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

    private Order createOrder(String inputOrder) {
        String orderSeparator = "-";

        String[] separatedOrder = inputOrder.split(orderSeparator, -1);
        validateSeparatedOrderFormat(separatedOrder);

        return Order.createOrder(separatedOrder[0], parseStringToInt(separatedOrder[1]));
    }

    private void validateSeparatedOrderFormat(String[] separatedOrder) {
        if (separatedOrder.length != 2) {
            throw new IllegalArgumentException(ErrorMessage.MENU_NOT_PROPER.getMessage());
        }
    }

    //todo: VisitDate, Quantity에 동일하게 사용 중 -> 변경?
    private Integer parseStringToInt(String value) {
        Integer formattedValue = null;

        try {
            formattedValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_INT.getMessage());
        }

        return formattedValue;
    }

    private String refineInputOrders(String inputOrders) {
        return inputOrders.replaceAll("\\s", "");
    }
}
