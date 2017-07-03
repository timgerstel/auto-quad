package com.thetimg.aq.networks;

import com.thetimg.aq.math.Matrix;
import com.thetimg.aq.math.MatrixMath;
import com.thetimg.aq.util.BiPolarUtil;

import java.util.Arrays;

public class Hopfield {
    
    private Matrix weights;
    
    public Hopfield(int size){
        weights = new Matrix(size, size, "Hopfield Weights");
    }
    
    public boolean[] present(final boolean[] pattern){
        System.out.println("// PRESENTING Pattern: " + Arrays.toString(pattern));
        final boolean out[] = new boolean[pattern.length];
        System.out.println("Pattern as double array: " + Arrays.toString(BiPolarUtil.toDouble(pattern)));
        final Matrix input = Matrix.createRowMatrix(BiPolarUtil.toDouble(pattern));
        for(int i = 0; i < pattern.length; i++){
            Matrix col = weights.colSubmatrix(i);
            System.out.println("Weight Col[" + i + "] Vector: ");
            col.print();
            final double dot = MatrixMath.dotProduct(input, col);
            System.out.println("Dot product of Col and Col^T: " + dot);
            out[i] = (dot > 0);
        }
        return out;
    }
    
    public void train(final boolean[] pattern){
        final Matrix input = Matrix.createRowMatrix(BiPolarUtil.toDouble(pattern));
        final Matrix inputT = MatrixMath.transpose(input);
        final Matrix train = MatrixMath.multiply(inputT, input);
        final Matrix ident = MatrixMath.identity(train);
        final Matrix out = MatrixMath.subtract(train, ident);
        weights = MatrixMath.add(weights, out);
        System.out.println("// TRAINING Pattern: " + Arrays.toString(pattern));
        System.out.println("Pattern as double array: " + Arrays.toString(BiPolarUtil.toDouble(pattern)));
        System.out.println("Input Matrix: ");
        input.print();
        System.out.println("Transpose of input matrix: ");
        inputT.print();
        System.out.println("Input^T * Input: ");
        train.print();
        System.out.println("Identity of Input^T * Input: ");
        ident.print();
        System.out.println("Input^T * Input - Identity: ");
        out.print();
        System.out.println("NEW WEIGHT MATRIX AFTER TRAINING: ");
        weights.print();
    }
    
    public Matrix getMatrix(){
        return weights;
    }
    
    //Return number of neurons
    public int getSize(){
        return weights.getRows();
    }
}
