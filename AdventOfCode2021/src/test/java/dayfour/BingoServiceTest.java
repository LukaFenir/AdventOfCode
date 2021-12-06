package dayfour;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BingoServiceTest {
    
    @Mock
    BingoParser parser;
    MockParserData mockData;
    
    BingoService bingoService = new BingoService(parser);
    
    @Test
    void givenOneBoard_returnThatBoardAsTheWinningBoardWithWinningNumber(){
        //given
        List<String> inputs = List.of("7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1", 
                "", 
                "22 13 17 11  0", 
                " 8  2 23  4 24", 
                "21  9 14 16  7", 
                " 6 10  3 18  5", 
                " 1 12 20 15 19");
        when(parser.parseDrawnNumbers(mockData.drawnNumbersString))
                .thenReturn(mockData.drawnNumbersList);
        when(parser.parseBoards(mockData.singleBoardStrings))
                .thenReturn(mockData.singleBoard());
        List<Board> expectedBoard = singleBoard();

        //when
        WinningBoard winningBoard = bingoService.runGame(inputs);
        
        //then
        assertThat(winningBoard.getBoard()).isEqualTo(expectedBoard.get(0));
    }
    
    //################## Test Data

    public List<Board> singleBoard(){
        List<List<Board.Box>> rows = Arrays.asList(
                Arrays.asList(new Board.Box(22),new Board.Box(13),new Board.Box(17),new Board.Box(11),new Board.Box(0)),
                Arrays.asList(new Board.Box(8),new Board.Box(2),new Board.Box(23),new Board.Box(4),new Board.Box(24)),
                Arrays.asList(new Board.Box(21),new Board.Box(9),new Board.Box(14),new Board.Box(16),new Board.Box(7)),
                Arrays.asList(new Board.Box(6),new Board.Box(10),new Board.Box(3),new Board.Box(18),new Board.Box(5)),
                Arrays.asList(new Board.Box(1),new Board.Box(12),new Board.Box(20),new Board.Box(15),new Board.Box(19)));
        List<List<Board.Box>> columns = Arrays.asList(
                Arrays.asList(new Board.Box(22),new Board.Box(8),new Board.Box(21),new Board.Box(6),new Board.Box(1)),
                Arrays.asList(new Board.Box(13),new Board.Box(2),new Board.Box(9),new Board.Box(10),new Board.Box(12)),
                Arrays.asList(new Board.Box(17),new Board.Box(23),new Board.Box(14),new Board.Box(3),new Board.Box(20)),
                Arrays.asList(new Board.Box(11),new Board.Box(4),new Board.Box(16),new Board.Box(18),new Board.Box(15)),
                Arrays.asList(new Board.Box(0),new Board.Box(24),new Board.Box(7),new Board.Box(5),new Board.Box(19))
        );

        return new ArrayList<>(List.of(new Board(rows, columns)));
    }

    public static class MockParserData {
        
        public String drawnNumbersString = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1";
        public List<Integer> drawnNumbersList = List.of(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1);
        
        public List<String> singleBoardStrings = List.of("22 13 17 11  0",
                                                        " 8  2 23  4 24",
                                                        "21  9 14 16  7",
                                                        " 6 10  3 18  5",
                                                        " 1 12 20 15 19");
        public List<Board> singleBoard(){
            List<List<Board.Box>> rows = Arrays.asList(
                    Arrays.asList(new Board.Box(22),new Board.Box(13),new Board.Box(17),new Board.Box(11),new Board.Box(0)),
                    Arrays.asList(new Board.Box(8),new Board.Box(2),new Board.Box(23),new Board.Box(4),new Board.Box(24)),
                    Arrays.asList(new Board.Box(21),new Board.Box(9),new Board.Box(14),new Board.Box(16),new Board.Box(7)),
                    Arrays.asList(new Board.Box(6),new Board.Box(10),new Board.Box(3),new Board.Box(18),new Board.Box(5)),
                    Arrays.asList(new Board.Box(1),new Board.Box(12),new Board.Box(20),new Board.Box(15),new Board.Box(19)));
            List<List<Board.Box>> columns = Arrays.asList(
                    Arrays.asList(new Board.Box(22),new Board.Box(8),new Board.Box(21),new Board.Box(6),new Board.Box(1)),
                    Arrays.asList(new Board.Box(13),new Board.Box(2),new Board.Box(9),new Board.Box(10),new Board.Box(12)),
                    Arrays.asList(new Board.Box(17),new Board.Box(23),new Board.Box(14),new Board.Box(3),new Board.Box(20)),
                    Arrays.asList(new Board.Box(11),new Board.Box(4),new Board.Box(16),new Board.Box(18),new Board.Box(15)),
                    Arrays.asList(new Board.Box(0),new Board.Box(24),new Board.Box(7),new Board.Box(5),new Board.Box(19))
            );

            return new ArrayList<>(List.of(new Board(rows, columns)));
        }
    }
}