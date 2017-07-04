package com.thetimg.aq.gui.networks;

import com.thetimg.aq.networks.Hopfield;

import javax.swing.*;

public class HopfieldWindow {
    
    private GuiHopfield g;
    private JTextPane textPane1;
    private JButton executeButton;
    private JButton trainButton;
    private JButton clearMatrixButton;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JPanel comboPanel;
    private JPanel bottomPanel;
    private Hopfield hn;
    
    public HopfieldWindow(Hopfield network){
        this.hn = network;
        init();
    }
    
    public void show(){
        g.setVisible(true);
    }
    
    private void init(){
        g = new GuiHopfield(hn);
        textPane1 = g.getTextPane1();
        executeButton = g.getExecuteButton();
        trainButton = g.getTrainButton();
        clearMatrixButton = g.getClearMatrixButton();
        textArea1 = g.getTextArea1();
        comboBox1 = g.getComboBox1();
        comboBox2 = g.getComboBox2();
        comboBox3 = g.getComboBox3();
        comboBox4 = g.getComboBox4();
        comboPanel = g.getComboPanel();
        bottomPanel = g.getBottomPanel();
    }
}
