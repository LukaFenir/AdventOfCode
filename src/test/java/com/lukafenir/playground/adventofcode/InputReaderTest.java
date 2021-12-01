package com.lukafenir.playground.adventofcode;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputReaderTest {

    @Test
    void givenEmptyFile_readFileReturnsEmptyList() {
        //given
        String fileAbsolutePath = new File("src/test/resources/no-input").getAbsolutePath();

        InputReader inputReader = new InputReader();

        //when
        List<String> strings = inputReader.readStringsFromFile(fileAbsolutePath);

        //then
        assertThat(strings.size()).isEqualTo(0);
    }

    @Test
    void givenFileWithAnEmptyString_readFileReturnsListWithAnEmptyString() {
        //given
        String fileAbsolutePath = new File("src/test/resources/empty-string").getAbsolutePath();

        InputReader inputReader = new InputReader();

        //when
        List<String> strings = inputReader.readStringsFromFile(fileAbsolutePath);

        //then
        assertThat(strings.size()).isEqualTo(1);
        assertThat(strings.get(0)).isEqualTo(" ");
    }

    @Test
    void givenFileWithFiveLines_readFileReturnsArrayOfFiveStrings() {
        //given
        String fileAbsolutePath = new File("src/test/resources/five-strings").getAbsolutePath();

        InputReader inputReader = new InputReader();

        //when
        List<String> strings = inputReader.readStringsFromFile(fileAbsolutePath);

        //then
        assertThat(strings.size()).isEqualTo(5);
        assertThat(strings.get(0)).isEqualTo("1389");
        assertThat(strings.get(1)).isEqualTo("asdfghjkl");
        assertThat(strings.get(2)).isEqualTo("    ");
        assertThat(strings.get(3)).isEqualTo("asdf,jsh; snvm'21324j");
        assertThat(strings.get(4)).isEqualTo("========================");
    }

    @Test
    void givenEmptyFile_readIntFileReturnsEmptyList() {
        //given
        String fileAbsolutePath = new File("src/test/resources/no-input").getAbsolutePath();

        InputReader inputReader = new InputReader();

        //when
        List<Integer> integers = inputReader.readIntsFromFile(fileAbsolutePath);

        //then
        assertThat(integers.size()).isEqualTo(0);
    }

    @Test
    void givenFileWithEmptyString_readIntFileThrowsException() {
        //given
        String fileAbsolutePath = new File("src/test/resources/empty-string").getAbsolutePath();

        InputReader inputReader = new InputReader();

        //then
        assertThatThrownBy(() -> inputReader.readIntsFromFile(fileAbsolutePath))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("For input string: \" \"");
    }

    @Test
    void givenFileWithNonInts_readIntFileThrowsException() {
        //given
        String fileAbsolutePath = new File("src/test/resources/five-strings").getAbsolutePath();

        InputReader inputReader = new InputReader();

        //then
        assertThatThrownBy(() -> inputReader.readIntsFromFile(fileAbsolutePath))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("For input string: \"asdfghjkl\"");
    }

    @Test
    void givenFileWithFiveIntegers_readFileReturnsArrayOfFiveIntegers() {
        //given
        String fileAbsolutePath = new File("src/test/resources/five-integers").getAbsolutePath();

        InputReader inputReader = new InputReader();

        //when
        List<Integer> integers = inputReader.readIntsFromFile(fileAbsolutePath);

        //then
        assertThat(integers.size()).isEqualTo(5);
        assertThat(integers.get(0)).isEqualTo(2345678);
        assertThat(integers.get(1)).isEqualTo(1);
        assertThat(integers.get(2)).isEqualTo(0);
        assertThat(integers.get(3)).isEqualTo(9283);
        assertThat(integers.get(4)).isEqualTo(2147483647);
    }
}
