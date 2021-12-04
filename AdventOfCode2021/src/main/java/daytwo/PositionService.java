package daytwo;

import java.util.List;

import static daytwo.Direction.*;

public class PositionService {
    
    public Position calculatePosition(List<Instruction> instructions){
        Position position = new Position();
        for(Instruction instruction : instructions) {
            switch (instruction.getDirection()) {
                case FORWARD:
                    position.increaseHorizontal(instruction.getDistance());
                    break;
                case DOWN:
                    position.increaseVertical(instruction.getDistance());
                    break;
                case UP:
                    position.decreaseVertical(instruction.getDistance());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown Direction: " + instruction.getDirection());
            }
        }
        return position;
    }
    
    public Position calculatePositionV2(List<Instruction> instructions){
        Position position = new Position();
        for(Instruction instruction : instructions) {
            switch (instruction.getDirection()) {
                case FORWARD:
                    position.increaseHorizontal(instruction.getDistance());
                    position.increaseVertical(position.getAim() * instruction.getDistance());
                    break;
                case UP:
                    position.decreaseAim(instruction.getDistance());
                    break;
                case DOWN:
                    position.increaseAim(instruction.getDistance());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown Direction: " + instruction.getDirection());
            }
        }
        return position;
    }
}
