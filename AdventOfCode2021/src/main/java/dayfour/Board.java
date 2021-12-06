package dayfour;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Board {
    
    private List<List<Integer>> columns;
    private List<List<Integer>> rows;
    
}
