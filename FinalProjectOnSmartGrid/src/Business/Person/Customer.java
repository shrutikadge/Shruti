/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author shruti
 */
public class Customer extends Person{
    
    
    private String name;
    
     private int buyCount;
     private ApplianceDirectory adir;
     private Time t;
     private int count=0;
     private int id;

     public Customer()
     {
         count++;
         count=id;
         adir=new ApplianceDirectory();
     }
    public int getBuyCount() {
        return buyCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public ApplianceDirectory getAdir() {
        return adir;
    }

    public void setAdir(ApplianceDirectory adir) {
        this.adir = adir;
    }

    public Time getT() {
        return t;
    }

    public void setT(Time t) {
        this.t = t;
    }

    
    
    
    
  /*  @Override
    public int compareTo(Customer o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        if(this.getBuyCount()>o.getBuyCount())
        {
            return -1;
        }
        else if(this.getBuyCount()<o.getBuyCount())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }*/
}
