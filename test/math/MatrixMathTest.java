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
    
    private Matrix a, b, c;
    
    @Before
    public void before(){
        a = new Matrix(5, 4, "Mat A");
        int ind = 0;
        for(int i = 0; i < a.getRows(); i++){
            for(int j = 0; j < a.getCols(); j++){
                a.set(i, j, ind);
                ind++;
            }
        }
        a = new Matrix(5, 1, "Mat A");
        for(int i = 0; i < a.getRows(); i++){
            a.set(i, 0, i);
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
    
    @Test
    public void testDotProduct(){
    
    }
    
    @Test
    public void testMultiply(){
        Matrix c = a.clone();
        c.clear();
        Matrix d = MatrixMath.multiply(a, MatrixMath.transpose(b));
        Matrix e = MatrixMath.multiply(a, c);
        d.print();
    }
    
    @Test
    public void testTranspose(){
        Matrix c = MatrixMath.transpose(a);
        assertEquals(a.getRows(), c.getCols());
        a.print();
        System.out.println("Transpose of Mat A: ");
        c.print();
    }
}
