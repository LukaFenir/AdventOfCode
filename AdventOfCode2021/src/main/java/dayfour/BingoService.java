package dayfour;

import java.util.ArrayList;
import java.util.List;

public class BingoService {

    private BingoParser parser;

    public BingoService(BingoParser parser){
        this.parser = parser;
    }

    public WinningBoard runGame(List<String> inputs){
        List<Board> boards = parser.parseBoards2(inputs.subList(2, inputs.size()));
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
    
    public WinningBoard runLosingGame(List<String> inputs){
        List<Board> boards = parser.parseBoards2(inputs.subList(2, inputs.size()));
        List<Integer> drawnNumbers = parser.parseDrawnNumbers(inputs.get(0));
        
        List<Board> found = new ArrayList<>();

        for (Integer number : drawnNumbers) {
            for(Board board : boards) {
                boolean isWinner = board.markedNumberIsWinner(number);
                //if a board wins, remove board from the list
                if(isWinner && boards.size() > 1) {
                    found.add(board);
                } else if (isWinner) {
                    return new WinningBoard(board, number);
                }
            }
            boards.removeAll(found);
        }
        return new WinningBoard(boards.get(0), 1);
    }
}
