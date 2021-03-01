package com.springframeworkguru.parameterizedtest;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestParameter {

    private static Stream<Arguments> providedStringsIsPalindrome() {
        return Stream.of(
                Arguments.of("word", false),
                Arguments.of("mom", true),
                Arguments.of("level", true),
                Arguments.of("pass", false)
        );
    }
}
