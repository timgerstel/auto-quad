package com.thetimg.aq.math;

public class Matrix {
    
    private double[][] matrix;
    private int rows, cols;
    
    public Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.matrix = new double[rows][cols];
    }
    
    private Matrix(double[][] matrix){
        this.matrix = matrix;
    }
    
    //Returns number of rows
    public int getRows(){
        return rows;
    }
    
    //Returns number of cols
    public int getCols(){
        return cols;
    }
    
    //Returns an empty column matrix
    public Matrix createColumnMatrix(int cols){
       return new Matrix(1, cols);
    }
    
    //Returns an empty row matrix
    public Matrix createRowMatrix(int rows){
        return new Matrix(rows, 1);
    }
    
    //Add value to every element in matrix
    public void add(double value){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = matrix[i][j] + value;
            }
        }
    }
    
    //Set every matrix value to 0
    public void clear(double value){
        matrix = new double[rows][cols];
    }
    
    //Returns a copy of this Matrix object
    public Matrix clone(){
        return new Matrix(matrix);
    }
    
    //Return value at parameter indices
    public double get(int row, int col){
        return matrix[row][col];
    }
    
    //Return true if the m is equal to this object
    public boolean equals(Matrix m){
        if(rows != m.getRows() || cols != m.getCols()){
            return false;
        }
    }
    
}
