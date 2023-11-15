package christmas.service;

import christmas.domain.Benefit;
import christmas.domain.OrderSheet;

public class BenefitService {
    public Benefit calculateBenefit(OrderSheet orderSheet) {
        return Benefit.createBenefit(orderSheet);
    }
}
