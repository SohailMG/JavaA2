/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.scene.control.Button;

/**
 *
 * @author sohailgsais
 */
public class CustomButton extends Button{
    
    public CustomButton(String label, double width,double height){
        super(label);
        
        this.setMinHeight(height);
        this.setMinWidth(width);
        this.setMaxHeight(height);
        this.setMaxWidth(width);
        this.prefHeight(height);
        this.prefWidth(width);
    }
    
}
