package dayfour;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Board {
    
    private Box[][] boxes;
    
    public Board(){
        this.boxes = new Box[5][5];
    }

    public Board(Box[][] boxes){
        this.boxes = boxes;
    }
    
    public void addRow(List<Integer> inputs, int index){
        Box[] row = new Box[5];
        for(int i = 0 ; i < 5 ; i++){
            row[i] = new Box(inputs.get(i));
        }
        this.boxes[index] = row;
    }

    public int getUnmarkedSum(){
        int sum = 0;
        for(Box[] row : boxes){
            for(Box box : row){
                if(!box.isMarked()){
                    sum += box.number;
                }
            }
        }
        return sum;
    }
    
    public boolean markedNumberIsWinner(Integer drawnNumber){
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                if(boxes[row][col].number.equals(drawnNumber)){
                    boxes[row][col].marked = true;
                    //row is complete
                    //TODO erm?
                    boolean rowIsLine = true;
                    boolean colIsLine = true;
                    for(int k = 0; k < 5; k++){
                        if(!boxes[row][k].isMarked()){
                            rowIsLine = false;
                            break;
                        }
                    }
                    //if not a row, a column?
                    if(!rowIsLine){
                        for(int k = 0; k < 5; k++){
                            if(!boxes[k][col].isMarked()){
                                colIsLine = false;
                                break;
                            }
                        }
                    }
                    return rowIsLine || colIsLine;
                };
            }
        }
        return false;
    }

    @Data
    @AllArgsConstructor
    static class Box {
        
        private Integer number;
        private boolean marked;
        
        public Box(Integer number) {
            this.number = number;
            this.marked = false;
        }
    }
}


