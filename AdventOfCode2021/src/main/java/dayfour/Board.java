package dayfour;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Board {
    
    private Box[][] boxes = new Box[5][5];
    
    private List<List<Box>> rows;
    private List<List<Box>> columns;

    public Board(List<List<Box>> rows, List<List<Box>>columns){
        this.rows = rows;
        this.columns = columns;
    }
    
    public Board(){
        this.rows = new ArrayList<>();
        this.columns = new ArrayList<>();
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

    public List<Box> getUnmarked(){
        return new ArrayList<>();
    }

    @Data
    static
    class Box {
        
        private Integer number;
        private boolean marked;
        
        public Box(Integer number) {
            this.number = number;
            this.marked = false;
        }
    }
}


