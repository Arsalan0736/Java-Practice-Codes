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
    // This is the global variable the function will use
    public static List<Integer> width;

    /*
     * Complete the 'serviceLane' function below.
     */
    public static List<Integer> serviceLane(int n, List<List<Integer>> cases) {
        List<Integer> results = new ArrayList<>();

        for (List<Integer> testCase : cases) {
            int start = testCase.get(0);
            int end = testCase.get(1);
            
            // Vehicles can be width 1, 2, or 3. Start at 3 and find the constraint.
            int minWidth = 3; 
            
            for (int k = start; k <= end; k++) {
                if (width.get(k) < minWidth) {
                    minWidth = width.get(k);
                }
            }
            results.add(minWidth);
        }

        return results;
    }
}

public class ServiceLane {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int t = Integer.parseInt(firstMultipleInput[1]);

        // FIX: Assign the parsed list directly to Result.width
        Result.width = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> cases = new ArrayList<>();

        IntStream.range(0, t).forEach(i -> {
            try {
                cases.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.serviceLane(n, cases);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}