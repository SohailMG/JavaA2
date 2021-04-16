package CharityRuns;


/**
 * Competitor class containing name age,event type and event name 
 * @author sohailgsais
 */
public class Competitor {
    private String name;
    private int age;
    private String eventType,eventName;
    
    public Competitor(){
        
    }
    // declaring competitor and initialising values
    public Competitor(String name , int age,String eventType,String eventName){
        this.name = name;
        this.age = age;
        this.eventType = eventType;
        this.eventName = eventName;
        
    }
    // getters
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
