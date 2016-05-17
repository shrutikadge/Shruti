/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Electricity.Electricity;
import Business.Electricity.ElectricityDirectory;
//import Business.Electricity.ElectricityDirectory;

/**
 *
 * @author shruti
 */
public class PowerStationAdmin extends Person{
    
//    public enum Type{
//        Coal("Coal energy"),Wind("Wind Energy"),Solar("Solar Panel Energy"),Hydro("Hydro energy");
//        private String value;
//        private Type(String value){
//            this.value = value;
//        }
//        private String getValue(){
//            return value;
//        }
//    }
   // private String name;
    private Electricity e;
    private ElectricityDirectory eDirectory;

    public PowerStationAdmin(){
        e=new Electricity();
        eDirectory=new ElectricityDirectory();
    }
    
    public ElectricityDirectory geteDirectory() {
        return eDirectory;
    }

   
    

    public void seteDirectory(ElectricityDirectory eDirectory) {
        this.eDirectory = eDirectory;
    }

    public Electricity getE() {
        return e;
    }

    public void setE(Electricity e) {
        this.e = e;
    }
    
    
    public String toString() {
      // Type t=null;
       // return t.getValue(); //To change body of generated methods, choose Tools | Templates.
        return getName();
    }
}
