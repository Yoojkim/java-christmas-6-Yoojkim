package christmas.view;

import christmas.dto.OrderDto;
import christmas.dto.OrdersDto;
import christmas.util.PrintMessage;

public class OutputView {
    public void printPrintMessage(PrintMessage printMessage) {
        System.out.print(printMessage.getMessage());
    }

    public void printStartEventBenefit(int visitDate) {
        printMessage(String.format(PrintMessage.START_EVENT_BENEFIT.getMessage(), visitDate));
    }

    public void printOrders(OrdersDto orders) {
        StringBuilder sb = new StringBuilder();
        sb.append("<주문 메뉴>\n");

        for(OrderDto order: orders.orders()){
            sb.append(String.format("%s %d개\n", order.menuName(), order.quantity()));
        }

        sb.append("\n");

        printMessage(sb.toString());
    }

    private void printMessage(String message) {
        System.out.print(message);
    }
}

