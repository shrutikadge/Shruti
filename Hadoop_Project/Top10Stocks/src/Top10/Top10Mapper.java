/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Top10;

import java.io.IOException;
import java.util.TreeMap;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author shruti
 */
public class Top10Mapper extends Mapper <Object, Text, NullWritable, Text > {
    
    private TreeMap<Double,Text> maprec = new TreeMap<Double, Text>();
    public void map (Object key, Text value, Mapper.Context context) throws IOException, InterruptedException{
        
 
        String row[] = value.toString().split(",");
        String symbol = row[1].trim();
        double price = Double.parseDouble(row[3].trim());
       
        maprec.put(price,new Text(value));
        if(maprec.size()>10){
            maprec.remove(maprec.firstKey());
        }
        
        //context.write(yp, new DoubleWritable(price));
        
        
        
    }
        
    protected void cleanup(Context context) throws IOException, InterruptedException{
        for(Text t: maprec.values()){
            context.write(NullWritable.get(), t);
        }
    }
    
}