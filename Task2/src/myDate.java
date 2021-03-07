
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
    
    
    public myDate(){
        GregorianCalendar date = new GregorianCalendar();
        year = date.get(Calendar.YEAR);
        month = date.get(Calendar.MONTH);
        day = date.get(Calendar.DAY_OF_MONTH);
        
    }
    
    public myDate(long elapsedTime){
        GregorianCalendar date = new GregorianCalendar();
        date.setTimeInMillis(elapsedTime);
        
        year = date.get(Calendar.YEAR);
        month = date.get(Calendar.MONTH);
        day = date.get(Calendar.DAY_OF_MONTH);
    }
    
    public myDate(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
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
