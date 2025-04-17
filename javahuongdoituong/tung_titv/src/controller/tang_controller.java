package controller;

import view.tang_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tang_controller implements ActionListener {
private tang_view tv;
public tang_controller(tang_view tv){
    this.tv = tv;
}
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("tang")){

          this.tv.increment();



        }
        else if(action.equals("giam")){
            this.tv.decrement();
        }
        else if(action.equals("reset")){
            this.tv.reset();
        }
    }
}
