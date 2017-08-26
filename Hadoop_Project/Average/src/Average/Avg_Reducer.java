
package Average;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
//import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author shruti
 */
public class Avg_Reducer extends Reducer <YearPrice, DoubleWritable, YearPrice, DoubleWritable> {
        
    public void reduce(YearPrice key, Iterable <DoubleWritable> values, Context context) throws IOException, InterruptedException 
    {
        float count = 0;
        float sum =0;
        
        
        for(DoubleWritable val: values)
        {
            sum += val.get();
            count += 1;
        }
        
        context.write(key,new DoubleWritable(sum/count));
    }
    
}
