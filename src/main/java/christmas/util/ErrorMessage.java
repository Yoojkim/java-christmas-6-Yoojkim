package christmas.util;

public enum ErrorMessage {
    INPUT_IS_EMPTY("입력되지 않았습니다."),
    VISIT_DATE_RANGE("유효하지 않은 날짜입니다."),
    MENU_NOT_PROPER("유효하지 않은 주문입니다."),
    EXCEED_MAX_ORDER("최대 주문 메뉴 갯수(20개)를 초과하였습니다."),
    ONLY_DRINK_TYPE_MENU("음료만 주문 시, 주문할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + this.message;
    }
}
