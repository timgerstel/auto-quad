package networks;

import com.thetimg.aq.networks.Hopfield;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class HopfieldTest {
    
    @Rule
    public Timeout global = new Timeout(1000L, TimeUnit.MILLISECONDS);
    
    private final Hopfield hn = new Hopfield(4);
    private final boolean[] p1 = {true, true, false, false};
    private final boolean[] p2 = {true, false, false, false};
    private boolean[] result;
    
    @Test
    public void testHopfield(){
        hn.train(p1);
        result = hn.present(p1);
        System.out.println("Presenting pattern 1: " + Arrays.toString(p1) + " and returned result " + Arrays.toString(result));
        result = hn.present(p2);
        System.out.println("Presenting pattern 2: " + Arrays.toString(p2) + " and returned result " + Arrays.toString(result));
    }
    
}
