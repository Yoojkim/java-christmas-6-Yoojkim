package christmas.dto;

import christmas.domain.Benefit;
import christmas.domain.OrderSheet;
import christmas.util.Badge;
import christmas.util.Menu;

public record BenefitDto(int beforeDiscountPrice, Menu giveAway, int christMasDiscount,
                         int weekDiscount, int specialDiscount, String weekTypeName,
                         int allDiscount, int afterDiscountPrice, Badge badge) {
    public static BenefitDto from(OrderSheet orderSheet, Benefit benefit) {
        int orderSheetPrice = orderSheet.calculateAllPrice();

        return new BenefitDto(orderSheetPrice,
                benefit.getGiveAway(),
                benefit.getChristMasDiscount(),
                benefit.getWeekDiscount(),
                benefit.getSpecialDiscount(),
                orderSheet.getWeekType().getTypeName(),
                benefit.getAllDiscount(),
                orderSheetPrice - (benefit.getChristMasDiscount() + benefit.getSpecialDiscount() + benefit.getWeekDiscount()),
                benefit.getBadge());
    }
}
