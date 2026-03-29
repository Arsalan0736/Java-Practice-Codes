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

class TimeConversion {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
        int h1=(int)s.charAt(0)-'0';
        int h2=(int )s.charAt(1)-'0';
        int h=(h1*10+h2);
        String res="";
        if(s.charAt(8)=='A')
        {
            if(h==12)
            {
                res+="00";
                for(int i=2;i<s.length()-2;i++)
                {
                    res+=s.charAt(i);
                }
            }else{
                for(int i=0;i<s.length()-2;i++)
                {
                    res+=s.charAt(i);
                }
            }
            
        }else{
            if(h<12)
                h+=12;
            res+=h;
            for(int i=2;i<s.length()-2;i++)
            {
                res+=s.charAt(i);
            }
            
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
