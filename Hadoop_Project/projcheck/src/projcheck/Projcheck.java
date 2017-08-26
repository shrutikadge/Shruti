/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projcheck;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
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
public class Projcheck extends Configured implements Tool{

    /**
     * @param args the command line arguments
     */
    public static class IPcountMapper
            extends Mapper<LongWritable, Text, Text, Text> {
       // private static IntWritable one = new IntWritable(1);
        private Text wordText = new Text();
        private Text word = new Text();
        public void map(LongWritable key, Text line, Context context) throws IOException, InterruptedException {
            String []words=line.toString().split(",");
           // for (String word : words) {
                word.set(words[1].trim()+" "+words[3].trim());
                wordText.set(words[0].trim());
                context.write(wordText, word);
           // }
        }
    }
    public static class IPcountReducer extends Reducer<Text, Text, Text, Text> {

        //private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<Text> values,
                Reducer.Context context)
                throws IOException, InterruptedException {
            for(Text t:values)
            context.write(key, t);
        }
    }
    
    public int run(String[] args) throws Exception,ClassNotFoundException {
        Configuration conf = getConf();
        Job job = new Job(conf, "IPcount");
        job.setJarByClass(Projcheck.class);
        final File f = new File(Projcheck.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        //String inFiles = f.getAbsolutePath().replace("/build/classes", "") + "/src/inFiles/access.log";
       // String outFiles = f.getAbsolutePath().replace("/build/classes", "") + "/src/outFiles/IPcount";
        //use the arguments instead if provided.
       // if (args.length > 1) {
       //     inFiles = args[1];
        //    outFiles = args[2];
        //}
        //System.out.println(inFiles);
        //System.out.println(outFiles);
        Path in = new Path(args[1]);
        Path out = new Path(args[2]);
        FileInputFormat.setInputPaths(job, in);
        FileOutputFormat.setOutputPath(job, out);
        job.setMapperClass(IPcountMapper.class);
        job.setCombinerClass(IPcountReducer.class);
        job.setReducerClass(IPcountReducer.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new Projcheck(), args);
        System.exit(res);
    }
}
