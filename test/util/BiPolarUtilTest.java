package util;

import com.thetimg.aq.util.BiPolarUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class BiPolarUtilTest {
    @Rule
    public Timeout global = new Timeout(1000L, TimeUnit.MILLISECONDS);
    
    @Test
    public void testToDouble(){
        assertEquals(1.0, BiPolarUtil.toDouble(true), 0.0);
        assertEquals(-1.0, BiPolarUtil.toDouble(false), 0.0);
    }
    
    @Test
    public void testToBipolar(){
        assertTrue(BiPolarUtil.toBipolar(1.0));
        assertFalse(BiPolarUtil.toBipolar(-1.0));
    }
}
