
package Average;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author shruti
 */
public class Avg_Mapper extends Mapper <Object, Text, YearPrice, DoubleWritable > {
    
    public void map (Object key, Text value, Context context) throws IOException, InterruptedException
    {
        try{
 
        String row[] = value.toString().split(",");
        String symbol = row[1].trim();
        double price = Double.parseDouble(row[3].trim());
         String strDate = row[0];
                String dateparts[] = strDate.split("/");
                String yer = dateparts[2].substring(0,4).trim();
        YearPrice yp = new YearPrice(yer, symbol);
      //  double stock_price = Double.valueOf(price);
               
        context.write(yp, new DoubleWritable(price));
        
        
        }catch (NumberFormatException e){
        
        }
    }
        
    
}
