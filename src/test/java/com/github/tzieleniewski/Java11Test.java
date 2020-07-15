package com.github.tzieleniewski;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class Java11Test {

    @Test
    void string() {
        // when
        var igp = Stream.of("", " In ", " Green ", " Pastures ")
              .filter(not(String::isBlank))
              .map(String::strip)
              .collect(toList());
        // then
        assertThat(igp, hasSize(3));
    }
}
