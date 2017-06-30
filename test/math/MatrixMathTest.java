package math;

import com.sun.org.apache.xpath.internal.SourceTree;
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
        c = new Matrix(5, 1, "Mat A");
        for(int i = 0; i < c.getRows(); i++){
            c.set(i, 0, i);
        }
        b = a.clone();
    }
    
    @Test
    public void testAddSub(){
        Matrix c = a.clone();
        c.clear();
        Matrix d = MatrixMath.add(a, b);
        Matrix e = MatrixMath.subtract(a, b);
        Matrix f = MatrixMath.add(a, c);
        for(int i = 0; i < a.getRows(); i++){
            for(int j = 0; j < a.getCols(); j++){
                assertEquals(a.get(i, j) + b.get(i, j), d.get(i, j), 0.0);
                assertEquals(a.get(i, j) - b.get(i, j), e.get(i, j), 0.0);
                assertTrue(a.equals(f));
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
        System.out.println("/// TEST DOT PRODUCT ///");
        Matrix d = MatrixMath.transpose(c);
        System.out.println("Mat C: ");
        c.print();
        System.out.println("Transpose of Mat C: ");
        assertTrue(c.isColVector());
        assertTrue(d.isRowVector());
        d.print();
        System.out.println("Dot product of Mat c and transpose of C: " + MatrixMath.dotProduct(c, d));
    }
    
    @Test
    public void testIdentitiy(){
        Matrix d = new Matrix(3, 3, "Mat D");
        for(int i = 0; i < d.getRows(); i++){
            assertEquals(1, MatrixMath.identity(d).get(i, i), 0);
        }
    }
    
    @Test
    public void testMultiply(){
        Matrix c = a.clone();
        c.clear();
        Matrix d = MatrixMath.multiply(this.c, MatrixMath.transpose(this.c));
        Matrix e = MatrixMath.multiply(a, MatrixMath.transpose(c));
        d.print();
    }
    
    @Test
    public void testTranspose(){
        Matrix c = MatrixMath.transpose(a);
        assertEquals(a.getRows(), c.getCols());
        System.out.println(a.label +" :");
        a.print();
        System.out.println("Transpose of Mat A: ");
        c.print();
    }
    
    @Test
    public void testVectorLength(){
        Matrix d = MatrixMath.transpose(c);
        assertEquals(5, MatrixMath.vectorLength(c));
        assertEquals(5, MatrixMath.vectorLength(d));
    }
}
