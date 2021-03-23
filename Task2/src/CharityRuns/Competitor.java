package CharityRuns;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sohailgsais
 */
public class Competitor {
    private String name;
    private int age;
    private String eventType,eventName;
    
    public Competitor(){
        
    }
    public Competitor(String name , int age,String eventType,String eventName){
        this.name = name;
        this.age = age;
        this.eventType = eventType;
        this.eventName = eventName;
        
    }
    
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getEventType(){
        return eventType;
    }
    public String geteventName(){
        return eventName;
    }
    
    @Override
    public String toString(){
        String obj = "" + getName() + " " + getAge();
        
        return obj;
    }
}
