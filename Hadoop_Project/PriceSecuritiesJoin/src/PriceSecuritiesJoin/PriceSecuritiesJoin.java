/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceSecuritiesJoin;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 *
 * @author shruti
 */
public class PriceSecuritiesJoin {
    
    public static class JoinMapper1 extends Mapper<Object, Text, Text, Text> {

        private Text outkey = new Text();
        private Text outvalue = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            // Parse the input string into a nice map
            String[] separatedInput = value.toString().split("\",");
            String symbol = separatedInput[0].substring(1).trim();
          //  if (symbol == null) {
            //    return;
            //}
            // The foreign join key is the user ID
            outkey.set(symbol);
            // Flag this record for the reducer and then output
            outvalue.set("S" + value.toString());
            context.write(outkey, outvalue);
        }
    }

    public static class JoinMapper2 extends Mapper<Object, Text, Text, Text> {

        private Text outkey = new Text();
        private Text outvalue = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String[] separatedInput = value.toString().split(",");
           
            String symbol = separatedInput[1].trim();
           // if (symbol == null) {
             //   return;
            //}
            // The foreign join key is the user ID
            outkey.set(symbol);
            // Flag this record for the reducer and then output
            outvalue.set("P" + value.toString());
            context.write(outkey, outvalue);
        }
    }

    public static class JoinReducer extends Reducer<Text, Text, Text, Text> {

        private static final Text EMPTY_TEXT = new Text("");
        private Text tmp = new Text();
        private ArrayList<Text> listA = new ArrayList<Text>();
        private ArrayList<Text> listB = new ArrayList<Text>();
        private String joinType = null;

        public void setup(Context context) {
            // Get the type of join from our configuration
            joinType = context.getConfiguration().get("join.type");
        }

        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            // Clear our lists
            listA.clear();
            listB.clear();
            // iterate through all our values, binning each record based on what
            // it was tagged with. Make sure to remove the tag!
            while (values.iterator().hasNext()) {
                tmp = values.iterator().next();
                System.out.println(Character.toString((char) tmp.charAt(0)));
               // if (Character.toString((char) tmp.charAt(0)).equals("S")) {

                  if(tmp.charAt(0)=='S') 
                    listA.add(new Text(tmp.toString().substring(1)));
             //   }
               // if (Character.toString((char) tmp.charAt(0)).equals("P")) {
                    else if(tmp.charAt(0)=='P')
                    listB.add(new Text(tmp.toString().substring(1)));
                //}
               // System.out.println(tmp);
            }
            // Execute our join logic now that the lists are filled

            System.out.println(listB.size());
            executeJoinLogic(context);
        }

        private void executeJoinLogic(Context context) throws IOException, InterruptedException {

           // if (joinType.equalsIgnoreCase("inner")) {
                // If both lists are not empty, join A with B
                //System.out.println("here3");
                if (!listA.isEmpty() && !listB.isEmpty()) {
                    
                    for (Text A : listA) {
                        //System.out.println("here1");
                        for (Text B : listB) {
                            //System.out.println("here2");
                            context.write(A, B);
                        }
                    }
                }
          //  }   
        }
    }

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf, "ReduceSideJoin");
        job.setJarByClass(PriceSecuritiesJoin.class);

        // Use MultipleInputs to set which input uses what mapper
        // This will keep parsing of each data set separate from a logical
        // standpoint
        // The first two elements of the args array are the two inputs
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, JoinMapper1.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, JoinMapper2.class);
       job.getConfiguration().set("join.type", "inner");
        //job.setNumReduceTasks(0);
        job.setReducerClass(JoinReducer.class);

       job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path(args[2]));

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.waitForCompletion(true);
    }
    
}
