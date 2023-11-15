package christmas.util;

public enum Badge {
    NONE("", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String shape;
    private final int minPrice;

    Badge(String shape, int minPrice) {
        this.shape = shape;
        this.minPrice = minPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public String getShape() {
        return shape;
    }

    public static Badge getBadge(int allDiscountPrice) {
        Badge nowBadge = Badge.NONE;

        for (Badge badge : Badge.values()) {
            if (allDiscountPrice >= badge.getMinPrice()) {
                nowBadge = badge;
            }
        }

        return nowBadge;
    }
}
