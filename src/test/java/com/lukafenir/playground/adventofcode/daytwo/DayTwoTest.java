package com.lukafenir.playground.adventofcode.daytwo;

import com.lukafenir.playground.adventofcode.common.InputReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayTwoTest {
    
    @Test
    void exampleCase(){
        System.out.println("========== Running Task ==========");
        InputReader inputReader = new InputReader();
        PositionParser positionParser = new PositionParser();
        PositionService positionService = new PositionService();
        String fileAbsolutePath = new File("src/test/resources/daytwo/example").getAbsolutePath();

        List<String> inputs = inputReader.readStringsFromFile(fileAbsolutePath);
        assertThat(inputs.size()).isEqualTo(6);

        Position position = positionService.calculatePosition(positionParser.parseInstructions(inputs));

        System.out.println("What position is the submarine at?");
        System.out.println("Horizontal: " + position.getHorizontal() + ", Vertical: " + position.getVertical());
        assertThat(position.getHorizontal()).isEqualTo(15);
        assertThat(position.getVertical()).isEqualTo(10);
    }

    @Test
    void doDayTwoTask(){
        System.out.println("========== Running Task ==========");
        InputReader inputReader = new InputReader();
        PositionParser positionParser = new PositionParser();
        PositionService positionService = new PositionService();
        String fileAbsolutePath = new File("src/test/resources/daytwo/day-two").getAbsolutePath();

        List<String> inputs = inputReader.readStringsFromFile(fileAbsolutePath);
        assertThat(inputs.size()).isEqualTo(1000);

        Position position = positionService.calculatePosition(positionParser.parseInstructions(inputs));

        System.out.println("What position is the submarine at?");
        System.out.println("Horizontal: " + position.getHorizontal() + ", Vertical: " + position.getVertical());
        System.out.println("Multiplied: " + (position.getHorizontal() * position.getVertical()));
    }

    @Test
    void v2ExampleCase(){
        System.out.println("========== Running Task ==========");
        InputReader inputReader = new InputReader();
        PositionParser positionParser = new PositionParser();
        PositionService positionService = new PositionService();
        String fileAbsolutePath = new File("src/test/resources/daytwo/example").getAbsolutePath();

        List<String> inputs = inputReader.readStringsFromFile(fileAbsolutePath);
        assertThat(inputs.size()).isEqualTo(6);

        Position position = positionService.calculatePositionV2(positionParser.parseInstructions(inputs));

        System.out.println("What position is the submarine at?");
        System.out.println("Horizontal: " + position.getHorizontal() + ", Vertical: " + position.getVertical());
        assertThat(position.getHorizontal()).isEqualTo(15);
        assertThat(position.getVertical()).isEqualTo(60);
    }

    @Test
    void doDayTwoTaskV2(){
        System.out.println("========== Running Task ==========");
        InputReader inputReader = new InputReader();
        PositionParser positionParser = new PositionParser();
        PositionService positionService = new PositionService();
        String fileAbsolutePath = new File("src/test/resources/daytwo/day-two").getAbsolutePath();

        List<String> inputs = inputReader.readStringsFromFile(fileAbsolutePath);
        assertThat(inputs.size()).isEqualTo(1000);

        Position position = positionService.calculatePositionV2(positionParser.parseInstructions(inputs));

        System.out.println("What position is the submarine at?");
        System.out.println("Horizontal: " + position.getHorizontal() + ", Vertical: " + position.getVertical());
        System.out.println("Multiplied: " + (position.getHorizontal() * position.getVertical()));
    }
}
