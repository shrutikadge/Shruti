/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AverageProj;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 *
 * @author shruti
 */
public class YearSymComparator extends WritableComparator{
    
   protected YearSymComparator()
    {
        super(YearPrice.class, true);
    }
    
    @Override
    public int compare(WritableComparable w1, WritableComparable w2)
    {
        YearPrice cw1 = (YearPrice) w1;
        YearPrice cw2 = (YearPrice) w2;
        
           return (cw1.getYear().compareTo(cw2.getYear()));
    }
    
}
