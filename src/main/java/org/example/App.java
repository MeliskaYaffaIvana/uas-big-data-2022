package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String check = args[1].toString();
        conf.set("World Data", check);
        Job job = Job.getInstance(conf, "Covid 19_1");

        job.setJarByClass(UasMapper.class);

        job.setMapperClass(UasMapper.class);
        job.setReducerClass(UasReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
