package daythree;

import common.InputReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

public class DayThreeTest {
    
    @Test
    void exampleInputTest(){
        String fileAbsolutePath = new File("src/test/resources/daythree/example").getAbsolutePath();
        System.out.println("========== Running Day Three, Task One ==========");
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
    void dayThreeInputTest(){
        String fileAbsolutePath = new File("src/test/resources/daythree/day-three").getAbsolutePath();
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
        String fileAbsolutePath = new File("src/test/resources/daythree/example").getAbsolutePath();
        System.out.println("========== Running Day Three, Task One ==========");
        System.out.println("====== Reading Input ======");
        InputReader inputReader = new InputReader();
        List<String> inputs = inputReader.readStringsFromFile(fileAbsolutePath);
        assertThat(inputs.size()).isEqualTo(12);

        LifeSupportCalculator lifeSupportCalculator = new LifeSupportCalculator();
        LifeSupportRating lifeSupportRating = lifeSupportCalculator.calculate(inputs);

        int result = lifeSupportRating.getOxygenRate() * lifeSupportRating.getCo2ScrubberRate();
        System.out.println("What is the life support rating of the submarine?");
        System.out.println(result);

        assertThat(result).isEqualTo(230);
    }

    @Test
    void dayThreeInputTaskTwoTest() throws InterruptedException, ExecutionException {
        String fileAbsolutePath = new File("src/test/resources/daythree/day-three").getAbsolutePath();
        System.out.println("========== Running Day Three, Task One ==========");
        System.out.println("====== Reading Input ======");
        InputReader inputReader = new InputReader();
        List<String> inputs = inputReader.readStringsFromFile(fileAbsolutePath);
        assertThat(inputs.size()).isEqualTo(1000);

        LifeSupportCalculator lifeSupportCalculator = new LifeSupportCalculator();
        LifeSupportRating lifeSupportRating = lifeSupportCalculator.calculate(inputs);

        int result = lifeSupportRating.getOxygenRate() * lifeSupportRating.getCo2ScrubberRate();
        System.out.println("What is the life support rating of the submarine?");
        System.out.println(result);
    }
}
