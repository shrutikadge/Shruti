/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Electricity.Electricity;

/**
 *
 * @author shruti
 */
public class OrderItem {
    
    private Electricity electricity;
    private int quantity;
    private int salesPrice;
    private boolean peakHour;
    
    public OrderItem()
    {
        peakHour=false;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Electricity getElectricity() {
        return electricity;
    }

    public void setElectricity(Electricity electricity) {
        this.electricity = electricity;
    }

    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        if(!peakHour){
        this.salesPrice = this.quantity*this.electricity.getNonPeakHourPrice();}
        else{
            this.salesPrice=this.quantity*this.electricity.getPeakHourPrice();
        }
    }
    
   

    @Override
    public String toString() {
        return electricity.getElectricitySource();
    }
}
