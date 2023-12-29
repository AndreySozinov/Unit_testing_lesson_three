package ru.savrey;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SomeServiceTest {

    SomeService someService;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }

    // 3.1.
//    @ParameterizedTest
//    @ValueSource(ints = {3, 5, 6, 10, 15, 7})
//    void multipleThreeNotFiveReturnsFizz(int n) {
//        // assertEquals...
//    }

    @Test
    void dividableThreeNotFive() {
        String result = someService.fizzBuzz(3);
        assertEquals("Fizz", result);
    }

    @Test
    void dividableFiveNotThree() {
        String result = someService.fizzBuzz(5);
        assertEquals("Buzz", result);
    }

    @Test
    void dividableThreeAndFive() {
        String result = someService.fizzBuzz(15);
        assertEquals("FizzBuzz", result);
    }

    @Test
    void dividableNotThreeNotFive() {
        String result = someService.fizzBuzz(7);
        assertEquals("7", result);
    }

    // 3.2
    @Test
    void arrayBeginsWithSix() {
        boolean result = someService.firstLast6(new int[]{6, 1, 3, 5, 16});
        assertTrue(result);
    }

    @Test
    void arrayEndsWithSix() {
        boolean result = someService.firstLast6(new int[]{16, 1, 3, 5, 6});
        assertTrue(result);
    }

    @Test
    void arrayNotBeginsAndEndsWithSix() {
        boolean result = someService.firstLast6(new int[]{36, 1, 3, 5, 16});
        assertFalse(result);
    }

    // 3.3
    @ParameterizedTest
    @CsvSource({"50, 1000", "100, 0", "0, 2000"})
    void insufficientCoverageTest(int i, int result){
        assertThat(someService.calculatingDiscount(2000, i)).isEqualTo(result);
    }

    @Test
    void incorrectDiscountValue() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void incorrectPurchaseValue() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    // 3.4
    @ParameterizedTest
    @CsvSource({"1, 2, 3, 6", "13, 2, 3, 5", "1, 13, 3, 4", "1, 2, 13, 3"})
    void sumExceptThirteenTest(int a, int b, int c, int result) {
        assertEquals(result, someService.luckySum(a, b, c));
    }
}
