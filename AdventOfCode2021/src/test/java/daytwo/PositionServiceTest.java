package daytwo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static daytwo.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PositionServiceTest {
    
    PositionService positionService = new PositionService();

    @Test
    void givenEmptyListOfInputs_calculationReturnsDefaultPosition() {
        //given
        List<Instruction> noInputs = new ArrayList<>();

        //when
        Position position = positionService.calculatePosition(noInputs);

        //then
        assertThat(position.getHorizontal()).isEqualTo(0);
        assertThat(position.getVertical()).isEqualTo(0);
    }

    @Test
    void givenOneForwardInput_calculationReturnsPositionMovedHorizontally() {
        //given
        List<Instruction> moveForward = List.of(new Instruction(FORWARD, 8));

        //when
        Position position = positionService.calculatePosition(moveForward);

        //then
        assertThat(position.getHorizontal()).isEqualTo(8);
        assertThat(position.getVertical()).isEqualTo(0);
    }

    @Test
    void givenOneDownInput_calculationReturnsPositionMovedVertically() {
        //given
        List<Instruction> moveDown = List.of(new Instruction(DOWN, 8));

        //when
        Position position = positionService.calculatePosition(moveDown);

        //then
        assertThat(position.getHorizontal()).isEqualTo(0);
        assertThat(position.getVertical()).isEqualTo(8);
    }

    @Test
    void givenUpInputFromStartingPosition_calculationReturnsZeroVerticalPosition() {
        //given
        List<Instruction> moveUp = List.of(new Instruction(UP, 8));

        //when
        Position position = positionService.calculatePosition(moveUp);

        //then
        assertThat(position.getHorizontal()).isEqualTo(0);
        assertThat(position.getVertical()).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("positionCalculationTestCases")
    void givenListsOfInstructions_calculationReturnsFinalPosition(List<Instruction> instructions, Position expectedPosition) {
        //when
        Position position = positionService.calculatePosition(instructions);

        //then
        assertThat(position.getHorizontal()).isEqualTo(expectedPosition.getHorizontal());
        assertThat(position.getVertical()).isEqualTo(expectedPosition.getVertical());
    }

    static Stream<Arguments> positionCalculationTestCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Instruction(FORWARD, 5), new Instruction(DOWN, 5)), 
                        new Position(5, 5)),
                Arguments.of(Arrays.asList(new Instruction(DOWN, 15), new Instruction(FORWARD, 2), new Instruction(UP, 1)), 
                        new Position(2, 14)),
                Arguments.of(Arrays.asList(new Instruction(DOWN, 2), new Instruction(FORWARD, 42), new Instruction(UP, 3)),
                        new Position(42, 0)),
                Arguments.of(Arrays.asList(new Instruction(DOWN, 2), new Instruction(DOWN, 42), new Instruction(DOWN, 3)),
                        new Position(0, 47)),
                Arguments.of(Arrays.asList(new Instruction(FORWARD, 2), new Instruction(FORWARD, 42), new Instruction(UP, 3)),
                        new Position(44, 0))
        );
    }
    
    /**
     * Part 2 - Complicated calculation
     */

    @Test
    void givenEmptyListOfInputs_calculationV2ReturnsDefaultPosition() {
        //given
        List<Instruction> noInputs = new ArrayList<>();

        //when
        Position position = positionService.calculatePositionV2(noInputs);

        //then
        assertThat(position.getHorizontal()).isEqualTo(0);
        assertThat(position.getVertical()).isEqualTo(0);
    }

    @Test
    void givenOneForwardInput_calculationV2ReturnsPositionMovedHorizontally() {
        //given
        List<Instruction> moveForward = List.of(new Instruction(FORWARD, 8));

        //when
        Position position = positionService.calculatePositionV2(moveForward);

        //then
        assertThat(position.getHorizontal()).isEqualTo(8);
        assertThat(position.getVertical()).isEqualTo(0);
        assertThat(position.getAim()).isEqualTo(0);
    }

    @Test
    void givenOneDownInput_calculationV2ReturnsPositionAimIncreased() {
        //given
        List<Instruction> moveDown = List.of(new Instruction(DOWN, 8));

        //when
        Position position = positionService.calculatePositionV2(moveDown);

        //then
        assertThat(position.getHorizontal()).isEqualTo(0);
        assertThat(position.getVertical()).isEqualTo(0);
        assertThat(position.getAim()).isEqualTo(8);
    }

    @Test
    void givenUpInputFromStartingPosition_calculationV2ReturnsDefaultAim() {
        //given
        List<Instruction> moveUp = List.of(new Instruction(UP, 8));

        //when
        Position position = positionService.calculatePositionV2(moveUp);

        //then
        assertThat(position.getHorizontal()).isEqualTo(0);
        assertThat(position.getVertical()).isEqualTo(0);
        assertThat(position.getAim()).isEqualTo(0);
    }

    @Test
    void givenForwardAndDownInstructions_calculationV2ReturnsChangeInHorizontalPosition() {
        //given
        List<Instruction> moveUp = List.of(new Instruction(FORWARD, 8), new Instruction(DOWN, 8));

        //when
        Position position = positionService.calculatePositionV2(moveUp);

        //then
        assertThat(position.getHorizontal()).isEqualTo(8);
        assertThat(position.getVertical()).isEqualTo(0);
        assertThat(position.getAim()).isEqualTo(8);
    }

    @Test
    void givenDownAndForwardInstructions_calculationV2ReturnsChangeInHorizontalAndVerticalPosition() {
        //given
        List<Instruction> moveUp = List.of(new Instruction(DOWN, 8), new Instruction(FORWARD, 8));

        //when
        Position position = positionService.calculatePositionV2(moveUp);

        //then
        assertThat(position.getHorizontal()).isEqualTo(8);
        assertThat(position.getVertical()).isEqualTo(64);
        assertThat(position.getAim()).isEqualTo(8);
    }

    @ParameterizedTest
    @MethodSource("positionCalculationV2TestCases")
    void givenListsOfInstructions_calculationV2ReturnsFinalPosition(List<Instruction> instructions, Position expectedPosition) {
        //when
        Position position = positionService.calculatePositionV2(instructions);

        //then
        assertThat(position.getHorizontal()).isEqualTo(expectedPosition.getHorizontal());
        assertThat(position.getVertical()).isEqualTo(expectedPosition.getVertical());
        assertThat(position.getAim()).isEqualTo(expectedPosition.getAim());
    }

    static Stream<Arguments> positionCalculationV2TestCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Instruction(FORWARD, 5), new Instruction(DOWN, 5)),
                        new Position(5, 0, 5)),
                Arguments.of(Arrays.asList(new Instruction(DOWN, 15), new Instruction(FORWARD, 2), new Instruction(UP, 1)),
                        new Position(2, 15 * 2, 14)),
                Arguments.of(Arrays.asList(new Instruction(DOWN, 2), new Instruction(FORWARD, 42), new Instruction(UP, 3), new Instruction(FORWARD, 3)),
                        new Position(45, 84, 0)),
                Arguments.of(Arrays.asList(new Instruction(DOWN, 2), new Instruction(DOWN, 42), new Instruction(DOWN, 3), new Instruction(FORWARD, 18)),
                        new Position(18, 846, 47)),
                Arguments.of(Arrays.asList(new Instruction(FORWARD, 2), new Instruction(FORWARD, 42), new Instruction(DOWN, 3), new Instruction(FORWARD, 999)),
                        new Position(1043, 2997, 3)),
                Arguments.of(Arrays.asList(new Instruction(FORWARD, 2), new Instruction(FORWARD, 42), new Instruction(UP, 3), new Instruction(FORWARD, 999)),
                        new Position(1043, 0, 0))
        );
    }
}
