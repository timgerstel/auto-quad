package math;

import com.thetimg.aq.math.Matrix;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MatrixTest {
    
    @Rule
    public Timeout global = new Timeout(1000L, TimeUnit.MILLISECONDS);
    
    private Matrix a, b, c, d, e, f;
    
    @Before
    public void before(){
        a = new Matrix(5, 1);
        b = new Matrix(5, 4);
        c = Matrix.createColumnMatrix(5);
        d = Matrix.createRowMatrix(5);
        e = new Matrix(1, 5);
        int ind = 0;
        f = new Matrix(b.getRows(), b.getCols());
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
        assertFalse(b.isEmpty() && f.isEmpty());
        assertTrue(a.isEmpty() && c.isEmpty() && d.isEmpty() && e.isEmpty());
    }
    
    @Test
    public void testDimensions() {
        assertEquals(5, a.getRows());
        assertEquals(1, a.getCols());
        assertEquals(5, b.getRows());
        assertEquals(4, b.getCols());
        assertEquals(1, c.getRows());
        assertEquals(5, c.getCols());
        assertEquals(5, d.getRows());
        assertEquals(1, d.getCols());
    }
    
    @Test
    public void testAddClear(){
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
        Matrix g = b.clone();
        assertTrue(b.equals(f));
        assertTrue(b.equals(g));
    }
    
    @Test
    public void testIsVector(){
        assertTrue(a.isVector());
        Matrix e = a.clone();
        assertTrue(e.isVector());
        assertFalse(b.isVector());
        assertTrue(this.e.isVector());
    }
    
    @Test
    public void testSubmatrix(){
        Matrix sub = b.submatrix(0, 1, 0, b.getCols());
        Matrix sub2 = b.rowSubmatrix(0);
        assertTrue(sub.isVector());
        assertFalse(sub.isEmpty());
        for(int i = 0; i < b.getCols(); i++){
            assertTrue(b.get(0, i) == sub.get(0, i));
            assertTrue(b.get(0, i) == sub2.get(0, i));
        }
    }
    
}
