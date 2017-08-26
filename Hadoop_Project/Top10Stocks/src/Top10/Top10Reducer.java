/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Top10;

import java.io.IOException;
import java.util.TreeMap;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author shruti
 */
public class Top10Reducer extends Reducer <NullWritable, Text, NullWritable, Text> {
     
    private TreeMap<Double,Text> maprec = new TreeMap<Double,Text>();
    public void reduce(NullWritable key, Iterable <Text> values, Reducer.Context context) throws IOException, InterruptedException 
    {
         for(Text val: values)
        {
        String row[] = values.toString().split(",");
       maprec.put(Double.parseDouble(row[3].trim()),new Text(val));
       if(maprec.size()>10)
           maprec.remove(maprec.firstKey());
        }
        for(Text t:maprec.descendingMap().values())
        context.write(NullWritable.get(),t);
    }
    
}
