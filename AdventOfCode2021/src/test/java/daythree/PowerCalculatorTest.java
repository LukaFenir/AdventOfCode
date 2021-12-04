package daythree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PowerCalculatorTest {

    @Test
    void givenEmptyListOfInputs_calculationReturnsZeroPowerConsumption() {
        //given
        List<String> noInputs = new ArrayList<>();
        PowerCalculator powerCalculator = new PowerCalculator();

        //when
        PowerConsumption powerConsumption = powerCalculator.calculatePowerConsumption(noInputs);
        
        //then
        assertThat(powerConsumption.getGammaRate()).isEqualTo(0);
        assertThat(powerConsumption.getEpsilonRate()).isEqualTo(0);
    }

    @Test
    void givenListWithNonBinaryInput_calculationThrowsAnException() {
        //given
        String input = "011110011410";
        List<String> oneInput = List.of(input);
        PowerCalculator powerCalculator = new PowerCalculator();

        //then
        assertThatThrownBy(() -> powerCalculator.calculatePowerConsumption(oneInput))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("For input string: 011110011410");
    }

    @Test
    void givenListWithOneInput_calculationReturnsGammaRateThatsTheSameAsTheInput() {
        //given
        String input = "011110011110";
        List<String> oneInput = List.of(input);
        PowerCalculator powerCalculator = new PowerCalculator();

        //when
        PowerConsumption powerConsumption = powerCalculator.calculatePowerConsumption(oneInput);

        //then
        assertThat(powerConsumption.getGammaRate()).isEqualTo(1950);
        assertThat(powerConsumption.getEpsilonRate()).isEqualTo(2145);
    }

    @Test
    void givenListWithTwoInputs_calculationReturnsCorrectGammaAndEpsilonRate() {
        //given
        String input1 = "011110011110";
        String input2 = "101101001111";
        String input3 = "000000010101";
        List<String> oneInput = List.of(input1, input2, input3);
        PowerCalculator powerCalculator = new PowerCalculator();

        //when
        PowerConsumption powerConsumption = powerCalculator.calculatePowerConsumption(oneInput);

        //then
        assertThat(powerConsumption.getGammaRate()).isEqualTo(799);
        assertThat(powerConsumption.getEpsilonRate()).isEqualTo(3296);
    }
    
    @Test
    void dirtyTestToTestTheGammaRateCalculation(){
        String input1 = "011110011110";
        String input2 = "101101001111";
        String input3 = "000000010101";
        List<String> oneInput = List.of(input1, input2, input3);
        PowerCalculator powerCalculator = new PowerCalculator();

        char[] gammaBinary = powerCalculator.calculateBinaryGammaRate(oneInput);

        String expectedBinary = "001100011111";
        assertThat(gammaBinary).isEqualTo(expectedBinary.toCharArray());
    }
}