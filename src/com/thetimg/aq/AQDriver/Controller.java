package com.thetimg.aq.AQDriver;

import com.thetimg.aq.gui.networks.GuiHopfield;
import com.thetimg.aq.networks.Hopfield;

public class Controller {

    static Hopfield hf = new Hopfield(4);

    public static void main(String[] args){
        GuiHopfield gf = new GuiHopfield(hf);
        gf.showWindow();
    }
}
