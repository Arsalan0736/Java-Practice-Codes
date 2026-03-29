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

class DayoftheProgrammer {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
    // Write your code here
        if (year == 1918) {
        // Transition year: February had only 15 days (14th to 28th)
        return "26.09.1918";
    }
    
    boolean isLeap = false;
    
    if (year < 1918) {
        // Julian Calendar: Leap year if divisible by 4
        if (year % 4 == 0) isLeap = true;
    } else {
        // Gregorian Calendar: Standard leap year rules
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            isLeap = true;
        }
    }
    
    // In leap years, the 256th day is Sept 12th. Otherwise, it's Sept 13th.
    return (isLeap ? "12.09." : "13.09.") + year;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
