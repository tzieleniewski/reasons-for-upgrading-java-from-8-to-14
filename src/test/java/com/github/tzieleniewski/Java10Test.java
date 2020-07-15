package com.github.tzieleniewski;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Long.parseLong;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class Java10Test {

    @Test
    void localVariableTypeInference() {
        // given
        var asLong = 1L;
        var asString = "1";
        // then
        assertThat(asLong, equalTo(parseLong(asString)));
    }
}
