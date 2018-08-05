package com.oracle.forKPI;

import com.oracle.clear.JobUtil;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MRWordCountPV {
    public static class ForMapper extends Mapper<LongWritable,Text,Text,NullWritable> {
        private Text okey=new Text();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            DataProcess data=DataProcess.dataCut(value);
            int index=data.getPv().toString().indexOf("?");
            if(index!=-1){
                okey.set(data.getPv().toString().substring(0,index));
            } else{
                okey.set(data.getPv().toString());
            }
            context.write(okey,NullWritable.get());
        }
    }

    public static class ForReducer extends Reducer<Text,NullWritable,Text,IntWritable> {
        private IntWritable ovalue=new IntWritable();
        @Override
        protected void reduce(Text key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
            int sum=0;
            for(NullWritable i:values){
                sum++;
            }
            ovalue.set(sum);
            context.write(key,ovalue);
        }
    }

    public static void main(String[] args) {
        JobUtil.commitJob(MRWordCountPV.class,"E:\\1703\\Hadoop\\作业\\MapReduce经典案例 WordCount 练习题及答案\\MapReduce经典案例 WordCount 练习题及答案\\实验数据","");
    }
}
