package com.thetimg.aq.structures;

public class Neuron {
    
    private double input;
    private double threshold;
    
    public Neuron(double input, double threshold){
        this.input = input;
        this.threshold = threshold;
    }
    
    public double getThreshold(){
        return threshold;
    }
}
