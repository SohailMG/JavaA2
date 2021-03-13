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
    
    public Competitor(String name , int age){
        this.name = name;
        this.age = age;
        
    }
    
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    
    @Override
    public String toString(){
        String obj = "" + getName() + " " + getAge();
        
        return obj;
    }
}
