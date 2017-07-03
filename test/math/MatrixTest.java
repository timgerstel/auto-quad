package math;

import com.thetimg.aq.math.Matrix;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MatrixTest {
    
    @Rule
    public Timeout global = new Timeout(1000L, TimeUnit.MILLISECONDS);
    
    private Matrix a, b, c, d, e, f;
    private double[] data = {1.0, 2.0, 3.0, 4.0, 5.0};
    
    @Before
    public void before(){
        a = new Matrix(5, 1, "Mat A");
        b = new Matrix(5, 4, "Mat B");
        c = Matrix.createColMatrix(data, "Mat C");
        d = Matrix.createRowMatrix(data, "Mat D");
        e = new Matrix(1, 5, "Mat E");
        int ind = 0;
        f = new Matrix(b.getRows(), b.getCols(), "Mat F");
        for(int i = 0; i < b.getRows(); i++){
            for(int j = 0; j < b.getCols(); j++){
                b.set(i, j, ind);
                f.set(i, j, ind);
                ind++;
            }
        }
    }
    
    @Test
    public void testIsEmpty(){
        System.out.println("// TEST IS EMPTY //");
        assertFalse(b.isEmpty() && c.isEmpty() && d.isEmpty() && f.isEmpty());
        assertTrue(a.isEmpty() && e.isEmpty());
    }
    
    @Test
    public void testDimensions() {
        System.out.println("\n// TEST DIMENSIONS //");
        assertEquals(5, a.getRows());
        assertEquals(1, a.getCols());
        assertEquals(5, b.getRows());
        assertEquals(4, b.getCols());
        assertEquals(5, c.getRows());
        assertEquals(1, c.getCols());
        assertEquals(1, d.getRows());
        assertEquals(5, d.getCols());
    }
    
    @Test
    public void testAddClear(){
        System.out.println("\n// TEST ADD CLEAR //");
        a.add(5);
        b.add(5);
        assertEquals(a.getRows() * a.getCols() * 5, a.sum(), 0.0);
        assertEquals(290, b.sum(), 0.0);
        assertFalse(a.isEmpty() && b.isEmpty());
        a.clear();
        b.clear();
        assertTrue(a.isEmpty() && b.isEmpty());
    }
    
    @Test
    public void testCloneEquals(){
        System.out.println("\n// TEST CLONE EQUALS //");
        Matrix g = b.clone();
        assertTrue(b.equals(f));
        assertTrue(b.equals(g));
    }
    
    @Test
    public void testIsVector(){
        System.out.println("\n// TEST IS VECTOR //");
        assertTrue(a.isColVector());
        Matrix e = a.clone();
        assertTrue(e.isColVector());
        System.out.println("B is Col Vector: " + b.isColVector());
        b.print();
        assertFalse(b.isColVector() || b.isRowVector());
        assertTrue(this.e.isRowVector());
    }
    
    @Test
    public void testSubmatrix(){
        System.out.println("\n// TEST SUBMMATRIX //");
        Matrix sub = b.submatrix(0, 1, 0, b.getCols());
        Matrix sub2 = b.rowSubmatrix(0);
        Matrix sub3 = b.colSubmatrix(0);
        assertTrue(sub.isRowVector());
        assertFalse(sub.isEmpty());
        for(int i = 0; i < b.getRows(); i++){
            for(int j = 0; j < b.getCols(); j++) {
                assertTrue(b.get(0, j) == sub.get(0, j));
                assertTrue(b.get(0, j) == sub2.get(0, j));
            }
            assertTrue(b.get(i,0) == sub3.get(i, 0));
        }
    }
    
    @Test
    public void testToPackedArray(){
        System.out.println("\n// TEST TO PACKED ARRAY //");
        double[] bArray = b.toPackedArray();
        System.out.println(b.label + " toPackedArray(): ");
        System.out.println("Length: " + bArray.length);
        System.out.println(Arrays.toString(bArray));
    }
    
    @Test
    public void testPrint(){
        b.print();
    }
    
}
