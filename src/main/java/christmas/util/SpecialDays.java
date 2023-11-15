package christmas.util;

import christmas.domain.VisitDate;

import java.util.HashSet;
import java.util.Set;

public class SpecialDays {
    static final int[] days = new int[]{3, 10, 17, 24, 25, 31};
    static final Set<VisitDate> specialDays = new HashSet<>();

    static {
        for (int day : days) {
            specialDays.add(new VisitDate(day));
        }
    }

    private SpecialDays(){}

    public static boolean isSpecialDay(VisitDate date){
        return specialDays.contains(date);
    }
}
