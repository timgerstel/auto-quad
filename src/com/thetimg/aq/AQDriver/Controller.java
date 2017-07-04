package com.thetimg.aq.AQDriver;

import com.thetimg.aq.gui.networks.GuiHopfield;
import com.thetimg.aq.networks.Hopfield;

public class Controller {
    
    private static final Hopfield hn = new Hopfield(4);
    
    public static void main(String[] args){
        GuiHopfield h = new GuiHopfield(hn);
        
    }
}
