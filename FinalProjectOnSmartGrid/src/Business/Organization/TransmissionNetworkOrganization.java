/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PowerStationRole;
import Business.Role.TransmissionNetworkRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author shruti
 */
public class TransmissionNetworkOrganization extends Organization{
    
    public TransmissionNetworkOrganization() {
        super(Organization.Type.TransmissionNetwork.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new TransmissionNetworkRole());
        return roles;
    }
}
