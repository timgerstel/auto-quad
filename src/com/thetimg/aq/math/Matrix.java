package com.thetimg.aq.math;

import java.util.Arrays;

public class Matrix {
    
    private double[][] matrix;
    private int rows, cols;
    private static boolean isRowVector = false, isColVector = false;
    private boolean isSquare = false;
    private boolean isEmpty = true;
    public String label = "No Label (Shoutout Migos)";
    
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        if (rows == 0 || cols == 0) {
            System.out.println("Cannot create 0 x 0 matrix");
            this.matrix = new double[1][1];
        } else {
            if(rows == cols){
                isSquare = true;
            }
            if(rows == 1){
                isRowVector = true;
            }
            if(cols == 1){
                isColVector = true;
            }
            this.matrix = new double[rows][cols];
        }
    }
    
    public Matrix(int rows, int cols, String label){
        this.rows = rows;
        this.cols = cols;
        this.label = label;
        if(rows == 0 || cols == 0){
            System.out.println("Cannot create 0 x 0 matrix");
            this.matrix = new double[1][1];
        } else {
            if(rows == cols){
                isSquare = true;
            }
            if(rows == 1){
                isRowVector = true;
            }
            if(cols == 1){
                isColVector = true;
            }
            this.matrix = new double[rows][cols];
        }
    }
    
    public Matrix(double[][] matrix, String label){
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.label = label;
        if(rows == cols){
            isSquare = true;
        }
        if(rows == 1){
            isRowVector = true;
        }
        if(cols == 1){
            isColVector = true;
        }
        this.matrix = matrix;
    }
    
    private Matrix(double[] vector, String label){
        this.label = label;
        if(isRowVector){
            this.rows = 1;
            this.cols = vector.length;
            this.matrix = new double[rows][cols];
            matrix[0] = vector;
        } else if(isColVector){
            this.rows = vector.length;
            this.cols = 1;
            this.matrix = new double[rows][cols];
            for(int i = 0; i < rows; i++){
                matrix[i][0] = vector[i];
            }
        }
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
    public static Matrix createColMatrix(double[] vector, String label){
        isColVector = true;
        return new Matrix(vector, label);
    }
    
    //Returns an empty row matrix
    public static Matrix createRowMatrix(double[] vector, String label){
        isRowVector = true;
        return new Matrix(vector, label);
    }
    
    //Add value to every element in matrix
    public void add(double value){
        isEmpty = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = matrix[i][j] + value;
            }
        }
    }
    
    //Set every matrix value to 0
    public void clear(){
        isEmpty = true;
        matrix = new double[rows][cols];
    }
    
    //Returns a copy of this Matrix object
    public Matrix clone(){
        Matrix ret = new Matrix(matrix, this.label + " Clone");
        ret.isEmpty = isEmpty;
        return ret;
    }
    
    //Return value at parameter indices
    public double get(int row, int col){
        return matrix[row][col];
    }
    
    public void set(int row, int col, double value) {
        isEmpty = false;
        matrix[row][col] = value;
    }
    
    //Return true if the m is equal to this object
    public boolean equals(Matrix m){
        if(rows != m.getRows() || cols != m.getCols()){
            return false;
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] != m.get(i, j)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isRowVector(){
        return isRowVector;
    }
    
    public boolean isColVector() {
        return isColVector;
    }
    
    public boolean isSquare(){
        return isSquare;
    }
    
    public boolean isEmpty(){
        return isEmpty;
    }
    
    public double sum(){
        if(isEmpty()){
            return 0;
        }
        double sum = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                sum = sum + matrix[i][j];
            }
        }
        return sum;
    }
    
    public Matrix rowSubmatrix(int row){
        Matrix ret = new Matrix(1, cols, this.label);
        ret.isEmpty = isEmpty;
        for(int i = 0; i < cols; i++){
            ret.set(0, i, matrix[row][i]);
        }
        return ret;
    }
    
    public Matrix colSubmatrix(int col){
        Matrix ret = new Matrix(rows, 1, this.label);
        ret.isEmpty = isEmpty;
        for(int i = 0; i < rows; i++){
            ret.set(i, 0, matrix[i][col]);
        }
        return ret;
    }
    
    //Return submatrix for the given start and end indices
    public Matrix submatrix(int rowStart, int rowEnd, int colStart, int colEnd){
        Matrix ret = new Matrix(rowEnd - rowStart,colEnd - colStart, this.label);
        ret.isEmpty = isEmpty;
        for(int i = 0; i < ret.getRows(); i++){
            for(int j = 0; j < ret.getCols(); j++){
                ret.set(i, j, matrix[rowStart + i][colStart + j]);
            }
        }
        return ret;
    }
    
    public double[] toPackedArray(){
        double[] ret = new double[rows * cols];
        int count = 0;
        for(double[] row : matrix){
            for(double val : row){
                ret[count] = val;
                count++;
            }
        }
        return ret;
    }
    
    public void print(){
        for(double[] rows : matrix){
            System.out.println(Arrays.toString(rows));
        }
    }
    
    public double[][] toArray(){
        return matrix;
    }
    
}
