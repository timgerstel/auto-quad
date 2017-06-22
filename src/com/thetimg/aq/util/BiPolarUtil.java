package com.thetimg.aq.util;

public class BiPolarUtil {
    
    public static double toDouble(boolean value){
        return (value ? 1.0 : -1.0);
    }
    
    public static boolean toBipolar(double value){
        return (value == 1.0);
    }
    
}
