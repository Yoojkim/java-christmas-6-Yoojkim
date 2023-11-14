package christmas.view;

import christmas.util.PrintMessage;

public class OutputView {

    public void printMessage(PrintMessage message) {
        System.out.println(message.getMessage());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}

