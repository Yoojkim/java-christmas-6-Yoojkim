package christmas.util;

public enum PrintMessage {
    START_EVENT_PLANNER("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"),
    INPUT_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n"),
    INPUT_ORDERS("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n"),
    START_EVENT_BENEFIT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n"),
    ORDER_MENU("<주문 메뉴>\n"),
    BEFORE_DISCOUNT_PRICE("<할인 전 총주문 금액>\n"),
    GIVEAWAY("<증정 메뉴>\n"),
    BENEFIT_LIST("<혜택 내역>\n"),
    ALL_DISCOUNT("<총혜택 금액>\n"),
    AFTER_DISCOUNT_PRICE("<할인 후 예상 결제 금액>\n"),
    BADGE("<12월 이벤트 배지>\n"),
    MENU_MESSAGE_FORMAT("%s %d개\n"),
    PRICE_MESSAGE_FORMAT("%s원\n"),
    CHRISTMAS_DISCOUNT_MESSAGE_FORMAT("크리스마스 디데이 할인: %s원\n"),
    WEEK_DISCOUNT_MESSAGE_FORMAT("%s 할인: %s원\n"),
    SPECIAL_DISCOUNT_MESSAGE_FORMAT("특별 할인: %s원\n"),
    GIVEAWAY_DISCOUNT_MESSAGE_FORMAT("증정 이벤트: %s원\n"),
    NONE("없음\n");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
