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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        setVisible(true);
    }
    
    private void createUIComponents() {
        textPane1 = new JTextPane();
        textPane1.setText("No data");
        StyledDocument doc = textPane1.getStyledDocument();
        try{
            textPane1.setText("");
            double[][] matrix = hn.getMatrix().toArray();
            int i = 0;
            for(double[] row : matrix){
                doc.insertString(i++, Arrays.toString(row), null);
            }
        }catch(Exception e){
            System.err.print(e);
        }
    }
    
}
