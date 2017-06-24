package com.thetimg.aq.math;

public class MatrixMath {
    
    //Sum every cell of the parameter matrices
    public static Matrix add(Matrix a, Matrix b){
        String label = a.label + "+" + b.label;
        Matrix add = new Matrix(a.getRows(), a.getCols(), label);
        if(dimensionsEqual(a, b)){
            if(a.isEmpty() || b.isEmpty()) {
                add = b.isEmpty() ? new Matrix(a.toArray(), label) : new Matrix(b.toArray(), label);
            } else {
                int rows = a.getRows();
                int cols = a.getCols();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        add.set(i, j, (a.get(i, j) + b.get(i, j)));
                    }
                }
            }
        }
        return add;
    }
    
    private static boolean dimensionsEqual(Matrix a, Matrix b){
        if(a.getRows() != b.getRows() || a.getCols() != b.getCols()){
            System.out.println("Dimensions of " + a.label + " and " + b.label + " are not the same.");
            return false;
        }
        return true;
    }
    
    //Divide every cell of the parameter matrices
    public static Matrix divide(Matrix a, Matrix b) {
        String label = a.label + "/" + b.label;
        Matrix div = new Matrix(a.getRows(), a.getCols(), label);
        if(dimensionsEqual(a,b)){
            if(b.isEmpty()){
                System.out.println("Cannot divide by zero");
                div = new Matrix(a.toArray(), label);
            } else if(a.isEmpty()){
                return div;
            } else {
                int rows = a.getRows();
                int cols = a.getCols();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        div.set(i, j, (a.get(i, j) / b.get(i, j)));
                    }
                }
            }
        }
        return div;
    }
    
    public static double dotProduct(Matrix a, Matrix b){
        Matrix dot = new Matrix(a.getRows(), a.getCols(), a.label + "\\U+2022" + b.label);
        if((a.isRowVector() && b.isColVector()) || (a.isColVector()) && a.isRowVector()){
        
        }
        return dot.sum();
    }
    
    public static Matrix multiply(Matrix a, Matrix b){
        String label = a.label + "*" + b.label;
        Matrix mult = new Matrix(a.getRows(), b.getCols(), label);
        return mult;
    }
    
}
