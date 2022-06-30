package org.example;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public final class UasReducer extends Reducer<Text, Text, Text, Text> {

    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<Text> values,
                       Context context
    ) throws IOException, InterruptedException {
        int sum = 0;
        for (Text val : values) {
            sum += Integer.parseInt(val.toString());
        }
        context.write(key, new Text(String.valueOf(sum)));
    }
}