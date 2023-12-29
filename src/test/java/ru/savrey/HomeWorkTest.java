package ru.savrey;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class HomeWorkTest {

    HomeWork homeWork;

    @BeforeEach
    void setup() {
        homeWork = new HomeWork();
    }

    // Задание 1
    @Test
    void positiveEvenOddNumber() {
        assertTrue(homeWork.evenOddNumber(4));
    }

    @Test
    void negativeEvenOddNumber() {
        assertFalse(homeWork.evenOddNumber(3));
    }

    // Задание 2
    @Test
    void positiveNumberInInterval() {
        assertTrue(homeWork.numberInInterval(50));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 25, 100, 130})
    void negativeNumberInInterval(int i) {
        assertFalse(homeWork.numberInInterval(i));
    }
}
