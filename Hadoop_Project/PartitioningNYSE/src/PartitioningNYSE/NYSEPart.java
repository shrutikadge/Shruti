/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PartitioningNYSE;

/**
 *
 * @author shruti
 */
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 *
 * @author shruti
 */
public class NYSEPart extends Configured implements Tool {

    /**
     * @param args the command line arguments
     */
    public static class IPcountMapper
            extends Mapper<LongWritable, Text, Text, Text> {
       
        private Text wordText = new Text();
    //  private final static SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        public void map(LongWritable key, Text line, Context context) throws IOException, InterruptedException {
            
            
                String []words=line.toString().split(",");
                String strDate = words[0];
                String dateparts[] = strDate.split("/");
                String yer = dateparts[2];
                //    String symbol = words[1].trim();
              //  Date creationDate = frmt.parse(strDate);
               // String year = String.valueOf(creationDate.getYear());
               // String d = words[3].substring(4,7);
             
                wordText.set(yer);
                context.write(wordText, line);
            
            
           
        }
    }
    public static class IPcountReducer extends Reducer<Text, Text, Text, NullWritable> {

        

        public void reduce(Text key, Iterable<Text> values,
                Reducer.Context context)
                throws IOException, InterruptedException {
            for(Text t:values)
            context.write(t, NullWritable.get());
        }
    }
    
    public static class IPcountPartitioner extends Partitioner<Text, Text> {

        @Override
        public int getPartition(Text key, Text value, int i) {
           
            
            return (key.hashCode() & Integer.MAX_VALUE) % i;
        }

       
    }
    
    public int run(String[] args) throws Exception,ClassNotFoundException {
        Configuration conf = getConf();
        Job job = new Job(conf, "IPcount");
        job.setJarByClass(NYSEPart.class);
        //final File f = new File(NYSEPart.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        Path in = new Path(args[0]);
        Path out = new Path(args[1]);
        FileInputFormat.setInputPaths(job, in);
        FileOutputFormat.setOutputPath(job, out);
        job.setMapperClass(IPcountMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setCombinerClass(IPcountReducer.class);
        job.setReducerClass(IPcountReducer.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        job.setPartitionerClass(IPcountPartitioner.class);
        job.setNumReduceTasks(7);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new NYSEPart(), args);
        System.exit(res);
    }
    
}