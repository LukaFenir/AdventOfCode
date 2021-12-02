package com.lukafenir.playground.adventofcode.daytwo;

import java.util.ArrayList;
import java.util.List;

public class PositionParser {
    
    public List<Instruction> parseInstructions(List<String> stringInputs) {
        List<Instruction> instructions = new ArrayList<>();
        
        try {
            for (String input : stringInputs) {
                String[] splitString = input.split(" ");
                instructions.add(new Instruction(Direction.valueOf(splitString[0].toUpperCase()), Integer.parseInt(splitString[1])));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error parsing instructions: " + e.getMessage());
        }
        
        return instructions;
    }
}
