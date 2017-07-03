package com.thetimg.aq.util;

public class BiPolarUtil {
    
    public static double toDouble(boolean value){
        return (value ? 1.0 : -1.0);
    }
    
    public static double[] toDouble(boolean[] data){
        double[] ret = new double[data.length];
        for(int i = 0; i < ret.length; i++){
                ret[i] = toDouble(data[i]);
        }
        return ret;
    }
    
    public static double[][] toDouble(boolean[][] data){
        double[][] ret = new double[data.length][data[0].length];
        for(int i = 0; i < ret.length; i++){
            for(int j = 0; j < ret[0].length; j++){
                ret[i][j] = toDouble(data[i][j]);
            }
        }
        return ret;
    }
    
    public static boolean toBipolar(double value){
        return (value == 1.0);
    }
    
    public static boolean[] toBipolar(double[] data){
        boolean[] ret = new boolean[data.length];
        for(int i = 0; i < ret.length; i++){
            ret[i] = toBipolar(data[i]);
        }
        return ret;
    }
    
    public static boolean[][] toBipolar(double[][] data){
        boolean[][] ret = new boolean[data.length][data[0].length];
        for(int i = 0; i < ret.length; i++){
            for(int j = 0; j < ret[0].length; j++){
                ret[i][j] = toBipolar(data[i][j]);
            }
        }
        return ret;
    }
    
}
