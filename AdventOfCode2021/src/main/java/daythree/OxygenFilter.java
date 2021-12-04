package daythree;

import lombok.Data;

@Data
public class OxygenFilter implements Runnable {
    
    private volatile String oxygenRating;
    
    
    
    @Override
    public void run() {
        
    }
}
