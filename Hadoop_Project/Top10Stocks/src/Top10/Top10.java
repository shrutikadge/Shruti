/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Top10;

import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 *
 * @author shruti
 */
public class Top10 {
    public static void main(String args[])  throws IOException, InterruptedException, ClassNotFoundException, URISyntaxException {
        // TODO code application logic here
        Configuration conf = new Configuration(); 
        
         
        
        Job job = new Job(conf, "Averge");
       
        job.setJarByClass(Top10.class);
        
        job.setMapperClass(Top10Mapper.class);
        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Text.class);
                
	job.setReducerClass(Top10Reducer.class);
        job.setOutputKeyClass(NullWritable.class);
	job.setOutputValueClass(Text.class);
        
        Path in = new Path(args[0]);
        Path out = new Path(args[1]);
        
        FileInputFormat.setInputPaths(job, in);
        FileOutputFormat.setOutputPath(job, out);
        
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        
        //job.setPartitionerClass(AvgPartitioner.class);
        job.setNumReduceTasks(1);
       
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    
        
    }
}
