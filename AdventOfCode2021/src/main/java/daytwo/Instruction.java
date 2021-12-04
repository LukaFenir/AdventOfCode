package daytwo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Instruction {
    
    private Direction direction;
    private int distance;
    
}

enum Direction {
    FORWARD,
    UP,
    DOWN
}
