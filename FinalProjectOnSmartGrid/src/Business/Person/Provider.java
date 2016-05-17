/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author shruti
 */
public class Provider extends Person{
    
     public static int count=0;
    private int smartMeterID;
    
    
    
    public Provider()
    {
        count++;
        smartMeterID=count;
        /*Setting default commissions*/
        
    }
    
    public int getSmartMeterID() {
        return smartMeterID;
    }

    public void setSmartMeterID(int smartMeterID) {
        this.smartMeterID = smartMeterID;
    }

    
    
    

    
    @Override
    public String toString()
    {
        return getName();
    }

    
    

    
}
