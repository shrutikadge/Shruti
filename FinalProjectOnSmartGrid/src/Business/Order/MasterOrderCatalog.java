/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Electricity.Electricity;
import Business.Organization.PowerStationOrganization;
import java.util.ArrayList;

/**
 *
 * @author shruti
 */
public class MasterOrderCatalog {
    
    private ArrayList <Order> orderCatalog; 
    
    
    
    
    public MasterOrderCatalog(){
        orderCatalog = new ArrayList<Order>();
    }

    public ArrayList<Order> getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(ArrayList<Order> orderCatalog) {
        this.orderCatalog = orderCatalog;
    }
    
    public Order addOrder(Order order){
        orderCatalog.add(order);
        return order;
        
    }
    
    public ArrayList<OrderItem> getPowerStationOrder(PowerStationOrganization organization){
        ArrayList<OrderItem> manufacturerOrder = new ArrayList<OrderItem>();
        for(Electricity electricity : organization.getElectricityDirectory().getElecCatalog()){
            for(Order order: orderCatalog){
                for(OrderItem orderItem : order.getOrderItemList()){
                     if(orderItem.getElectricity().getCurrentNumber()== electricity.getCurrentNumber())
                    {
                        manufacturerOrder.add(orderItem);
                    }
                }
            }
        }
        return manufacturerOrder;
                
        
        
    }
    public ArrayList<OrderItem> getElectricityOrder(Electricity electricity)
    {
        ArrayList<OrderItem> manufacturerOrder = new ArrayList<OrderItem>();
        
            for(Order order:orderCatalog)
            {
                for(OrderItem orderItem:order.getOrderItemList())
                {
                    if(orderItem.getElectricity().getCurrentNumber()== electricity.getCurrentNumber())
                    {
                        manufacturerOrder.add(orderItem);
                    }
                }
            }
        
        return manufacturerOrder;
    }
}
