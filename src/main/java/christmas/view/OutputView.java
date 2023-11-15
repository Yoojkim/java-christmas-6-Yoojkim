package christmas.view;

import christmas.dto.BenefitDto;
import christmas.dto.OrderDto;
import christmas.dto.OrdersDto;
import christmas.util.Badge;
import christmas.util.Menu;
import christmas.util.PrintMessage;

import java.text.DecimalFormat;

public class OutputView {
    public void printPrintMessage(final PrintMessage printMessage) {
        System.out.print(printMessage.getMessage());
    }

    public void printStartEventBenefit(final int visitDate) {
        printMessage(String.format(PrintMessage.START_EVENT_BENEFIT.getMessage(), visitDate));
    }

    public void printOrders(final OrdersDto orders) {
        StringBuilder sb = new StringBuilder();
        sb.append(PrintMessage.ORDER_MENU.getMessage());

        for (OrderDto order : orders.orders()) {
            sb.append(String.format(PrintMessage.MENU_MESSAGE_FORMAT.getMessage(), order.menuName(), order.quantity()));
        }

        sb.append("\n");

        printMessage(sb.toString());
    }

    public void printBenefit(final BenefitDto benefitDto) {
        StringBuilder sb = new StringBuilder();

        DecimalFormat df = new DecimalFormat("###,###");

        printBeforeDiscountPrice(sb, df.format(benefitDto.beforeDiscountPrice()));
        printGiveAway(sb, benefitDto);
        printBenefits(sb, benefitDto, df);
        printAllDiscount(sb, df.format(benefitDto.allDiscount() * -1));
        printAfterDiscountPrice(sb, df.format(benefitDto.afterDiscountPrice()));
        printBadge(sb, benefitDto);

        printMessage(sb.toString());
    }

    private void printBeforeDiscountPrice(final StringBuilder sb, final String beforeDiscountPrice) {
        sb.append(PrintMessage.BEFORE_DISCOUNT_PRICE.getMessage());
        sb.append(String.format(PrintMessage.PRICE_MESSAGE_FORMAT.getMessage(), beforeDiscountPrice)).append("\n");
    }

    private void printAfterDiscountPrice(final StringBuilder sb, final String afterDiscountPrice) {
        sb.append(PrintMessage.AFTER_DISCOUNT_PRICE.getMessage());
        sb.append(String.format(PrintMessage.PRICE_MESSAGE_FORMAT.getMessage(), afterDiscountPrice)).append("\n");
    }

    private void printGiveAway(final StringBuilder sb, final BenefitDto benefitDto) {
        sb.append(PrintMessage.GIVEAWAY.getMessage());

        if (benefitDto.giveAway() == Menu.NONE) {
            sb.append(PrintMessage.NONE.getMessage()).append("\n");
            return;
        }

        sb.append(String.format(PrintMessage.MENU_MESSAGE_FORMAT.getMessage(), benefitDto.giveAway().getName(), benefitDto.giveAwayQuantity())).append("\n");
    }

    private void printAllDiscount(final StringBuilder sb, final String allDiscountPrice) {
        sb.append(PrintMessage.ALL_DISCOUNT.getMessage());
        sb.append(String.format(PrintMessage.PRICE_MESSAGE_FORMAT.getMessage(), allDiscountPrice)).append("\n");
    }

    private void printBadge(final StringBuilder sb, final BenefitDto benefitDto) {
        sb.append(PrintMessage.BADGE.getMessage());

        if (benefitDto.badge() == Badge.NONE) {
            sb.append(PrintMessage.NONE.getMessage());
            return;
        }

        sb.append(benefitDto.badge().getShape()).append("\n");
    }

    private void printBenefits(final StringBuilder sb, final BenefitDto benefitDto, final DecimalFormat df) {
        sb.append(PrintMessage.BENEFIT_LIST.getMessage());

        if (benefitDto.allDiscount() == 0) {
            sb.append(PrintMessage.NONE.getMessage()).append("\n");
            return;
        }

        printChristmasDiscount(sb, benefitDto, df);
        printWeekDiscount(sb, benefitDto, df);
        printSpecialDiscount(sb, benefitDto, df);
        printGiveAwayDiscount(sb, benefitDto, df);

        sb.append("\n");
    }

    private void printChristmasDiscount(final StringBuilder sb, final BenefitDto benefitDto, final DecimalFormat df) {
        if (benefitDto.christMasDiscount() == 0) {
            return;
        }

        sb.append(String.format(PrintMessage.CHRISTMAS_DISCOUNT_MESSAGE_FORMAT.getMessage(), df.format(benefitDto.christMasDiscount() * -1)));
    }

    private void printWeekDiscount(final StringBuilder sb, final BenefitDto benefitDto, final DecimalFormat df) {
        if (benefitDto.weekDiscount() == 0) {
            return;
        }

        sb.append(String.format(PrintMessage.WEEK_DISCOUNT_MESSAGE_FORMAT.getMessage(), benefitDto.weekTypeName(), df.format(benefitDto.weekDiscount() * -1)));
    }

    private void printSpecialDiscount(final StringBuilder sb, final BenefitDto benefitDto, final DecimalFormat df) {
        if (benefitDto.specialDiscount() == 0) {
            return;
        }

        sb.append(String.format(PrintMessage.SPECIAL_DISCOUNT_MESSAGE_FORMAT.getMessage(), df.format(benefitDto.specialDiscount() * -1)));
    }

    private void printGiveAwayDiscount(final StringBuilder sb, final BenefitDto benefitDto, final DecimalFormat df) {
        if (benefitDto.giveAway().getCost() == 0) {
            return;
        }

        sb.append(String.format(PrintMessage.GIVEAWAY_DISCOUNT_MESSAGE_FORMAT.getMessage(), df.format(benefitDto.giveAway().getCost() * -1)));
    }

    private void printMessage(final String message) {
        System.out.print(message);
    }
}

