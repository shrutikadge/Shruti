/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Electricity.ElectricityDirectory;
import Business.Order.Order;
import Business.Person.ApplianceDirectory;
//import Business.Person.CustomerDirectory;
//import Business.Person.ElectricityDirectory;
import Business.Person.PersonDirectory;
//import Business.Person.PowerStationAdminDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
   private Order order;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;
    private ApplianceDirectory applianceDirectory;
    private ElectricityDirectory electricityDirectory;
    
    public enum Type{
        Admin("Admin Organization"), PowerStation("Power Station Employee Organization"), TransmissionNetwork("Transmission network employee Organization"),Provider("Provider Organization"),GridEnergyStorage("GridEnergyStorage Organization"),Customer("Customer Organization");
       // Admin("Admin Organization"), CityAdmin("City Admin Organization"), HomeAdmin("Home Admin Organization"),StateAdmin("State Admin Organization"),SmartMeter("Smart Meter Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        personDirectory = new PersonDirectory();
        applianceDirectory=new ApplianceDirectory();
        electricityDirectory=new ElectricityDirectory();
        userAccountDirectory = new UserAccountDirectory();
        order=new Order();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    
    
    
    public ApplianceDirectory getApplianceDirectory() {
        return applianceDirectory;
    }

    public void setApplianceDirectory(ApplianceDirectory applianceDirectory) {
        this.applianceDirectory = applianceDirectory;
    }

    public ElectricityDirectory getElectricityDirectory() {
        return electricityDirectory;
    }

    public void setElectricityDirectory(ElectricityDirectory electricityDirectory) {
        this.electricityDirectory = electricityDirectory;
    }
    
    
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
