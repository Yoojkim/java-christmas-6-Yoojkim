package christmas.domain;

import christmas.util.ErrorMessage;

public class Quantity {
    private final int MIN = 1;
    private final int quantity;

    public Quantity(int quantity) {
        validateQuantity(quantity);
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    private void validateQuantity(int inputQuantity) {
        if (inputQuantity < MIN) {
            throw new IllegalArgumentException(ErrorMessage.MENU_NOT_PROPER.getMessage());
        }
    }
}
