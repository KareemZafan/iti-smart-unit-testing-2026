package org.iti.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArrayListTests {

    @Mock
    ArrayList<String> myList;

    @Test
    void testArrayListSize() {
        // stub, 50 test doubles
        when(myList.size()).thenReturn(50).thenReturn(100);

        // invocation
        assertTrue(myList.size() > 0);

        System.out.println("Size = "+myList.size()); // 100

    }

    @Test
    void testGettingSpecificValue() {
        // stub, 50 test doubles
        when(myList.get(100)).thenReturn("Ahmed").thenReturn("Kareem");

        // invocation
        assertEquals("Ahmed", myList.get(100));

        assertEquals("Kareem", myList.get(100));

    }
}
