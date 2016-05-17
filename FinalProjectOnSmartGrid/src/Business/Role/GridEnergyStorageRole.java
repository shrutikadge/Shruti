/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.GridEnergyStorageOrganization;
//import Business.Person.Businss;
//import Business.Person.CustomerDirectory;
import Business.Person.PowerStationAdmin;
import Business.Person.Provider;
//import Business.Person.SmartMeterDirectory;
import Business.UserAccount.UserAccount;

import UserInterface.GridEnergyStorageRole.GridStorageWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author shruti
 */
public class GridEnergyStorageRole extends Role{
    
    //CustomerDirectory c=new CustomerDirectory();
    //PowerStationAdmin p=new PowerStationAdmin();
  //  Provider s=new Provider();
   // SmartMeterDirectory sDir=new SmartMeterDirectory();
   // Businss b= new Businss();
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem business) {
        return new GridStorageWorkAreaJPanel(userProcessContainer, account, (GridEnergyStorageOrganization)organization, enterprise);
        
    }
}
