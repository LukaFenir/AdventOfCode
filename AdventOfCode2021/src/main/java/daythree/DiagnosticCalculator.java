package daythree;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface DiagnosticCalculator {
    
    Rating calculate(List<String> inputs) throws InterruptedException, ExecutionException;
}
