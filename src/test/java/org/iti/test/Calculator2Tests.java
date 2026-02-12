package org.iti.test;

import org.iti.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

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

    @Test
    @Tag("FEB-RELEASE")
    @DisplayName("Feature-123 Add- Functionality")
    void testAddFunctionality() {
        // Arrange

        // Act, Assert
        assertEquals(80, calculator.add(10, 70));
        assertEquals(-40, calculator.add(-10, -30));
        assertEquals(-30, calculator.add(0, -30));
        assertEquals(20, calculator.add(50, -30));

    }

    @Test
    @DisplayName("Feature-123 Sub- Functionality")
    void testSubtractFunctionality() {
        // Arrange

        // Act, Assert
        assertEquals(-60, calculator.sub(10, 70));
        assertEquals(20, calculator.sub(-10, -30));
        assertEquals(30, calculator.sub(0, -30));
        assertEquals(80, calculator.sub(50, -30));

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


}
