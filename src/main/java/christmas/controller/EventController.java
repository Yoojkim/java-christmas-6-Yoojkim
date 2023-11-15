package christmas.controller;

import christmas.domain.Benefit;
import christmas.domain.OrderSheet;
import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.formatter.StringFormatter;
import christmas.service.BenefitService;
import christmas.service.OrderService;
import christmas.util.PrintMessage;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.function.Supplier;

public class EventController {
    private final InputView inputView;
    private final OutputView outputView;
    private final OrderService orderService;
    private final StringFormatter stringFormatter;
    private final BenefitService benefitService;

    //todo: Config 이용
    public EventController() {
        inputView = new InputView();
        outputView = new OutputView();
        orderService = new OrderService();
        stringFormatter = new StringFormatter();
        benefitService = new BenefitService();
    }

    public void game() {
        outputView.printMessage(PrintMessage.START_EVENT_PLANNER);

        VisitDate visitDate = createVisitDate();
        Orders orders = createOrders();

        outputView.printMessage(stringFormatter.getFormattedStartEventBenefitMessage(visitDate));

        Benefit benefit = benefitService.calculateBenefit(new OrderSheet(orders, visitDate));
    }


    private VisitDate createVisitDate() {
        outputView.printMessage(PrintMessage.INPUT_VISIT_DATE);

        return repeatInputForException(() -> {
            String input = inputView.input();
            return orderService.createVisitDate(input);
        });
    }

    private Orders createOrders() {
        outputView.printMessage(PrintMessage.INPUT_ORDERS);

        return repeatInputForException(() -> {
            String input = inputView.input();
            return orderService.createOrders(input);
        });
    }

    private <T> T repeatInputForException(Supplier<T> createDomainSupplier) {
        boolean flag = false;
        T domain = null;

        while (!flag) {
            try {
                domain = createDomainSupplier.get();
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " 다시 입력해 주세요.");
            }
        }

        return domain;
    }
}
