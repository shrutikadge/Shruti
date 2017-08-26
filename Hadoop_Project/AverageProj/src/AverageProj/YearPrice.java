/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AverageProj;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;


/**
 *
 * @author shruti
 */
public class YearPrice implements Writable, WritableComparable<YearPrice>{
    
    private String year;
    private String symbol;

    public YearPrice() {
    }

    public YearPrice(String year, String symbol) {
        this.year = year;
        this.symbol = symbol;
    }

    
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.symbol);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final YearPrice other = (YearPrice) obj;
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        return true;
    }

    

    @Override
    public void write(DataOutput d) throws IOException {
    WritableUtils.writeString(d, year);
        WritableUtils.writeString(d, symbol);
    }

    @Override
    public void readFields(DataInput di) throws IOException {
   year = WritableUtils.readString(di);
        symbol = WritableUtils.readString(di);
    }

    @Override
    public String toString() {
        return symbol + " "+year;
    }

   

    @Override
    public int compareTo(YearPrice o) {
        int result = year.compareTo(o.year);
        if(result ==0)
        {
            result = symbol.compareTo(o.symbol);
        }
        return result;
    }

    
    
    
    
    
}
