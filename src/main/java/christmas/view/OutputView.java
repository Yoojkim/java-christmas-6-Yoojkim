package christmas.view;


import christmas.util.ErrorMessage;
import christmas.util.PrintMessage;

public class OutputView {
    public void printPrintMessage(PrintMessage printMessage) {
        System.out.print(printMessage.getMessage());
    }

    public void printStartEventBenefit(int visitDate) {
        printMessage(String.format(PrintMessage.START_EVENT_BENEFIT.getMessage(), visitDate));
    }

    public void printOrders() {

    }

    private void printMessage(String message) {
        System.out.print(message);
    }
}

