package com.thetimg.aq.util;

/**
 * Created by Tim on 6/21/17.
 */
public class BiPolarUtil {
    
    public double toDouble(boolean value){
        return (value ? 1.0 : -1.0);
    }
    
    public boolean toBipolar(double value){
        return (value == 1.0);
    }
    
}
