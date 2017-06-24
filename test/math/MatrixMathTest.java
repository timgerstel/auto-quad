package math;

import com.thetimg.aq.math.Matrix;
import com.thetimg.aq.math.MatrixMath;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MatrixMathTest {
    
    @Rule
    public Timeout global = new Timeout(1000L, TimeUnit.MILLISECONDS);
    
    private Matrix a, b;
    
    @Before
    public void before(){
        a = new Matrix(5, 4, "Mat A");
        int ind = 0;
        for(int i = 0; i < a.getRows(); i++){
            for(int j = 0; j < a.getCols(); j++){
                a.set(i, j, ind);
                a.set(i, j, ind);
                ind++;
            }
        }
        b = a.clone();
    }
    
    @Test
    public void testAdd(){
        Matrix c = a.clone();
        c.clear();
        Matrix d = MatrixMath.add(a, b);
        Matrix e = MatrixMath.add(a, c);
        for(int i = 0; i < a.getRows(); i++){
            for(int j = 0; j < a.getCols(); j++){
                assertEquals(a.get(i, j) + b.get(i, j), d.get(i, j), 0.0);
                assertTrue(a.equals(e));
            }
        }
    }
    
    @Test
    public void testDivide(){
        Matrix c = a.clone();
        c.clear();
        Matrix d = MatrixMath.divide(a, b);
        Matrix e = MatrixMath.divide(a, c);
        for(int i = 0; i < a.getRows(); i++){
            for(int j = 0; j < a.getCols(); j++){
                assertEquals(a.get(i, j) / b.get(i, j), d.get(i, j), 0.0);
                assertTrue(e.equals(a));
            }
        }
    }
}
