/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AverageProj;

/**
 *
 * @author shruti
 */
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
//import org.apache.hadoop.io.AverageTuple;
//import org.apache.hadoop.io.YearPrice;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
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
public class AveragePrice extends Configured implements Tool {

    /**
     * @param args the command line arguments
     */
    public static class AvMapper
            extends Mapper<LongWritable, Text, YearPrice,DoubleWritable> {
       
        //private Text key = new Text();
        //Text tup = new Text();
        YearPrice yp = new YearPrice();
        // private final static SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        public void map(LongWritable key, Text line, Context context) throws IOException, InterruptedException,NumberFormatException {
            
             
                 String []words=line.toString().split(",");
                 
                 double price = Double.parseDouble(words[3].trim());
                 // int year = Integer.parseInt(words[0].trim().substring(6,10));
                String strDate = words[0];
                String dateparts[] = strDate.split("/");
                String yer = dateparts[2].substring(0,4).trim();
                
                 String symbol = words[1].trim();
                 
                 //tup.setSymbol(symbol);
                 yp.setSymbol(symbol);
                 yp.setYear(yer);
                 //yp.setPrice(price);
                 //int count =
                 //ext.set(d);
                 //AverageTuple tup = new AverageTuple(symbol,year);
                 context.write(yp,new DoubleWritable(price));
             
           
        }
    }
    public static class AvReducer extends Reducer<YearPrice, DoubleWritable, YearPrice, DoubleWritable> {

       // public AverageTuple result = new AverageTuple();
       //YearPrice yp=new YearPrice();
        public void reduce(YearPrice key, Iterable<DoubleWritable> values,
                Reducer.Context context)
                throws IOException, InterruptedException {
        double sum = 0;
        int count = 0;
        
        //int year = 0;
        for(DoubleWritable v:values){
            sum += v.get();
            count += 1;
        }
        double av=sum/count;
        for (DoubleWritable val: values )
        {
            
            context.write(key, av);
          
        }
           //double av = sum/count;
          
            
        }
    }
    
//    public static class AvPartitioner extends Partitioner<AverageTuple, YearPrice> {
//
//        @Override
//        public int getPartition(AverageTuple key, YearPrice value, int i) {
//           
//            String year = String.valueOf(key.getYear());
//            return (year.hashCode() & Integer.MAX_VALUE) % i;
//        }
//
//       
//    }
    
    public int run(String[] args) throws Exception,ClassNotFoundException {
        Configuration conf = getConf();
        Job job = new Job(conf, "Avg");
        job.setJarByClass(AveragePrice.class);
        //final File f = new File(AveragePrice.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        Path in = new Path(args[0]);
        Path out = new Path(args[1]);
        
        FileInputFormat.setInputPaths(job, in);
        FileOutputFormat.setOutputPath(job, out);
        
        job.setMapperClass(AvMapper.class);
        job.setMapOutputKeyClass(YearPrice.class);
        job.setMapOutputValueClass(DoubleWritable.class);
        
        job.setGroupingComparatorClass(YearSymComparator.class);
       // job.setCombinerClass(AvReducer.class);
        job.setReducerClass(AvReducer.class);
        
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        
        job.setOutputKeyClass(YearPrice.class);
        job.setOutputValueClass(DoubleWritable.class);
        job.setPartitionerClass(AvgPartitioner.class);
        job.setNumReduceTasks(7);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new AveragePrice(), args);
        System.exit(res);
    }
    
}