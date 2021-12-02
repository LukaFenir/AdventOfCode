package com.lukafenir.playground.adventofcode.daytwo;

import lombok.Data;

@Data
public class Position {
    
    private int horizontal;
    private int vertical;
    private int aim;
    
    public Position(){
        
    }
    
    public Position(int horizontal, int vertical){
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public Position(int horizontal, int vertical, int aim){
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.aim = aim;
    }
    
    public void increaseHorizontal(int distance){
        horizontal += distance;
    }

    public void increaseVertical(int distance){
        vertical += distance;
    }

    public void decreaseVertical(int distance){
        vertical = Math.max(0, vertical - distance);
    }

    public void increaseAim(int distance){
        aim += distance;
    }

    public void decreaseAim(int distance){ aim = Math.max(0, aim - distance); }
}
