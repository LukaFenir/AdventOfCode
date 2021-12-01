package com.lukafenir.playground.adventofcode;

import java.util.List;

public class DepthService {
    
    public int depthIncreaseCounter(List<Integer> depthMeasurements){
        int counter = 0;
        if(depthMeasurements.size() > 1){
            for(int i = 1; i < depthMeasurements.size(); i++){
                if(depthMeasurements.get(i) > depthMeasurements.get(i - 1)) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
