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
public abstract class Venue {
    
    private String name;
    public Place place;
    
    public Venue(String name){
        this.name = name;
        
        
    }
    public abstract void place(Place place);
    
    public void setPlace(Place place){
        this.place = place;
    }
    public String getName(){
        return name;
    }
    public Place getPlace(){
        return place;
    }
    
    @Override
    public String toString(){
        return "Venue : " + getPlace() +  " Name : "+ getName();
    }
        
    
}
