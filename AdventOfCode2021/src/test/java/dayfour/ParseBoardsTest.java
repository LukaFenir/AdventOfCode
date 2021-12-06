package dayfour;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseBoardsTest {

    BingoParser bingoParser = new BingoParser();
    
    @Test
    void givenASingleBoardInput_parserReturnsASingleBoard(){
        //given
        List<String> singleBoard = Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
        List<List<Integer>> rows = Arrays.asList(
                Arrays.asList(22,13,17,11,0),
                Arrays.asList(8,2,23,4,24),
                Arrays.asList(21,9,14,16,7),
                Arrays.asList(6,10,3,18,5),
                Arrays.asList(1,12,20,15,19));
        List<List<Integer>> columns = Arrays.asList(
                Arrays.asList(22,8,21,6,1),
                Arrays.asList(13,2,9,10,12),
                Arrays.asList(17,23,14,3,20),
                Arrays.asList(11,4,16,18,15),
                Arrays.asList(0,24,7,5,19)
        );
        
        Board expectedBoard = new Board(rows, columns);

        //when
        List<Board> boards = bingoParser.parseBoards(singleBoard);
        
        //then
        assertThat(boards.size()).isEqualTo(1);
        assertThat(boards.get(0)).isEqualTo(expectedBoard);
    }
}
