/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sohailgsais
 */
public class Town extends Venue{
    private String townName;

    public Town(String name) {
        super(name);
//        this.townName = townName;
    }
    
    public String getTownName(){
        return townName;
    }
    @Override
    public String toString(){
        
        String obj = "Town : " + super.getName() ;
        
        return obj;
        
    }
    
}
