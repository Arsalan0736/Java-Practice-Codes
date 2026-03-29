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
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
        int commonLength = 0;
    int minLen = Math.min(s.length(), t.length());

    // 1. Find the length of the common prefix
    for (int i = 0; i < minLen; i++) {
        if (s.charAt(i) == t.charAt(i)) {
            commonLength++;
        } else {
            break;
        }
    }

    int deletionsRequired = s.length() - commonLength;
    int appendsRequired = t.length() - commonLength;
    int minOperations = deletionsRequired + appendsRequired;

    // 2. Determine if it's possible in exactly k moves
    if (k >= s.length() + t.length()) {
        // We can delete everything and have moves left over to delete an empty string
        return "Yes";
    } else if (k >= minOperations && (k - minOperations) % 2 == 0) {
        // We can perform the exact changes and any extra moves in pairs (append/delete)
        return "Yes";
    } else {
        return "No";
    }
    }

}

public class AppendAndDelete {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
