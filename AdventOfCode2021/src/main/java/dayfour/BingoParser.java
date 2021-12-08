package dayfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BingoParser {

    public List<Integer> parseDrawnNumbers(String input){
        return Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }
    
    public List<Board> parseBoards2(List<String> inputs) {
        ArrayList<Board> boards = new ArrayList<>();
        boards.add(new Board());
        int boardCounter = 0;
        for(int i = 0; i < inputs.size(); i++){
            if ((i + 1) % 6 != 0) { //not blank space?
                List<Integer> integerInputs = Arrays.stream(inputs.get(i).trim().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
                boards.get(boardCounter).addRow(integerInputs, i % 6);
            } else {
                boards.add(new Board());
                boardCounter++;
            }
        }
        return boards;
    }

    private List<Board.Box> parseLine(String line){
        return Arrays.stream(line.trim().split("\\s+")).map(string -> new Board.Box(Integer.valueOf(string))).collect(Collectors.toList());
    }
    
}
