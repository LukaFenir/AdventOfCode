package daythree;

import java.nio.CharBuffer;
import java.util.List;
import java.util.stream.Collectors;

public class PowerConsumptionCalculator implements DiagnosticCalculator {
    
    @Override
    public PowerConsumption calculate(List<String> inputs) {
        if(inputs.size() == 0){
            return new PowerConsumption(0, 0);
        }
        char[] binaryGammaRate = calculateBinaryGammaRate(inputs);
        String binaryEpsilonRate = calculateBinaryEpsilonRate(binaryGammaRate);
        
        return new PowerConsumption(Integer.parseInt(String.valueOf(binaryGammaRate), 2), Integer.parseInt(String.valueOf(binaryEpsilonRate), 2));
    }
    
    public char[] calculateBinaryGammaRate(List<String> inputs) {
        int inputLength = inputs.get(0).length();
        int[] bitCounter = new int[inputLength];
        for(String input : inputs){
            for(int j = 0; j < inputLength; j++){
                if(input.charAt(j) == '1'){ //check each bit
                    bitCounter[j]++;
                } else if(input.charAt(j) == '0') {
                    bitCounter[j]--;
                } else {
                    String dodgyInput = CharBuffer.wrap(input)
                            .chars().mapToObj(i -> (char) i)
                            .map(String::valueOf)
                            .collect(Collectors.joining());
                    throw new NumberFormatException("For input string: " + dodgyInput);
                }
            }
        }
        char[] gammaRate = new char[inputLength];
        for(int j = 0; j < inputLength; j++){
            gammaRate[j] = bitCounter[j] > 0 ? '1' : '0';
        }
        return gammaRate;
    }
    
    private String calculateBinaryEpsilonRate(char[] gammaRate){
        return CharBuffer.wrap(gammaRate)
                .chars().mapToObj(i -> (char) i)
                .map(bit -> bit == '1' ? '0' : '1')
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
