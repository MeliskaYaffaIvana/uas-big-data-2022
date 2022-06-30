package org.example;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class UasMapper extends Mapper<Object, Text, Text, Text> {

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
        String txt = value.toString();
        String[] tokens = txt.split(",");

        if (tokens[0].compareTo("Province/State") != 0) {
            context.write(new Text(tokens[0].trim()), new Text(tokens[8].trim()));
        }
    }
}