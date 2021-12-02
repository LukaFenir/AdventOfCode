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
    
    public int depthWindowCounter(List<Integer> depthMeasurements) {
        int counter = 0;
        if(depthMeasurements.size() > 3){
            for(int i = 3; i < depthMeasurements.size(); i++){
                int nextWindow = depthMeasurements.get(i) + depthMeasurements.get(i - 1) + depthMeasurements.get(i - 2);
                int firstWindow = depthMeasurements.get(i - 1) + depthMeasurements.get(i - 2) + depthMeasurements.get(i - 3);
                if(nextWindow > firstWindow) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
