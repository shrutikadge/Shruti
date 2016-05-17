/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Electricity;

import Business.Electricity.Electricity.EType;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author kedarvdm
 */
public class ElectricityDirectory {
    
    private List<Electricity> elecCatalog;

    public ElectricityDirectory() {
    elecCatalog = new ArrayList<Electricity>();
    }
    
    public List<Electricity> getElecCatalog(){
        return elecCatalog;
    }
    
    
    public Electricity addProduct(/*EType type*//*,int q,int peakHourP,int nonPeakP,Instant peakHourStart, Instant peakHourEnd*/){
        Electricity e = new Electricity();
        elecCatalog.add(e);
//         if (type.getValue().equals(EType.Coal.getValue())){
//            e = new CoalEnergy();
//            elecCatalog.add(e);
//        }
//         if (type.getValue().equals(EType.Hydro.getValue())){
//            e = new HydroEnergy();
//            elecCatalog.add(e);
//        }
//         if (type.getValue().equals(EType.Solar.getValue())){
//            e = new SolarEnergy();
//            elecCatalog.add(e);
//        }
//         if (type.getValue().equals(EType.Wind.getValue())){
//            e = new WindEnergy();
//            elecCatalog.add(e);
       // }
         
         
       // elecCatalog.add(e);
       return e;
    }
    
    
}
