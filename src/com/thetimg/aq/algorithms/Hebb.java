package com.thetimg.aq.algorithms;

public class Hebb {
    
    protected double learningRule(double r, double i, double o){
        return r * i * o; //rate * input * output
    }
}
