package com.makaryb.sampletester.sample.stage1;

import com.makaryb.sampletester.sample.stage1.PrimitiveFunctionCalculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class CalculatorFunctionalityTest {

    private final static String SYSTEM_PROPERTY_KEY = "sample_tester_";
    private final static String SYSTEM_PROPERTY_TRUE_VALUE = "true";
    private final static String SYSTEM_PROPERTY_FALSE_VALUE = "false";

    private final PrimitiveFunctionCalculator prf = new PrimitiveFunctionCalculator();

    /*
    General use, custom display names and disabled tests.
    Можно изменить отображаемое имя или отключить метод с комментарием.
     */

    @Test
    @DisplayName("Может ли сложить два числа")
    void checkAdd() {
        assertEquals(3, prf.add(1 ,2));
    }

    @Test
    @DisplayName("Может ли вычесть одно число из другого")
    void checkSubtract() {
        assertEquals(1, prf.sub(2, 1));
    }

    @Test
    @DisplayName("Может перемножить два числа")
    void checkMultiply() {
        assertEquals(8, prf.mul(2, 4));
    }

    @Test
    @DisplayName("Может ли разделить одно число на другое")
    @Disabled("Только для демонстрации")
    void checkDivide() {
        assertEquals(4, prf.div(8, 2));
    }

    /*
    Assumptions tests.
    Если условие assumeTrue() - true, то запустить тест,
    в противном случае тест будет прерван.
     */

    @Test
    void testOnlyWhenSystemPropertySet() {
        System.setProperty(SYSTEM_PROPERTY_KEY, SYSTEM_PROPERTY_TRUE_VALUE);
        assumeTrue(
                SYSTEM_PROPERTY_TRUE_VALUE.equals(
                        System.getProperty(SYSTEM_PROPERTY_KEY))
        );
        assertEquals(3, prf.add(1,2));
        System.clearProperty(SYSTEM_PROPERTY_KEY);
    }

    @Test
    void skipWhenSystemPropertyNotSet() {
        System.setProperty(SYSTEM_PROPERTY_KEY, SYSTEM_PROPERTY_FALSE_VALUE);
        assumeTrue(
                SYSTEM_PROPERTY_TRUE_VALUE.equals(
                        System.getProperty(SYSTEM_PROPERTY_KEY))
        );
        assertEquals(3, prf.add(1,2));
        System.clearProperty(SYSTEM_PROPERTY_KEY);
    }

    /*
    Nested tests.
    Аннотация @Nested позволяет использовать внутренние классы при разработке тестов,
    что позволяет иногда более удобным способом группировать/дополнять тесты.
     */

    @Nested
    class nestedMoreOrLess {

        @Test
        void checkAdd() {
            assertEquals(3, prf.add(1, 2));
        }

        @Test
        void checkSubtract() {
            assertEquals(1, prf.sub(2, 1));
        }
    }

    @Nested
    class nestedMultiplyOrDivide {

        @Test
        void checkMultiply() {
            assertEquals(8, prf.mul(2, 4));
        }

        @Test
        void checkDivide() {
            assertEquals(4, prf.div(8, 2));
        }
    }

    /*
    Tagging tests.
    Можно фильтровать тесты, помечая подмножество из них под уникальным именем.
     */

    @Tag("slow")
    @Test
    void runsSlowly() {
        assertEquals(3, prf.add(1, 2));
    }

    @Tag("fast")
    @Test
    void runsFast() {
        assertEquals(1, prf.sub(2, 1));
    }

    /*
    Repeated tests
    Аннотация @RepeatedTest сообщает JUnit, что данный тест нужно запустить несколько раз.
     */

    @RepeatedTest(10)
    void checkAddRepeated() {
        assertEquals(3, prf.add(1, 2));
    }

    @RepeatedTest(value = 5, name = "Iteration {currentRepetition} of {totalRepetitions}")
    void checkSubtractRepeated() {
        assertEquals(1, prf.sub(2, 1));
    }

    /*
    Parameterized tests
    Параметризированные тесты позволяют запускать тест несколько раз с различными входными данными.
     */

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void canAdd(int b) {
        assertTrue(prf.add(1, b) >= 2);
    }

    @ParameterizedTest(name = "can add {0} to {1} and receive {2}")
    @MethodSource("additionProvider")
    void canAddAndAssertExactResult(int a, int b, int result) {
        assertEquals(result, prf.add(a, b));
    }

    static Stream<Arguments> additionProvider() {
        return Stream.of(
                Arguments.of(1, 3, 4),
                Arguments.of(3, 4, 7),
                Arguments.of(10, 20, 30)
        );
    }

    /**
     * Dynamic test.
     * Позволяет объявлять и запускать тестовые примеры, сгенерированные во время выполнения.
     * В отличие от статических тестов, которые определяют фиксированное количество тестовых примеров во время компиляции,
     * динамические тесты позволяют динамически определять тестовые случаи во время выполнения.
     */
    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {
        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);

        return Arrays.asList(
                dynamicTest(
                        String.format("add %s to %s", a, b), () ->
                                assertTrue(prf.add(a, b) >= 0)),
                dynamicTest(
                        String.format("multiply %s with %s", a, b), () ->
                                assertTrue(prf.mul(a, b) >= 0))
        );
    }

    /**
     * TestInfo method injection test.
     *
     * @param testInfo
     */
    @DisplayName("Addition")
    @Tag("fast")
    @Tag("basic")
    @Test
    void add(
            TestInfo testInfo) {
        assertEquals("Addition", testInfo.getDisplayName());

        assertTrue(testInfo.getTags().contains("fast"));
        assertTrue(testInfo.getTags().contains("basic"));

        assertEquals(3, prf.add(1, 2));
    }

    /**
     * TestReporter method injection test.
     *
     * @param testReporter
     */
    @Test
    void add(
            TestReporter testReporter) {
        String ciEnv = System.getenv("CI");

        boolean ci = ciEnv != null ? Boolean.parseBoolean(ciEnv) : false;
        testReporter.publishEntry("ci", Boolean.toString(ci));

        assertEquals(3, prf.add(1, 2));
    }
}
