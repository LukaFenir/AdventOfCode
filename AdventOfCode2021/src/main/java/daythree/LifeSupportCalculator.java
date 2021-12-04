package daythree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Pattern;

public class LifeSupportCalculator implements DiagnosticCalculator {

    private final String BINARY_PATTERN = "[01]*";
    
    @Override
    public LifeSupportRating calculate(List<String> inputs) throws InterruptedException, ExecutionException {
        if(inputs.size() == 0) {
            return new LifeSupportRating(0, 0);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Callable<String>> taskList = Arrays.asList(task(inputs, '1'), task(inputs, '0'));

        List<Future<String>> futures = executorService.invokeAll(taskList);
        String oxygenRating = "";
        String co2Rating = "";
        try{
            oxygenRating = futures.get(0).get();
            co2Rating = futures.get(1).get();
        } catch (ExecutionException e) {
            throw new NumberFormatException(e.getCause().getMessage());
        }

        executorService.shutdown();

        Pattern r = Pattern.compile(BINARY_PATTERN);
        if(!r.matcher(oxygenRating).matches()){
            throw new NumberFormatException("For input string: " + oxygenRating);
        } else if(!r.matcher(co2Rating).matches()) {
            throw new NumberFormatException("For input string: " + co2Rating);
        }
        
        return new LifeSupportRating(Integer.parseInt(oxygenRating, 2), Integer.parseInt(co2Rating, 2));
    }
    
    private Callable<String> task(List<String> inputs, char bitCriteria){
        return () -> {
            List<String> bucket = inputs;
            int i = 0;
            while(bucket.size() > 1) {
                List<String> filterBucket = new ArrayList<>();
                List<String> otherBucket = new ArrayList<>();
                for(String input : bucket){
                    if(input.charAt(i) == bitCriteria){
                        filterBucket.add(input);
                    } else if (input.charAt(i) == '1' || input.charAt(i) == '0') {
                        otherBucket.add(input);
                    } else {
                        throw new NumberFormatException("For input string: " + input);
                    }
                }
                if(filterBucket.size() == otherBucket.size() || bitCriteria == '1' && (filterBucket.size() > otherBucket.size()) || (bitCriteria == '0' && (filterBucket.size() < otherBucket.size()))){
                    bucket = filterBucket;
                } else {
                    bucket = otherBucket;
                }
                i++;
            }
            return bucket.get(0);
        };
    }
    
}
