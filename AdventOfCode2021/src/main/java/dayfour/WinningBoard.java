package dayfour;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WinningBoard {
    
    private Board board;
    private int winningNumber;
    
}
