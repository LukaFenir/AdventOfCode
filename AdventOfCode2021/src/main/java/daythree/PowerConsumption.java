package daythree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
public class PowerConsumption implements Rating {
    
    private int gammaRate;
    private int epsilonRate;
    
}