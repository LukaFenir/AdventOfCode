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
    
    private final BingoParser bingoParser = new BingoParser();
    private final BingoService bingoService = new BingoService(bingoParser);

    @Test
    void exampleInputTest(){
        String fileAbsolutePath = new File("src/test/resources/dayfour/example").getAbsolutePath();
        System.out.println("========== Running Day Four, Task One ==========");
        System.out.println("====== Reading Input ======");
        InputReader inputReader = new InputReader();
        List<String> inputs = inputReader.readStringsFromFile(fileAbsolutePath);
        assertThat(inputs.size()).isEqualTo(19);

        WinningBoard winningBoard = bingoService.runGame(inputs);

        int result = winningBoard.getBoard().getUnmarkedSum() * winningBoard.getWinningNumber();
        System.out.println("What will your final score be if you choose that board?");
        System.out.println(result);

        assertThat(result).isEqualTo(4512);
    }

    @Test
    void dayFourInputTest(){
        String fileAbsolutePath = new File("src/test/resources/dayfour/day-four").getAbsolutePath();
        System.out.println("========== Running Day Three, Task One ==========");
        System.out.println("====== Reading Input ======");
        InputReader inputReader = new InputReader();
        List<String> inputs = inputReader.readStringsFromFile(fileAbsolutePath);
        assertThat(inputs.size()).isEqualTo(601);

        WinningBoard winningBoard = bingoService.runGame(inputs);

        int result = winningBoard.getBoard().getUnmarkedSum() * winningBoard.getWinningNumber();
        System.out.println("What will your final score be if you choose that board?");
        System.out.println(result);
    }

    @Test
    void exampleInputTaskTwoTest() throws InterruptedException, ExecutionException {
        String fileAbsolutePath = new File("src/test/resources/dayfour/example").getAbsolutePath();
        System.out.println("========== Running Day Four, Task One ==========");
        System.out.println("====== Reading Input ======");
        InputReader inputReader = new InputReader();
        List<String> inputs = inputReader.readStringsFromFile(fileAbsolutePath);
        assertThat(inputs.size()).isEqualTo(19);

        WinningBoard winningBoard = bingoService.runLosingGame(inputs);

        int result = winningBoard.getBoard().getUnmarkedSum() * winningBoard.getWinningNumber();
        System.out.println("What will your final score be if you choose that board?");
        System.out.println(result);

        assertThat(result).isEqualTo(1924);
    }

    @Test
    void dayFourInputTaskTwoTest() throws InterruptedException, ExecutionException {
        String fileAbsolutePath = new File("src/test/resources/dayfour/day-four").getAbsolutePath();
        System.out.println("========== Running Day Three, Task One ==========");
        System.out.println("====== Reading Input ======");
        InputReader inputReader = new InputReader();
        List<String> inputs = inputReader.readStringsFromFile(fileAbsolutePath);
        assertThat(inputs.size()).isEqualTo(601);

        WinningBoard winningBoard = bingoService.runLosingGame(inputs);

        int result = winningBoard.getBoard().getUnmarkedSum() * winningBoard.getWinningNumber();
        System.out.println("What will your final score be if you choose that board?");
        System.out.println(result);
    }
}
