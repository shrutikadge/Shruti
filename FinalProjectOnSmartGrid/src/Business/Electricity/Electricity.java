/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Electricity;

import Business.Person.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import org.joda.time.DateTime;

/**
 *
 * @author shruti
 */
public class Electricity implements Comparable<Electricity>{
   // private int count=1000;
    private String electricitySource;
    private int quantity;
    private int peakHourPrice;
    private int nonPeakHourPrice;
    private int soldQuantity;
    private DateTime peakHourStart;
    private DateTime peakHourEnd;
    private int availability;
    private Appliance appliance;
    private Time time;
    private static int count=0;
    private int currentNumber;
    

    public enum EType{
        Coal("Coal energy"),Wind("Wind Energy"),Solar("Solar Panel Energy"),Hydro("Hydro energy");
        private String value;
        private EType(String value){
            value = value;
        }
        public String getValue(){
            return value;
        }
    }
    public Electricity()
    {
        count++;
        currentNumber=count;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }
    
    
    
    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getElectricitySource() {
        return electricitySource;
    }

    public void setElectricitySource(String electricitySource) {
        this.electricitySource = electricitySource;
    }
    
    
    
    public int getNonPeakHourPrice() {
        return nonPeakHourPrice;
    }

    public void setNonPeakHourPrice(int nonPeakHourPrice) {
        this.nonPeakHourPrice = nonPeakHourPrice;
    }

    public DateTime getPeakHourStart() {
        return peakHourStart;
    }

    public void setPeakHourStart(DateTime peakHourStart) {
        this.peakHourStart = peakHourStart;
    }

    public DateTime getPeakHourEnd() {
        return peakHourEnd;
    }

    public void setPeakHourEnd(DateTime peakHourEnd) {
        this.peakHourEnd = peakHourEnd;
    }

   
    
    
    
    
    public Electricity(String electricitySource)
    {
        this.electricitySource=electricitySource;
      //  count++;
      //  quantity=count;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPeakHourPrice() {
        return peakHourPrice;
    }

    public void setPeakHourPrice(int peakHourPrice) {
        this.peakHourPrice = peakHourPrice;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
    
    @Override
    public int compareTo(Electricity o) {
        if(this.getSoldQuantity()>o.getSoldQuantity())
        {
            return -1;
        }
        else if(this.getSoldQuantity()<o.getSoldQuantity())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    public long getHour()
    {
       org.joda.time.Period p=new org.joda.time.Period(peakHourStart,peakHourEnd);
       int hours=p.getHours();
       return hours;
    }
    
    public int getBill(){
        long h=appliance.getTime().getHours();
        int p=appliance.getPowerRequirement();
        int s1=(int)h;
        int bill=p*s1;
        return bill;
    }
    
    public String toString()
    {
       
        return electricitySource;
    }
    
}
