package com.lukafenir.playground.adventofcode;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class DayOneTest {

    @Test
    void doDayOneTask() {
        System.out.println("========== Running Task ==========");
        InputReader inputReader = new InputReader();
        DepthService depthService = new DepthService();
        String fileAbsolutePath = new File("src/test/resources/day-one").getAbsolutePath();

        List<Integer> integers = inputReader.readIntsFromFile(fileAbsolutePath);
        System.out.println("Size of file");
        System.out.println(integers.size());
        int result = depthService.depthIncreaseCounter(integers);

        System.out.println("How many measurements are larger than the previous measurement?");
        System.out.println(result);
    }
}
