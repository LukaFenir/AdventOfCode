package dayfour;

import common.InputReader;
import daythree.LifeSupportCalculator;
import daythree.LifeSupportRating;
import daythree.PowerConsumption;
import daythree.PowerConsumptionCalculator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

public class DayFourTest {

    @Test
    void exampleInputTest(){
        String fileAbsolutePath = new File("src/test/resources/dayfour/example").getAbsolutePath();
        System.out.println("========== Running Day Four, Task One ==========");
        System.out.println("====== Reading Input ======");
        InputReader inputReader = new InputReader();
        List<String> inputs = inputReader.readStringsFromFile(fileAbsolutePath);
        assertThat(inputs.size()).isEqualTo(12);

        PowerConsumptionCalculator powerCalculator = new PowerConsumptionCalculator();
        PowerConsumption powerConsumption = powerCalculator.calculate(inputs);

        int result = powerConsumption.getGammaRate() * powerConsumption.getEpsilonRate();
        System.out.println("What is the power consumption of the submarine?");
        System.out.println(result);

        assertThat(result).isEqualTo(198);
    }

    @Test
    void dayFourInputTest(){
        String fileAbsolutePath = new File("src/test/resources/daythree/day-four").getAbsolutePath();
        System.out.println("========== Running Day Three, Task One ==========");
        System.out.println("====== Reading Input ======");
        InputReader inputReader = new InputReader();
        List<String> inputs = inputReader.readStringsFromFile(fileAbsolutePath);
        assertThat(inputs.size()).isEqualTo(1000);

        PowerConsumptionCalculator powerCalculator = new PowerConsumptionCalculator();
        PowerConsumption powerConsumption = powerCalculator.calculate(inputs);

        int result = powerConsumption.getGammaRate() * powerConsumption.getEpsilonRate();
        System.out.println("What is the power consumption of the submarine?");
        System.out.println(result);
    }

    @Test
    void exampleInputTaskTwoTest() throws InterruptedException, ExecutionException {

    }

    @Test
    void dayFourInputTaskTwoTest() throws InterruptedException, ExecutionException {

    }
}
