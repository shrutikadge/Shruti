/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Electricity.Electricity;
import java.util.ArrayList;

/**
 *
 * @author shruti
 */
public class Order {
    
    private ArrayList <OrderItem> orderItemList;
    private int orderNumber;
     private static int count = 0;
     
     
      public Order()
    {
        orderItemList = new ArrayList<OrderItem>();
        count++;
        orderNumber = count;
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public OrderItem addOrderItem(Electricity electricity, int quantity)
    {
        OrderItem orderItem = new OrderItem();
        orderItem.setElectricity(electricity);
        orderItem.setQuantity(quantity);            //mke changes
        orderItemList.add(orderItem);
        return orderItem;
    }
    public void removeOrderItem(OrderItem orderItem)
    {
        int newAvailability = orderItem.getElectricity().getAvailability() +  orderItem.getQuantity();       //mke chnges
        orderItem.getElectricity().setAvailability(newAvailability);
         orderItemList.remove(orderItem);
    }

    @Override
    public String toString() {
        return String.valueOf(orderNumber);
    }
    
}
