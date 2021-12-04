package daythree;

import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.awaitility.Awaitility.await;

class LifeSupportCalculatorTest {

    @Test
    void givenEmptyListOfInputs_calculationReturnsZeroPowerConsumption() throws InterruptedException, ExecutionException {
        //given
        List<String> noInputs = new ArrayList<>();
        LifeSupportCalculator lifeSupportCalculator = new LifeSupportCalculator();

        //when
        LifeSupportRating lifeSupportRating = lifeSupportCalculator.calculate(noInputs);

        //then
        assertThat(lifeSupportRating.getOxygenRate()).isEqualTo(0);
        assertThat(lifeSupportRating.getCo2ScrubberRate()).isEqualTo(0);
    }

    @Test
    void givenListWithOneInputThatIsNonBinary_calculationThrowsAnException() throws InterruptedException {
        //given
        String input = "411110011110";
        List<String> oneInput = List.of(input);
        LifeSupportCalculator lifeSupportCalculator = new LifeSupportCalculator();

        //then
        await().atMost(Duration.TEN_SECONDS)
                .untilAsserted(() -> assertThatThrownBy(() -> lifeSupportCalculator.calculate(oneInput))
                        .isInstanceOf(NumberFormatException.class)
                        .hasMessage("For input string: 411110011110"));
    }
    
    @Test
    void givenListIncludingANonBinaryInput_calculationThrowsAnException() throws InterruptedException {
        //given
        String input1 = "411110011110";
        String input2 = "111110011110";
        List<String> oneInput = List.of(input1, input2);
        LifeSupportCalculator lifeSupportCalculator = new LifeSupportCalculator();

        //then
        await().atMost(Duration.TEN_SECONDS)
                .untilAsserted(() -> assertThatThrownBy(() -> lifeSupportCalculator.calculate(oneInput))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("For input string: 411110011110"));
    }

    @Test
    void givenListWithOneInput_calculationReturnsSameOxygenRateAsTheInput() throws InterruptedException, ExecutionException {
        //given
        String input = "011110011110";
        List<String> oneInput = List.of(input);
        LifeSupportCalculator lifeSupportCalculator = new LifeSupportCalculator();

        //when
        LifeSupportRating lifeSupportRating = lifeSupportCalculator.calculate(oneInput);

        //then
        assertThat(lifeSupportRating.getOxygenRate()).isEqualTo(1950);
        assertThat(lifeSupportRating.getCo2ScrubberRate()).isEqualTo(1950);
    }

    @Test
    void givenListWithTwoInputs_calculationReturnsCorrectOxygenAndCo2Rates() throws InterruptedException, ExecutionException {
        //given
        String input1 = "011110011110";
        String input2 = "101101001111";
        List<String> oneInput = List.of(input1, input2);
        LifeSupportCalculator lifeSupportCalculator = new LifeSupportCalculator();

        //when
        LifeSupportRating lifeSupportRating = lifeSupportCalculator.calculate(oneInput);

        //then
        assertThat(lifeSupportRating.getOxygenRate()).isEqualTo(2895);
        assertThat(lifeSupportRating.getCo2ScrubberRate()).isEqualTo(1950);
    }

    @Test
    void givenListWithThreeInputs_calculationReturnsCorrectOxygenAndCo2Rates() throws InterruptedException, ExecutionException {
        //given
        String input1 = "011111011110";
        String input2 = "101101101011";
        String input3 = "000000010101";
        List<String> oneInput = List.of(input1, input2, input3);
        LifeSupportCalculator lifeSupportCalculator = new LifeSupportCalculator();

        //when
        LifeSupportRating lifeSupportRating = lifeSupportCalculator.calculate(oneInput);

        //then
        assertThat(lifeSupportRating.getOxygenRate()).isEqualTo(2014);
        assertThat(lifeSupportRating.getCo2ScrubberRate()).isEqualTo(2923);
    }
}