package CharityRuns;


import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sohailgsais
 */
public class myDate {
    
    private int year;
    private int day;
    private int month;
    private int hours;
    private int minutes;
    private int seconds;
    
    
    public myDate(){
        
    }
    
    
    public myDate(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public myDate(int hours,int minutes){
        
        this.hours = hours;
        this.minutes = minutes;   
        
    }
    public String getTime(){
        
        String time = "" + hours + ":" + minutes ;
        
        
        return time;
        
    }
    public String getDate(){
        
        String date = "" + day + "/" + month + "/" + year ;        
        return date;
        
    }
    
    public int getYear(){
        return year;
    }
    public int getMotnh(){
        return month;
    }
    public int getDay(){
        return day;
    }
    
    public void setYear(int year){
        this.year = year;
        
    }
    public void setMonth(int month){
        this.month = month;
        
    }
    public void setDay(int day){
        this.day = day;
        
    }
   
    
}
