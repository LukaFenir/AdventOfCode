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

class DepthServiceIncreaseTest {
    
    @Test
    void givenEmptyListOfInputs_depthIncCounterReturnsZero() {
        //given
        List<Integer> noInputs = new ArrayList<>();
        DepthService depthService = new DepthService();

        //when
        int depthIncreaseCounter = depthService.depthIncreaseCounter(noInputs);

        //then
        assertThat(depthIncreaseCounter).isEqualTo(0);
    }

    @Test
    void givenListWithOneInput_depthIncCounterReturnsZero() {
        //given
        List<Integer> oneInput = List.of(345);
        DepthService depthService = new DepthService();

        //when
        int depthIncreaseCounter = depthService.depthIncreaseCounter(oneInput);

        //then
        assertThat(depthIncreaseCounter).isEqualTo(0);
    }

    @Test
    void givenInputsWithOneIncrease_depthIncCounterReturnsOne() {
        //given
        List<Integer> oneIncrease = List.of(345, 346);
        DepthService depthService = new DepthService();

        //when
        int depthIncreaseCounter = depthService.depthIncreaseCounter(oneIncrease);

        //then
        assertThat(depthIncreaseCounter).isEqualTo(1);
    }

    @Test
    void givenInputsWithNoIncrease_depthIncCounterReturnsZero() {
        //given
        List<Integer> oneIncrease = List.of(345, 344);
        DepthService depthService = new DepthService();

        //when
        int depthIncreaseCounter = depthService.depthIncreaseCounter(oneIncrease);

        //then
        assertThat(depthIncreaseCounter).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("depthMeasurementTestCases")
    void givenInputsWithMixedIncreaseAndDecrease_depthIncCounterReturnsSevenIncreases(List<Integer> depthMeasurements, int expectedIncreaseCount) {
        //given
        DepthService depthService = new DepthService();

        //when
        int depthIncreaseCounter = depthService.depthIncreaseCounter(depthMeasurements);

        //then
        assertThat(depthIncreaseCounter).isEqualTo(expectedIncreaseCount);
    }

    static Stream<Arguments> depthMeasurementTestCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(123, 124, 278, 100), 2),
                Arguments.of(Arrays.asList(123, 124, 278, 100, 101, 134, 900), 5),
                Arguments.of(Arrays.asList(999, 888, 777, 666, 555, 444, 333, 222, 111, 112), 1),
                Arguments.of(Arrays.asList(111, 111, 111, 111, 111, 111, 111, 111), 0),
                Arguments.of(Arrays.asList(111, 112, 115, 116, 118, 122, 131, 111), 6)
        );
    }
}