/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharityRuns.presentation;

import CharityRuns.Coordinator;

/**
 *
 * @author sohailgsais
 */
public class Display {
    
    private Coordinator coord;
    
    public Display (Coordinator coord ){
        
        this.coord = coord;
        
    }
    
    public void displayUI(){
        
        int numOfRuns = coord.getFiveKRuns().size() + coord.getHalfMarathonRuns().size();
//        System.out.println(coord.getHalfMarathonRuns().get(0));
        for (int i = 0; i < numOfRuns; i++) {
                System.out.println(coord.getHalfMarathonRuns().get(i));
                System.out.println(coord.getFiveKRuns().get(i));
                System.out.println("");

            }
        
        
    }
    
    
    
}
