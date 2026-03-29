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

class Result {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
    // Write your code here
        boolean found = false;
    String firstNumStr = "";

    // The first number can at most be half the length of the string
    for (int i = 1; i <= s.length() / 2; i++) {
        // Get the starting number
        String sub = s.substring(0, i);
        long firstNum = Long.parseLong(sub);
        
        // Build the sequence starting from firstNum
        StringBuilder testString = new StringBuilder(sub);
        long nextNum = firstNum;
        
        while (testString.length() < s.length()) {
            nextNum++;
            testString.append(nextNum);
        }
        
        // Check if it matches exactly
        if (testString.toString().equals(s)) {
            found = true;
            firstNumStr = sub;
            break;
        }
    }

    if (found) {
        System.out.println("YES " + firstNumStr);
    } else {
        System.out.println("NO");
    }
    }

}

public class SeparatetheNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
