package com.lukafenir.playground.adventofcode.dayone;

import com.lukafenir.playground.adventofcode.dayone.DepthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DepthServiceWindowTest {

    @Test
    void givenEmptyListOfInputs_depthWindowCounterReturnsZero() {
        //given
        List<Integer> noInputs = new ArrayList<>();
        DepthService depthService = new DepthService();

        //when
        int depthIncreaseCounter = depthService.depthWindowCounter(noInputs);

        //then
        assertThat(depthIncreaseCounter).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("lessThanFourInputs")
    void givenListWithLessThanFourInputs_depthWindowCounterReturnsZero(List<Integer> inputs) {
        //given
        DepthService depthService = new DepthService();

        //when
        int depthIncreaseCounter = depthService.depthWindowCounter(inputs);

        //then
        assertThat(depthIncreaseCounter).isEqualTo(0);
    }

    static Stream<Arguments> lessThanFourInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList(123)),
                Arguments.of(Arrays.asList(123, 432)),
                Arguments.of(Arrays.asList(123, 432, 352))
        );
    }

    @Test
    void givenTwoWindowsWhichAreSameSize_depthWindowCounterReturnsZero() {
        //given
        List<Integer> increaseingWindows = Arrays.asList(123, 231, 300, 123);
        DepthService depthService = new DepthService();

        //when
        int depthIncreaseCounter = depthService.depthWindowCounter(increaseingWindows);

        //then
        assertThat(depthIncreaseCounter).isEqualTo(0);
    }

    @Test
    void givenTwoWindowsWhichIncrease_depthWindowCounterReturnsOne() {
        //given
        List<Integer> increaseingWindows = Arrays.asList(123, 231, 300, 125);
        DepthService depthService = new DepthService();

        //when
        int depthIncreaseCounter = depthService.depthWindowCounter(increaseingWindows);

        //then
        assertThat(depthIncreaseCounter).isEqualTo(1);
    }

    @Test
    void givenTwoWindowsWhichDecrease_depthWindowCounterReturnsZero() {
        //given
        List<Integer> increaseingWindows = Arrays.asList(123, 231, 300, 122);
        DepthService depthService = new DepthService();

        //when
        int depthIncreaseCounter = depthService.depthWindowCounter(increaseingWindows);

        //then
        assertThat(depthIncreaseCounter).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("depthMeasurementTestCases")
    void givenInputsWithMixedIncreaseAndDecrease_depthWindowCounterReturnsSevenIncreases(List<Integer> depthMeasurements, int expectedIncreaseCount) {
        //given
        DepthService depthService = new DepthService();

        //when
        int depthIncreaseCounter = depthService.depthWindowCounter(depthMeasurements);

        //then
        assertThat(depthIncreaseCounter).isEqualTo(expectedIncreaseCount);
    }

    static Stream<Arguments> depthMeasurementTestCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(123, 124, 278, 125, 200), 2),
                Arguments.of(Arrays.asList(123, 124, 278, 145, 101, 305, 900), 3),
                Arguments.of(Arrays.asList(999, 888, 777, 666, 555, 444, 333, 222, 111, 444), 1),
                Arguments.of(Arrays.asList(111, 111, 111, 111, 111, 111, 111, 111), 0),
                Arguments.of(Arrays.asList(111, 112, 115, 116, 118, 122, 131, 111), 4)
        );
    }
}
