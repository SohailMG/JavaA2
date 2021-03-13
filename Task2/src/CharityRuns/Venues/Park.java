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
public class Park extends Venue{
    
    private int numChangingFacilites;

    public Park( String name , int numChangingFacilites) {
        super( name);
        this.numChangingFacilites = numChangingFacilites;
    } 

   
    public int getNumChangingFacilites(){
        return numChangingFacilites;
    }

    @Override
    public void place(Place place) {
        super.setPlace(place);
    }
    
    @Override
    public String toString(){
        
        String obj =  super.getName() +"\n" + "Chaning Facilities :" + getNumChangingFacilites();
        
        return obj;
        
    }
    
    
    
    
}
