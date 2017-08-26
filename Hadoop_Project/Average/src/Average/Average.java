/*
Use the NYSE files in HDFS to find the average price of stock_price_high values 

Remark - Completed and Running (NYSE_Output_11)
*/

package Average;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
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
public class Average {
    
    public static void main(String args[])  throws IOException, InterruptedException, ClassNotFoundException, URISyntaxException {
        // TODO code application logic here
        Configuration conf = new Configuration(); 
        
         
        
        Job job = new Job(conf, "Averge");
       
        job.setJarByClass(Average.class);
        
        job.setMapperClass(Avg_Mapper.class);
        job.setMapOutputKeyClass(YearPrice.class);
        job.setMapOutputValueClass(DoubleWritable.class);
                
	job.setReducerClass(Avg_Reducer.class);
        job.setOutputKeyClass(YearPrice.class);
	job.setOutputValueClass(DoubleWritable.class);
        
        Path in = new Path(args[0]);
        Path out = new Path(args[1]);
        
        FileInputFormat.setInputPaths(job, in);
        FileOutputFormat.setOutputPath(job, out);
        
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        
        job.setPartitionerClass(AvgPartitioner.class);
        job.setNumReduceTasks(7);
       
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    
        
    }
    
}
