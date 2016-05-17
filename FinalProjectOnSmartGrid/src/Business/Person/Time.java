/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import org.joda.time.DateTime;

/**
 *
 * @author shruti
 */
public class Time {
    
    private DateTime firstDate;
    private DateTime secondDate;
    private DateTime firstInstance;
    private DateTime lastInstance;
    
    private Duration duration;
    private org.joda.time.Period period1,period2;
    
    //period=new Period(firstInstance,lastInstance);

    public DateTime getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(DateTime firstDate) {
        this.firstDate = firstDate;
    }

    public DateTime getSecondDate() {
        return secondDate;
    }

    public void setSecondDate(DateTime secondDate) {
        this.secondDate = secondDate;
    }

   

    public DateTime getFirstInstance() {
        return firstInstance;
    }

    public void setFirstInstance(DateTime firstInstance) {
        this.firstInstance = firstInstance;
    }

    public DateTime getLastInstance() {
        return lastInstance;
    }

    public void setLastInstance(DateTime lastInstance) {
        this.lastInstance = lastInstance;
    }

    
    
    
    
    
    public int getHours()
    {
        period1=new org.joda.time.Period(firstInstance,lastInstance);
        //period=Period.between(firstDate,secondDate);
        int hours=period1.getHours();
        
        
        return hours;
    }
    
    public int getDays()
    {
        period2 =new org.joda.time.Period(firstDate,secondDate);
        int days=period2.getDays();
        return days;
    }
    
}
