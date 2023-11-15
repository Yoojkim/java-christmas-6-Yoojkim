package christmas.service;

import christmas.domain.Benefit;
import christmas.domain.OrderSheet;

public class BenefitService {
    public Benefit calculateBenefit(OrderSheet orderSheet) {
        if (!orderSheet.isEventTarget()) {
            return Benefit.builder().build();
        }

        return Benefit.builder()
                .christMasDiscount(orderSheet.calculateChristmasDiscount())
                .weekDiscount(orderSheet.calculateWeekDiscount())
                .specialDiscount(orderSheet.calculateSpecialDiscount())
                .giveAway(orderSheet.calculateGiveAway())
                .build();
    }
}
