package christmas.formatter;

import christmas.domain.VisitDate;
import christmas.util.PrintMessage;

public class StringFormatter {
    public String getFormattedStartEventBenefitMessage(VisitDate visitDate) {
        return String.format(PrintMessage.START_EVENT_BENEFIT.getMessage(), visitDate.getVisitDate());
    }
}
