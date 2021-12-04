package daythree;

import common.InputReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

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

        PowerCalculator powerCalculator = new PowerCalculator();
        PowerConsumption powerConsumption = powerCalculator.calculatePowerConsumption(inputs);

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

        PowerCalculator powerCalculator = new PowerCalculator();
        PowerConsumption powerConsumption = powerCalculator.calculatePowerConsumption(inputs);
        
        int result = powerConsumption.getGammaRate() * powerConsumption.getEpsilonRate();
        System.out.println("What is the power consumption of the submarine?");
        System.out.println(result);
    }
}
