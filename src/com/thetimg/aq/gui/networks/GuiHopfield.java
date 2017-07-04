package com.thetimg.aq.gui.networks;

import com.thetimg.aq.networks.Hopfield;
import javafx.application.Application;

import javax.swing.*;
import javax.swing.text.StyledDocument;
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
    private static Hopfield hn;
    
    public GuiHopfield(Hopfield network){
        super("Hopfield Training");
        hn = network;
        setSize(WIDTH, HEIGHT);
        setContentPane(panel1);
    }
    
    private void createUIComponents() {
        textPane1 = new JTextPane();
        textPane1.setText("No data");
        StyledDocument doc = textPane1.getStyledDocument();
        try{
            double[][] matrix = hn.getMatrix().toArray();
            int i = 0;
            for(double[] row : matrix){
                doc.insertString(i++, Arrays.toString(row), null);
            }
        }catch(Exception e){
            System.err.print(e);
        }
    }
    
    public JTextPane getTextPane1() {
        return textPane1;
    }
    
    public JButton getExecuteButton() {
        return executeButton;
    }
    
    public JButton getTrainButton() {
        return trainButton;
    }
    
    public JButton getClearMatrixButton() {
        return clearMatrixButton;
    }
    
    public JTextArea getTextArea1() {
        return textArea1;
    }
    
    public JComboBox getComboBox1() {
        return comboBox1;
    }
    
    public JComboBox getComboBox2() {
        return comboBox2;
    }
    
    public JComboBox getComboBox3() {
        return comboBox3;
    }
    
    public JComboBox getComboBox4() {
        return comboBox4;
    }
    
    public JPanel getComboPanel() {
        return comboPanel;
    }
    
    public JPanel getBottomPanel() {
        return bottomPanel;
    }
    
}
