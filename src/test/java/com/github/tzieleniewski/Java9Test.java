package com.github.tzieleniewski;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class Java9Test {

    @Test
    void setOfInJava8() {
        // when
        Set<String> igp = new HashSet<>(asList("In", "Green", "Pastures"));
        // then
        assertThat(igp, hasSize(3));
    }

    @Test
    void setOfInJava9() {
        // given
        Set<String> igp = Set.of("In", "Green", "Pastures");
        // then
        assertThat(igp, hasSize(3));
    }

    @Test
    void streamOfNullableInJava8() {
        // when
        List<String> igp = Stream.of(null, "In", "Green", "Pastures", null)
                                 .flatMap(word -> isNull(word) ? Stream.empty() : Stream.of(word))
                                 .collect(toList());
        // then
        assertThat(igp, hasSize(3));
    }

    @Test
    void streamOfNullableInJava9() {
        // given
        List<String> igp = Stream.of(null, "In", "Green", "Pastures", null)
                                 .flatMap(Stream::ofNullable)
                                 .collect(toList());
        // then
        assertThat(igp, hasSize(3));
    }
}
