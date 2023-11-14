package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.ErrorMessage;

public class InputView {
    public String input() {
        String input = Console.readLine();
        emptyValidate(input);

        return input;
    }

    private void emptyValidate(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY.getMessage());
        }
    }
}
