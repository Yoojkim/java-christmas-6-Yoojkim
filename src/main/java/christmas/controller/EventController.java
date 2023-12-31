package christmas.controller;

import christmas.domain.Benefit;
import christmas.domain.OrderSheet;
import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.dto.BenefitDto;
import christmas.dto.OrdersDto;
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
    private final BenefitService benefitService;

    public EventController(InputView inputView, OutputView outputView, OrderService orderService, BenefitService benefitService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.orderService = orderService;
        this.benefitService = benefitService;
    }

    public void event() {
        outputView.printPrintMessage(PrintMessage.START_EVENT_PLANNER);
        VisitDate visitDate = createVisitDate();
        Orders orders = createOrders();
        outputView.printStartEventBenefit(visitDate.getVisitDate());

        outputView.printOrders(OrdersDto.from(orders));
        OrderSheet orderSheet = new OrderSheet(orders, visitDate);
        Benefit benefit = benefitService.calculateBenefit(orderSheet);
        outputView.printBenefit(BenefitDto.from(orderSheet, benefit));
    }

    private VisitDate createVisitDate() {
        outputView.printPrintMessage(PrintMessage.INPUT_VISIT_DATE);

        return repeatInputForException(() -> {
            String input = inputView.input();
            return orderService.createVisitDate(input);
        });
    }

    private Orders createOrders() {
        outputView.printPrintMessage(PrintMessage.INPUT_ORDERS);

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
