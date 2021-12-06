package dayfour;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseNumbersTest {
    
    BingoParser bingoParser = new BingoParser();
    
    @Test
    void givenOneValue_returnsAListWithOneValue(){
        //given
        String oneValue = "24";

        List<Integer> drawnNumbers = bingoParser.parseNumbers(oneValue);
        
        assertThat(drawnNumbers.size()).isEqualTo(1);
        assertThat(drawnNumbers.get(0)).isEqualTo(24);
    }

    @Test
    void givenTwoValue_returnsAListWithOneValue(){
        //given
        String twoValues = "24,2";

        List<Integer> drawnNumbers = bingoParser.parseNumbers(twoValues);

        assertThat(drawnNumbers.size()).isEqualTo(2);
        assertThat(drawnNumbers.get(0)).isEqualTo(24);
        assertThat(drawnNumbers.get(1)).isEqualTo(2);
    }

    @Test
    void givenManyValues_returnsTheValuesInListForm(){
        //given
        String twoValues = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1";
        List<Integer> expectedList = List.of(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1);

        List<Integer> drawnNumbers = bingoParser.parseNumbers(twoValues);

        assertThat(drawnNumbers.size()).isEqualTo(27);
        assertThat(drawnNumbers).isEqualTo(expectedList);
    }
}
