package com.lukafenir.playground.adventofcode.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {

    public List<String> readStringsFromFile(String absolutePath) {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(absolutePath))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Integer> readIntsFromFile(String absolutePath) {
        List<Integer> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(absolutePath))) {
            list = stream.map(Integer::valueOf).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
