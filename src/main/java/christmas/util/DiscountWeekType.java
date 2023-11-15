package christmas.util;

public enum DiscountWeekType {
    WEEKDAY(2023, Menu.MenuType.DESSERT, "평일"),
    WEEKEND(2023, Menu.MenuType.MAIN, "주말");
    private final int discountPrice;
    private final Menu.MenuType menuType;
    private final String typeName;

    DiscountWeekType(final int discountPrice, final Menu.MenuType menuType, final String typeName) {
        this.discountPrice = discountPrice;
        this.menuType = menuType;
        this.typeName = typeName;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public Menu.MenuType getMenuType() {
        return menuType;
    }

    public String getTypeName() {
        return typeName;
    }
}
