/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author shruti
 */
public abstract class Enterprise extends Organization{
    
    
     private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
   
    
    
    public Enterprise(String name, EnterpriseType type){
        super(name);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
      
        
    }

   

    public enum EnterpriseType{
        
        EnergyEnterprise("Energy Enterprise"),SmartMeterEnterprise("SmartMeter Enterprise");
        

        
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

//    public MasterOrderCatalog getMasterOrderCatalog() {
//        return masterOrderCatalog;
//    }
//
//    public void setMasterOrderCatalog(MasterOrderCatalog masterOrderCatalog) {
//        this.masterOrderCatalog = masterOrderCatalog;
//    }
    

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
}
