package daytwo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static daytwo.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionParserTest {
    
    private PositionParser positionParser = new PositionParser();
    
    @Test
    void givenEmptyListOfInputs_positionParserReturnsEmptyList() {
        //given
        List<String> noInputs = new ArrayList<>();
        
        //when
        List<Instruction> instructions = positionParser.parseInstructions(noInputs);

        assertThat(instructions.size()).isEqualTo(0);
    }

    @Test
    void givenOneInput_positionParserReturnsArrayOfOneInstruction() {
        //given
        List<String> oneInput = List.of("forward 5");

        //when
        List<Instruction> instructions = positionParser.parseInstructions(oneInput);

        assertThat(instructions.size()).isEqualTo(1);
        assertThat(instructions.get(0)).isEqualTo(new Instruction(FORWARD, 5));
    }

    @Test
    void givenListOfInputs_positionParserReturnsArrayOfInstruction() {
        //given
        List<String> inputs = List.of("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2");

        //when
        List<Instruction> instructions = positionParser.parseInstructions(inputs);

        assertThat(instructions.size()).isEqualTo(6);
        assertThat(instructions.get(0)).isEqualTo(new Instruction(FORWARD, 5));
        assertThat(instructions.get(1)).isEqualTo(new Instruction(DOWN, 5));
        assertThat(instructions.get(2)).isEqualTo(new Instruction(FORWARD, 8));
        assertThat(instructions.get(3)).isEqualTo(new Instruction(UP, 3));
        assertThat(instructions.get(4)).isEqualTo(new Instruction(DOWN, 8));
        assertThat(instructions.get(5)).isEqualTo(new Instruction(FORWARD, 2));
    }

    @Test
    void givenNonMovementInputs_parserThrowsAnException() {
        //given
        List<String> oneInput = List.of("backward 5");

        //then
        assertThatThrownBy(() -> positionParser.parseInstructions(oneInput))
                .isInstanceOf(Exception.class)
                .hasMessage("Error parsing instructions: No enum constant daytwo.Direction.BACKWARD");
    }

    @Test
    void givenNonNumericalDistance_parserThrowsAnException() {
        //given
        List<String> oneInput = List.of("forward z");

        //then
        assertThatThrownBy(() -> positionParser.parseInstructions(oneInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Error parsing instructions: For input string: \"z\"");
    }
}
