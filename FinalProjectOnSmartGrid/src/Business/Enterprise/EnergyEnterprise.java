/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Order.MasterOrderCatalog;
import java.util.ArrayList;
import javax.management.relation.Role;

/**
 *
 * @author shruti
 */
public class EnergyEnterprise extends Enterprise{
    
    
     private MasterOrderCatalog masterOrderCatalog;
    
    public EnergyEnterprise(String name){
        super(name,EnterpriseType.EnergyEnterprise);
        masterOrderCatalog = new MasterOrderCatalog();
                
        
        
    }

    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    public void setMasterOrderCatalog(MasterOrderCatalog masterOrderCatalog) {
        this.masterOrderCatalog = masterOrderCatalog;
    }
    

    @Override
    public ArrayList<Business.Role.Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
