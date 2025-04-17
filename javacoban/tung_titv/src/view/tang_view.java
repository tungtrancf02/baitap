package view;

import controller.tang_controller;
import model.couter_model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class tang_view extends JFrame {
private couter_model couter_model;
    private JLabel so;

    public tang_view() {
        this.couter_model = new couter_model();
        this.init();
    }

        public void init() {
            this.setTitle("Tang giam");
            this.setSize(300, 200);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);

            ActionListener actionListener = new tang_controller(this) ;
            JButton tang = new JButton("tang");
            tang.addActionListener(actionListener);
            JButton giam = new JButton("giam");
            giam.addActionListener(actionListener);
            JButton reset = new JButton("reset");
            reset.addActionListener(actionListener);


            JPanel panel = new JPanel();
            reset.setBounds(50,200,50,50);
            this.add(reset, BorderLayout.SOUTH);
            this.add(panel);

            this.add(giam, BorderLayout.EAST);
            this.add(tang, BorderLayout.WEST);


            so = new JLabel(this.couter_model.getValue() + "",JLabel.CENTER);
            this.add(so, BorderLayout.CENTER);
            this.setVisible(true);

        }
        public void increment(){
        this.couter_model.increment();
        this.so.setText(this.couter_model.getValue() + "");
        }
    public void decrement(){
        this.couter_model.decrement();
        this.so.setText(this.couter_model.getValue() + "");
    }
    public void reset(){
        this.couter_model.reset();
        this.so.setText(this.couter_model.getValue() + "");
    }


    }


