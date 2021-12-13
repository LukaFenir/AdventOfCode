package dayfour;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BingoServiceTest {
    
    @Mock
    private BingoParser parser;
    MockParserData mockData = new MockParserData();
    
    @InjectMocks
    BingoService bingoService;
    
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
        when(parser.parseDrawnNumbers(inputs.get(0)))
                .thenReturn(List.of(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1));
        when(parser.parseBoards2(inputs.subList(2, inputs.size())))
                .thenReturn(mockData.singleBoard());
        Board expectedBoard = firstExpectedBoard();

        //when
        WinningBoard winningBoard = bingoService.runGame(inputs);
        
        //then
        assertThat(winningBoard.getBoard()).isEqualTo(expectedBoard);
        assertThat(winningBoard.getWinningNumber()).isEqualTo(16);
    }

    @Test
    void givenTwoBoards_returnTheSecondBoardAsTheWinningBoardWithWinningNumber(){
        //given
        List<String> inputs = List.of("7,4,9,5,11,17,23,2,0,14,21,6,22,16,13,24,15,25,12,10,18,20,8,19,3,26,1",
                "",
                "22 13 17 11  0",
                " 8  2 23  4 24",
                "21  9 14 16  7",
                " 6 10  3 18  5",
                " 1 12 20 15 19",
                "",
                "3 15  0  2 22",
                "9 18 13 17  5",
                "19  8  7 25 23",
                "16 11 10 24  4",
                "14 21 20 12  6");
        when(parser.parseDrawnNumbers(inputs.get(0)))
                .thenReturn(List.of(7,4,9,5,11,17,23,2,0,14,21,6,22,16,13,24,15,25,12,22,18,20,8,19,3,26,1));
        when(parser.parseBoards2(inputs.subList(2, inputs.size())))
                .thenReturn(mockData.twoBoards());
        Board expectedBoard = secondExpectedBoard();

        //when
        WinningBoard winningBoard = bingoService.runGame(inputs);

        //then
        assertThat(winningBoard.getBoard()).isEqualTo(expectedBoard);
        assertThat(winningBoard.getWinningNumber()).isEqualTo(22);
    }

    @Test
    void givenOneBoard_returnThatBoardAsTheLosingBoardWithLastNumber(){
        //given
        List<String> inputs = List.of("7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
                "",
                "22 13 17 11  0",
                " 8  2 23  4 24",
                "21  9 14 16  7",
                " 6 10  3 18  5",
                " 1 12 20 15 19");
        when(parser.parseDrawnNumbers(inputs.get(0)))
                .thenReturn(List.of(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1));
        when(parser.parseBoards2(inputs.subList(2, inputs.size())))
                .thenReturn(mockData.singleBoard());
        Board expectedBoard = firstExpectedBoard();

        //when
        WinningBoard losingBoard = bingoService.runLosingGame(inputs);

        //then
        assertThat(losingBoard.getBoard()).isEqualTo(expectedBoard);
        assertThat(losingBoard.getWinningNumber()).isEqualTo(16);
    }

    @Test
    void givenTwoBoards_returnTheFirstBoardAsTheLosingBoardWithDrawnNumber(){
        //given
        List<String> inputs = List.of("7,4,9,5,11,17,23,2,0,14,21,6,22,16,13,24,15,25,12,10,18,20,8,19,3,26,1",
                "",
                "22 13 17 11  0",
                " 8  2 23  4 24",
                "21  9 14 16  7",
                " 6 10  3 18  5",
                " 1 12 20 15 19",
                "",
                "3 15  0  2 22",
                "9 18 13 17  5",
                "19  8  7 25 23",
                "16 11 10 24  4",
                "14 21 20 12  6");
        when(parser.parseDrawnNumbers(inputs.get(0)))
                .thenReturn(List.of(7,4,9,5,11,17,23,2,0,14,21,6,22,16,13,24,15,25,12,22,18,20,8,19,3,26,1));
        when(parser.parseBoards2(inputs.subList(2, inputs.size())))
                .thenReturn(mockData.twoBoards());
        Board expectedBoard = firstExpectedBoardLost();

        //when
        WinningBoard winningBoard = bingoService.runLosingGame(inputs);

        //then
        assertThat(winningBoard.getBoard()).isEqualTo(expectedBoard);
        assertThat(winningBoard.getWinningNumber()).isEqualTo(16);
    }
    
    @Test
    void givenWinningBoard_correctSumOfUnmarkedNumbersReturned(){
        //given
        WinningBoard winningBoard = new WinningBoard(firstExpectedBoard(), 16);
        
        //when
        int unmarkedSum = winningBoard.getBoard().getUnmarkedSum();
        
        assertThat(unmarkedSum).isEqualTo(137);
    }

    @Test
    void givenAnotherWinningBoard_correctSumOfUnmarkedNumbersReturned(){
        //given
        WinningBoard winningBoard = new WinningBoard(secondExpectedBoard(), 22);

        //when
        int unmarkedSum = winningBoard.getBoard().getUnmarkedSum();

        assertThat(unmarkedSum).isEqualTo(191);
    }
    
    //################## Test Data

    public Board firstExpectedBoard(){
        Board.Box[][] board = {
                {new Board.Box(22), new Board.Box(13), new Board.Box(17, true), new Board.Box(11, true), new Board.Box(0, true)},
                {new Board.Box(8), new Board.Box(2, true), new Board.Box(23, true), new Board.Box(4, true), new Board.Box(24, true)},
                {new Board.Box(21, true), new Board.Box(9, true), new Board.Box(14, true), new Board.Box(16, true), new Board.Box(7, true)},
                {new Board.Box(6), new Board.Box(10, true), new Board.Box(3), new Board.Box(18), new Board.Box(5, true)},
                {new Board.Box(1), new Board.Box(12), new Board.Box(20), new Board.Box(15), new Board.Box(19)}
        };

        return new Board(board);
    }

    public Board secondExpectedBoard(){
        Board.Box[][] board = {
                {new Board.Box(3),new Board.Box(15),new Board.Box(0, true),new Board.Box(2, true),new Board.Box(22, true)},
                {new Board.Box(8),new Board.Box(18),new Board.Box(13),new Board.Box(17, true),new Board.Box(5, true)},
                {new Board.Box(19),new Board.Box(8),new Board.Box(7, true),new Board.Box(25),new Board.Box(23, true)},
                {new Board.Box(16),new Board.Box(11, true),new Board.Box(10),new Board.Box(24),new Board.Box(4, true)},
                {new Board.Box(14, true),new Board.Box(21, true),new Board.Box(20),new Board.Box(12),new Board.Box(6, true)}
        };
        return new Board(board);
    }

    public Board firstExpectedBoardLost(){
        Board.Box[][] board = {
                {new Board.Box(22, true), new Board.Box(13), new Board.Box(17, true), new Board.Box(11, true), new Board.Box(0, true)},
                {new Board.Box(8), new Board.Box(2, true), new Board.Box(23, true), new Board.Box(4, true), new Board.Box(24)},
                {new Board.Box(21, true), new Board.Box(9, true), new Board.Box(14, true), new Board.Box(16, true), new Board.Box(7, true)},
                {new Board.Box(6, true), new Board.Box(10), new Board.Box(3), new Board.Box(18), new Board.Box(5, true)},
                {new Board.Box(1), new Board.Box(12), new Board.Box(20), new Board.Box(15), new Board.Box(19)}
        };

        return new Board(board);
    }

    public static class MockParserData {
        
        public List<Board> singleBoard(){
            Board.Box[][] singleBoard = {
                    {new Board.Box(22),new Board.Box(13),new Board.Box(17),new Board.Box(11),new Board.Box(0)},
                    {new Board.Box(8),new Board.Box(2),new Board.Box(23),new Board.Box(4),new Board.Box(24)},
                    {new Board.Box(21),new Board.Box(9),new Board.Box(14),new Board.Box(16),new Board.Box(7)},
                    {new Board.Box(6),new Board.Box(10),new Board.Box(3),new Board.Box(18),new Board.Box(5)},
                    {new Board.Box(1),new Board.Box(12),new Board.Box(20),new Board.Box(15),new Board.Box(19)}
            };

            return new ArrayList<>(List.of(new Board(singleBoard)));
        }

        public List<Board> twoBoards(){
            List<Board> twoBoards = singleBoard();
            Board.Box[][] secondBoard = {
                    {new Board.Box(3),new Board.Box(15),new Board.Box(0),new Board.Box(2),new Board.Box(22)},
                    {new Board.Box(8),new Board.Box(18),new Board.Box(13),new Board.Box(17),new Board.Box(5)},
                    {new Board.Box(19),new Board.Box(8),new Board.Box(7),new Board.Box(25),new Board.Box(23)},
                    {new Board.Box(16),new Board.Box(11),new Board.Box(10),new Board.Box(24),new Board.Box(4)},
                    {new Board.Box(14),new Board.Box(21),new Board.Box(20),new Board.Box(12),new Board.Box(6)}
            };
            twoBoards.add(new Board(secondBoard));
            return twoBoards;
        }
    }
}