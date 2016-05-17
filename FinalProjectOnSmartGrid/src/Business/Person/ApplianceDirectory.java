/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author shruti
 */
public class ApplianceDirectory {
    
    private ArrayList<Appliance> applianceList;
    
    public ApplianceDirectory()
    {
        applianceList=new ArrayList<>();
    }

    public ArrayList<Appliance> getApplianceList() {
        return applianceList;
    }

    public void setApplianceList(ArrayList<Appliance> applianceList) {
        this.applianceList = applianceList;
    }
    
    
}
