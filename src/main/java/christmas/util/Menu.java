package christmas.util;

import java.util.HashMap;
import java.util.Map;

public enum Menu {
    NONE("",0,MenuType.NONE),
    MUSHROOM_SOUP("양송이수프", 6000, MenuType.APPETIZER),
    TAPAS("타파스", 5500, MenuType.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, MenuType.APPETIZER),
    T_BONE_STEAK("티본스테이크", 55000, MenuType.MAIN),
    BBQ_RIB("바비큐립", 54000, MenuType.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuType.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuType.MAIN),
    CHOCOLATE_CAKE("초코케이크", 15000, MenuType.DESSERT),
    ICE_CREAM("아이스크림", 5000, MenuType.DESSERT),
    ZERO_COKE("제로콜라", 3000, MenuType.DRINK),
    RED_WINE("레드와인", 60000, MenuType.DRINK),
    CHAMPAGNE("샴페인", 25000, MenuType.DRINK);

    private static final Map<String, Menu> nameMap = new HashMap<>();
    private final String name;
    private final int cost;
    private final MenuType type;

    static {
        for (Menu menu : Menu.values()) {
            nameMap.put(menu.getName(), menu);
        }
    }

    Menu(String name, int cost, MenuType type) {
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public MenuType getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    public static Menu createMenu(String manuName) {
        validateMenuName(manuName);

        return nameMap.get(manuName);
    }

    public static void validateMenuName(String name) {
        if (!nameMap.containsKey(name)) {
            throw new IllegalArgumentException(ErrorMessage.MENU_NOT_PROPER.getMessage());
        }
    }

    public enum MenuType {
        APPETIZER, MAIN, DESSERT, DRINK, NONE
    }
}
