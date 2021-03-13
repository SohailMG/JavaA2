package CharityRuns.Venues;

import CharityRuns.Place;

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
        
    }


    
    public String getTownName(){
        return townName;
    }
    

    @Override
    public void place(Place place) {
        super.setPlace(place);
        
    }
    @Override
    public String toString(){
        
        String obj = ""  + super.getName() ;
        
        return obj;
        
    }
    
}
