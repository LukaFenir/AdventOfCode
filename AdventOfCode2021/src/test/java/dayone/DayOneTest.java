package dayone;

import common.InputReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayOneTest {

    @Test
    void doDayOneTask() {
        System.out.println("========== Running Task ==========");
        InputReader inputReader = new InputReader();
        DepthService depthService = new DepthService();
        String fileAbsolutePath = new File("src/test/resources/dayone/day-one").getAbsolutePath();

        List<Integer> integers = inputReader.readIntsFromFile(fileAbsolutePath);
        System.out.println("Size of file");
        assertThat(integers.size()).isEqualTo(2000);
        int result = depthService.depthIncreaseCounter(integers);

        System.out.println("How many measurements are larger than the previous measurement?");
        System.out.println(result);
    }

    @Test
    void doDayOneTaskPartTwo() {
        System.out.println("========== Running Task ==========");
        InputReader inputReader = new InputReader();
        DepthService depthService = new DepthService();
        String fileAbsolutePath = new File("src/test/resources/dayone/day-one").getAbsolutePath();

        List<Integer> integers = inputReader.readIntsFromFile(fileAbsolutePath);
        System.out.println("Size of file");
        assertThat(integers.size()).isEqualTo(2000);
        int result = depthService.depthWindowCounter(integers);

        System.out.println("How many windows of measurements are larger than the previous window of measurements?");
        System.out.println(result);
    }
}
