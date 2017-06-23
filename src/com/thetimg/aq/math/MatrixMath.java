package com.thetimg.aq.math;

public class MatrixMath {
    
    public static Matrix add(Matrix a, Matrix b){
        Matrix add = new Matrix(a.getRows(), a.getCols());
        if(dimensionsEqual(a, b)){
            int rows = a.getRows();
            int cols = a.getCols();
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    add.set(i, j, a.get(i,j) + b.get(i,j));
                }
            }
            return add;
        }
        System.out.println("Cannot add two matrices of different dimensions");
        return a;
    }
    
    public static boolean dimensionsEqual(Matrix a, Matrix b){
        if(a.getRows() != b.getRows() || a.getCols() != b.getCols()){
            return false;
        }
        return true;
    }
    
}
