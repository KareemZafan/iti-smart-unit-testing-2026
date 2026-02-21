package org.iti.test;

import org.iti.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StackTests {

    private MyStack myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack();
    }

    @Test
    void testPushElementsToStack() {
        /*myStack.push(1)
                .push(700)
                .push(600)
                .push(-1);*/

        myStack.push(List.of(1, 700, 600, -1));

        assertFalse(myStack.isStackEmpty());
        assertEquals(4, myStack.getStackSize());
        assertEquals(-1, myStack.getStackPeek());
        assertEquals(List.of(1, 700, 600), myStack.getStackElements());
    }

    @Test
    void testPopElementsFromStack() {
        assertTrue(myStack.isStackEmpty());
        var ex = assertThrowsExactly(IllegalStateException.class, () -> myStack.pop());
        assertTrue(ex.getMessage().contains("Stack is empty"));

        myStack.push(1)
                .push(700)
                .push(600)
                .push(-1)
                .push(20);


        assertFalse(myStack.isStackEmpty());
        assertEquals(5, myStack.getStackSize());
        assertEquals(20, myStack.getStackPeek());
        assertEquals(List.of(1, 700, 600, -1, 20), myStack.getStackElements());


        assertEquals(20, myStack.pop());
        assertEquals(-1, myStack.pop());
        assertFalse(myStack.isStackEmpty());
        assertEquals(3, myStack.getStackSize());
        assertEquals(600, myStack.getStackPeek());
        assertEquals(List.of(1, 700, 600), myStack.getStackElements());
    }
}
