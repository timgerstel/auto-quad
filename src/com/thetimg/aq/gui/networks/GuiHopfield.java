package com.thetimg.aq.gui.networks;

import com.thetimg.aq.networks.Hopfield;
import com.thetimg.aq.util.BiPolarUtil;
import javafx.application.Application;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GuiHopfield extends JFrame {
    
    private static final int WIDTH = 350;
    private static final int HEIGHT = 500;
    private JTextPane textPane1;
    private JButton executeButton;
    private JButton trainButton;
    private JButton clearMatrixButton;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JPanel panel1;
    private JPanel comboPanel;
    private JPanel bottomPanel;
    private JTextArea textArea2;
    private static Hopfield hn;
    
    public GuiHopfield(Hopfield network){
        super("Hopfield Training");
        hn = network;
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        addListeners();
    }
    
    public void showWindow(){
        setVisible(true);
    }
    
    public void addListeners(){
        trainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] pattern = new double[4];
                pattern[0] = (double) Integer.parseInt((String) comboBox1.getSelectedItem());
                pattern[1] = (double) Integer.parseInt((String) comboBox2.getSelectedItem());
                pattern[2] = (double) Integer.parseInt((String )comboBox3.getSelectedItem());
                pattern[3] = (double) Integer.parseInt((String) comboBox4.getSelectedItem());
                hn.train(BiPolarUtil.toBipolar(pattern));
                updateMatrix();
            }
        });
    
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] pattern = new double[4];
                pattern[0] = (double) Integer.parseInt((String) comboBox1.getSelectedItem());
                pattern[1] = (double) Integer.parseInt((String) comboBox2.getSelectedItem());
                pattern[2] = (double) Integer.parseInt((String )comboBox3.getSelectedItem());
                pattern[3] = (double) Integer.parseInt((String) comboBox4.getSelectedItem());
                textArea1.setText(Arrays.toString(BiPolarUtil.toDouble(hn.present(BiPolarUtil.toBipolar(pattern)))));
            }
        });
    
        clearMatrixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hn.getMatrix().clear();
                updateMatrix();
            }
        });
    }
    
    private void updateMatrix(){
        textArea2.setText("");
        double[][] matrix = hn.getMatrix().toArray();
        for(double[] row : matrix){
            textArea2.append(Arrays.toString(row) + "\n");
        }
    }
    
    private void createUIComponents() {
        textArea2 = new JTextArea();
        try{
            double[][] matrix = hn.getMatrix().toArray();
            for(double[] row : matrix){
                textArea2.append(Arrays.toString(row) + "\n");
            }
        }catch(Exception e){
            System.err.print(e);
        }
    }
    
}
