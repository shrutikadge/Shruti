/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;


public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.PowerStation.getValue())){
            organization = new PowerStationOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Provider.getValue())){
            organization = new ProviderOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.TransmissionNetwork.getValue())){
            organization = new TransmissionNetworkOrganization();
            organizationList.add(organization);
        }
        /*else if(type.getValue().equals(Type.DistributionLine.getValue())){
            organization = new DistributionLineOrganization();
            organizationList.add(organization);
        }*/
        else if(type.getValue().equals(Type.GridEnergyStorage.getValue())){
            organization = new GridEnergyStorageOrganization();
            organizationList.add(organization);
        }
        
        
        return organization;
    }
    
    public Organization getOrganization(Organization.Type organizationType)
    {
        for(Organization organization:organizationList)
        {
            if(organization.getName().equals(organizationType.getValue()))
            {
                return organization;
            }
        }
        return null;
    }
     public boolean isUserAccountDuplicate(String userName)
    {
        boolean isUnique = false;
        for(Organization organization: organizationList)
        {
            for(UserAccount userAccount:organization.getUserAccountDirectory().getUserAccountList())
            {
                if(userAccount.getUsername().equals(userName))
                {
                    return true;
                }
            }
        }
        return isUnique;
    }
}