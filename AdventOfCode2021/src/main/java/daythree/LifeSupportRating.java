package daythree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
public class LifeSupportRating implements Rating {
    
    private int oxygenRate;
    private int co2ScrubberRate;
    
}