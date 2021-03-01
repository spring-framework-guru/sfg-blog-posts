package com.springframeworkguru.parameterizedtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

public class DemoParameterizedTest {

    DemoParameterized demoParameterized;



    @ParameterizedTest
    @DisplayName("checks if the given string values ends with the alphabet r")
    @ValueSource(strings = {"radar","car","door"})
    void endsWithTest(String string){
        assertTrue(string.endsWith("r"));
    }

    @ParameterizedTest
    @NullSource
    void test_null(String arg) {
        assertTrue(arg == null);
    }
    @ParameterizedTest()
    @EmptySource
    void test_empty(String arg) {
        assertTrue(arg.isEmpty());
    }

    enum Days {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
    }

    @ParameterizedTest
    @EnumSource(Days.class)
    void test_enum(Days days) {
        assertNotNull(days);
    }

    @ParameterizedTest(name = "#{index} - contains {0}?")
    @DisplayName("Test to show the constants that are included")
    @EnumSource(value = Days.class, names = {"Saturday", "Sunday"})
    void test_enum_include(Days days) {
        assertTrue(EnumSet.allOf(Days.class).contains(days));
    }

    @ParameterizedTest
    @DisplayName("Test to show the values by excluding some")
    @EnumSource(value = Days.class, mode = EXCLUDE, names = {"Saturday", "Sunday"})
    void test_enum_exclude(Days days) {
        assertNotNull(days);
    }

    @ParameterizedTest
    @DisplayName("To check whether the length of the strings are same or not")
    @CsvSource({
            "apple,      5",
            "orange,   6",
    })
    void test_csv(String string, int length) {
        assertEquals(length, string.length());
    }

    @DisplayName("test to calculate the correct sum")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource( delimiter = '|', value = {"5| 1| 6", "3| 3| 6"
    })
    void sum(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }


    @ParameterizedTest
   // @MethodSource("com.springframeworkguru.parameterizedtest.TestParameter#providedStringsIsPalindrome")
    @MethodSource("providedStringsIsPalindrome")
    void isPlindromeString(String input, boolean expected) {
        demoParameterized = new DemoParameterized();
        assertEquals(expected, demoParameterized.isPalindrome(input));
    }

    private static Stream<Arguments> providedStringsIsPalindrome() {
        return Stream.of(
                Arguments.of("word", false),
                Arguments.of("mom", true),
                Arguments.of("level", true),
                Arguments.of("pass", false)
        );
    }

}
