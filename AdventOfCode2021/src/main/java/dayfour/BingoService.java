package dayfour;

import java.util.List;

public class BingoService {

    private BingoParser parser;

    public BingoService(BingoParser parser){
        this.parser = parser;
    }

    public WinningBoard runGame(List<String> inputs){
        List<String> boardStrings = inputs.subList(2, inputs.size());
        List<Board> boards = parser.parseBoards2(boardStrings);
        List<Integer> drawnNumbers = parser.parseDrawnNumbers(inputs.get(0));
        
        for(Integer number : drawnNumbers){
            for(Board board : boards) {
                boolean isWinner = board.markedNumberIsWinner(number);
                //if a board wins, return that board
                if(isWinner) {
                    return new WinningBoard(board, number);
                }
            }
        }
        
        return new WinningBoard(boards.get(0), 1);
    }
}
