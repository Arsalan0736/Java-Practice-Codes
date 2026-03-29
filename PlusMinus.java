import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class PlusMinus {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        double pos=0;
        double neg=0;
        double zero=0;
        double n=arr.size();
        for(int i:arr)
        {
            if(i>0)
                pos++;
            if(i<0)
                neg++;
            if(i==0)
                zero++;
        }
        
        
        Formatter fm=new Formatter();
        fm.format("%.6f", pos/n);
        System.out.println(fm);
        
        fm=new Formatter();
        fm.format("%.6f", neg/n);
        System.out.println(fm);
        
        fm=new Formatter();
        fm.format("%.6f", zero/n);
        System.out.println(fm);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
