package dayfour;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseBoards2Test {

    BingoParser bingoParser = new BingoParser();

    @Test
    void givenASingleBoardInput_parserReturnsASingleBoard(){
        //given
        List<String> singleBoard = Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
        List<Board> expectedBoard = twoBoards();

        //when
        List<Board> boards = bingoParser.parseBoards2(singleBoard);

        //then
        assertThat(boards.size()).isEqualTo(1);
        assertThat(boards.get(0)).isEqualTo(expectedBoard.get(0));
    }

    @Test
    void givenTwoBoardsInput_parserReturnsTwoBoards(){
        //given
        List<String> singleBoard = Arrays.asList(
                "22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19", "",
                " 3 15  0  2 22", " 9 18 13 17  5", "19  8  7 25 23", "20 11 10 24  4", "14 21 16 12  6");
        List<Board> expectedBoards = twoBoards();
        
        //when
        List<Board> boards = bingoParser.parseBoards2(singleBoard);

        //then
        assertThat(boards.size()).isEqualTo(2);
        assertThat(boards.get(0)).isEqualTo(expectedBoards.get(0));
        assertThat(boards.get(1)).isEqualTo(expectedBoards.get(1));
    }
    
    //############################################# Test Data
    
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
        List<Board> boards = singleBoard();
        Board.Box[][] secondBoard = {
                {new Board.Box(3),new Board.Box(15),new Board.Box(0),new Board.Box(2),new Board.Box(22)},
                {new Board.Box(9),new Board.Box(18),new Board.Box(13),new Board.Box(17),new Board.Box(5)},
                {new Board.Box(19),new Board.Box(8),new Board.Box(7),new Board.Box(25),new Board.Box(23)},
                {new Board.Box(20),new Board.Box(11),new Board.Box(10),new Board.Box(24),new Board.Box(4)},
                {new Board.Box(14),new Board.Box(21),new Board.Box(16),new Board.Box(12),new Board.Box(6)}
        };

        boards.add(new Board(secondBoard));
        return boards;
    }
}
