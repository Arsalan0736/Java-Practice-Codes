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

class DrawingBook {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
    // Write your code here
        int step=n/2+1;
        // checking from front
        int front=Integer.MAX_VALUE;
        // checking from last
        int last=Integer.MAX_VALUE;
        int j=step;
        int i=1;
        int k=0;
        int l=0;
        while(i<=step)
        {
            int firstF=2*(i-1);
            int secondF=2*i-1;
            if(firstF==p||secondF==p)
            {
                front=(int)Math.min(front,k);
            }
            k++;
            
            
            
            int firstL=2*(j-1);
            int secondL=2*j-1;
             if(firstL==p||secondL==p)
            {
                last=(int)Math.min(last,l);
            }
            l++;
            j--;
            i++;
        }
        
        int ans=Math.min(front,last);
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
