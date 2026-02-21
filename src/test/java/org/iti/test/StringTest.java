package org.iti.test;

import org.iti.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @ParameterizedTest
    @ValueSource(strings = {"level", "iti", "racecar", "madam", "bob"})
    void testValidPalindrome(String text) {
        assertTrue(stringUtils.isPalindrome(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ahmed", "iti-1", "career", "man", "uncle-bob"})
    void testInValidPalindrome(String text) {
        assertFalse(stringUtils.isPalindrome(text));
    }
}
