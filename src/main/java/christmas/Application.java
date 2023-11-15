package christmas;

import christmas.controller.EventController;
import christmas.service.BenefitService;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        EventController eventController=new EventController(new InputView(), new OutputView(), new OrderService(), new BenefitService());
        eventController.game();
    }
}
