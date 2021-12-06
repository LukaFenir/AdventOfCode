package dayfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BingoParser {
    
    public List<Integer> parseNumbers(String input){
        return Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }
    
    public List<Board> parseBoards(List<String> inputs){
        for(int i = 0; i < inputs.size(); i++){
            for(int j = i; j < )
        }
        return new ArrayList<>();
    }
}
