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
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
    // Write your code here
        Collections.sort(sticks);
    
    int n = sticks.size();
    
    // 2. Iterate from the end to find the largest possible sticks that form a triangle
    // We check triplets (sticks[i], sticks[i+1], sticks[i+2])
    for (int i = n - 3; i >= 0; i--) {
        long a = sticks.get(i);
        long b = sticks.get(i + 1);
        long c = sticks.get(i + 2);
        
        // 3. Triangle Inequality Theorem: a + b > c
        if (a + b > c) {
            // Return the sides in non-decreasing order
            return Arrays.asList((int)a, (int)b, (int)c);
        }
    }
    
    // 4. If no valid triangle is found, return -1 in a list
    return Arrays.asList(-1);
    }

}

public class MaximumPerimeterTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.maximumPerimeterTriangle(sticks);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
