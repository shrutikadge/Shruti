/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Average;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 *
 * @author shruti
 */
public class AvgPartitioner extends Partitioner<YearPrice, DoubleWritable>{

    @Override
    public int getPartition(YearPrice key, DoubleWritable value, int i) {
    return (key.getYear().hashCode() % i);
    }
    
}
