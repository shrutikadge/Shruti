/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.PowerStationOrganization;
import Business.Organization.Organization;
import Business.Person.PowerStationAdmin;
//import Business.Person.PowerStationAdminDirectory;
import Business.UserAccount.UserAccount;
import UserInterface.PowerStationAdminRole.PowerStationWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class PowerStationRole extends Role{

   // PowerStationAdmin p=new PowerStationAdmin();
   // PowerStationAdminDirectory pDir=new PowerStationAdminDirectory();
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PowerStationWorkAreaJPanel(userProcessContainer, account, (PowerStationOrganization)organization, enterprise);
    }
    
    
}
