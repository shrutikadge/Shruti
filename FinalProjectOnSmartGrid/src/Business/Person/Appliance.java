/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Electricity.Electricity;

/**
 *
 * @author shruti
 */
public class Appliance {
    
    private String applianceName;
    private int powerRequirement;
    private Time time;
    private boolean isOn;
    private Electricity electricity;
    private Customer customer;
    
    public Appliance(/*Time time,Electricity electricity,Customer customer*/)
    {
        electricity=new Electricity();
        time=new Time();
        customer=new Customer();
        this.customer=customer;
        this.time=time;
        this.electricity=electricity;
        
        
    }
 /*   public Appliance()
    {
        
    }*/

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    public String getApplianceName() {
        return applianceName;
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }

    public int getPowerRequirement() {
        return powerRequirement;
    }

    public void setPowerRequirement(int powerRequirement) {
        this.powerRequirement = powerRequirement;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public boolean isIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public Electricity getElectricity() {
        return electricity;
    }

    public void setElectricity(Electricity electricity) {
        this.electricity = electricity;
    }
    
    
    
    

    
    
    
}
