/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Person.Customer;
import Business.Person.DistributionRoleAdmin;
import Business.Person.Person;
import Business.Person.PowerStationAdmin;
import Business.Person.TransmissionNetworkAdmin;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author raunak
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Person employee;
    private Customer c;
    private PowerStationAdmin p;
    private TransmissionNetworkAdmin t;
    private DistributionRoleAdmin d;
    private Role role;
    private WorkQueue workQueue;

    public UserAccount() {
//        p=new PowerStationAdmin();
        c=new Customer();
//        t=new TransmissionNetworkAdmin();
//        d=new DistributionRoleAdmin();
        workQueue = new WorkQueue();
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public PowerStationAdmin getP() {
        return p;
    }

    public void setP(PowerStationAdmin p) {
        this.p = p;
    }

    public TransmissionNetworkAdmin getT() {
        return t;
    }

    public void setT(TransmissionNetworkAdmin t) {
        this.t = t;
    }

    public DistributionRoleAdmin getD() {
        return d;
    }

    public void setD(DistributionRoleAdmin d) {
        this.d = d;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Person employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}