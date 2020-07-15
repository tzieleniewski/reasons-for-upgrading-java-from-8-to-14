package com.github.tzieleniewski;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.Map;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.TUESDAY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class Java14Test {

    @Test
    void switchExpression() {
        // when
        classifyDayOfWeekInArrowForm(TUESDAY);
        classifyDayOfWeekInColonForm(TUESDAY);
        //
        assertThat(isWorkingDay(FRIDAY), equalTo(true));
    }

    @Test
    void verboseNpe() {
        // given
        var key = "igp";
        var igp = Map.of(key, Element.builder().build());
        // then
        assertThrows(NullPointerException.class, () -> igp.get(key).getName().isEmpty());
    }

    @Builder
    @Data
    private static class Element {

        String name;
    }

    private void classifyDayOfWeekInArrowForm(DayOfWeek day) {
        switch (day) {
            case MONDAY, TUESDAY -> log.info("Working day, first part of the week");
            case WEDNESDAY -> log.info("Working day, middle of the week");
            case THURSDAY, FRIDAY -> log.info("Working day, second part of the week");
            default -> log.info("Weekend");
        }
    }

    private void classifyDayOfWeekInColonForm(DayOfWeek day) {
        switch (day) {
            case MONDAY, TUESDAY:
                log.info("Working day, first part of the week");
                break;
            case WEDNESDAY:
                log.info("Working day, middle of the week");
                break;
            case THURSDAY, FRIDAY:
                log.info("Working day, second part of the week");
                break;
            default:
                log.info("Weekend");
        }
    }

    private boolean isWorkingDay(DayOfWeek day) {
        return switch (day) {
            case FRIDAY -> {
                log.warn("Hard to say");
                yield true;
            }
            case SATURDAY, SUNDAY -> false;
            default -> true;
        };
    }
}
