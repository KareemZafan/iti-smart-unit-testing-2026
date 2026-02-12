package org.iti.test;

import org.iti.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {
    private static Calculator calculator;

    /*@BeforeEach
    void beforeEachTest() {
        System.out.println("Before each test");
        calculator = new Calculator();
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("After each test");
    }*/

    @BeforeAll
    static void beforeAllTests() {
        calculator = new Calculator();
        System.out.println("Before all tests");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("After all tests");
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(10, 70, -60),
                Arguments.of(1, 70, -69),
                Arguments.of(30, 10, 20),
                Arguments.of(0, 70, -70),
                Arguments.of(10, 0, 10),
                Arguments.of(10, -10, 20)
        );
    }

    static Stream<Arguments> provideTestDataForOddEvenMethod() {
        return Stream.of(
                Arguments.of(1, false),
                Arguments.of(2, true),
                Arguments.of(3, false),
                Arguments.of(80, true),
                Arguments.of(101, false)
        );
    }

    @ParameterizedTest
    @Tag("FEB-RELEASE")
    @DisplayName("Feature-123 Add- Functionality")
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void testAddFunctionality(String input1, String input2, String result) {
        // Arrange
        // Act, Assert
        assertEquals(Double.parseDouble(result), calculator.add(Double.parseDouble(input1), Double.parseDouble(input2)));
    }

    @ParameterizedTest
    @MethodSource(value = "provideTestData")
    @DisplayName("Feature-123 Sub- Functionality")
    void testSubtractFunctionality(double input1, double input2, double result) {
        // Arrange

        // Act, Assert
        assertEquals(result, calculator.sub(input1, input2));

    }

    @Test
    @DisplayName("Feature-123 Mul- Functionality")
    void testMultiplyFunctionality() {
        // Arrange

        // Act, Assert
        assertEquals(700, calculator.mul(10, 70));
        assertEquals(300, calculator.mul(-10, -30));
        assertEquals(0, calculator.mul(0, 30));
        assertEquals(-1500, calculator.mul(50, -30));
    }

    @Test
    @DisplayName("Feature-123 Div- Functionality")
    void testDivideFunctionality() {
        // Arrange
        assertEquals(2, calculator.div(50, 25));
        assertEquals(0, calculator.div(0, 25));
        assertEquals(4, calculator.div(-100, -25));
        assertEquals(-4, calculator.div(-100, 25));

        Exception ex = assertThrowsExactly(ArithmeticException.class, () -> calculator.div(2, 0));
        assertEquals("Dividing by zero", ex.getMessage());
    }

    @Test
    @Tag("FEB-RELEASE")
    void testModFunctionality() {
        // Arrange
        assertEquals(1, calculator.mod(13, 6));
        assertEquals(2, calculator.mod(12, 5));
        assertEquals(0, calculator.mod(12, 6));

        var ex = assertThrowsExactly(ArithmeticException.class, () -> calculator.mod(2, 0));
        assertEquals("Dividing by zero", ex.getMessage());

    }

    @Test
    @Tag("FEB-RELEASE")
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_10)
    void testSquareRootFunctionality() {
        // Arrange
        assertEquals(13, calculator.getSquareRoot(169));
        assertEquals(0, calculator.getSquareRoot(0));
        assertEquals(25, calculator.getSquareRoot(625));

        var ex = assertThrowsExactly(ArithmeticException.class, () -> calculator.getSquareRoot(-5));
        assertEquals("Negative numbers are not allowed", ex.getMessage());
    }

    private boolean isEven(int number) {
        return (number & 1) == 0;
    }

    @ParameterizedTest
    @MethodSource(value = "provideTestDataForOddEvenMethod")
    void testIsEven(int number, boolean isEven) {
        assertEquals(isEven, isEven(number));
    }

}
