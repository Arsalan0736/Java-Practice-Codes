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

class StrongPassword {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
        String spcl="!@#$%^&*()-+";
        Set<Character>s=new HashSet();
        for(int i=0;i<spcl.length();i++)
        {
            s.add(spcl.charAt(i));
        }
        
        boolean num=false;
        boolean upper=false;
        boolean lower=false;
        boolean spclC=false;
        
        for(int i=0;i<password.length();i++)
        {
            char ch=password.charAt(i);
            if(ch>='0'&&ch<='9')num=true;
            else if(ch>='a'&&ch<='z')lower=true;
            else if( ch>='A'&&ch<='Z')upper=true;
            else if(s.contains(ch)==true)spclC=true;
        }
        int d=0;
        if(num==true)d++;
        if(upper==true)d++;
        if(lower==true)d++;
        if(spclC==true)d++;
        int ans=(int )Math.max(6-n,4-d);
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
