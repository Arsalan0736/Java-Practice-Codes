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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
    // Write your code here
        int n = topic.size();
    int m = topic.get(0).length();
    int maxTopics = 0;
    int teamCount = 0;

    // Compare every pair of attendees
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            int currentTopics = 0;
            String person1 = topic.get(i);
            String person2 = topic.get(j);

            // Calculate combined topics for the team
            for (int k = 0; k < m; k++) {
                if (person1.charAt(k) == '1' || person2.charAt(k) == '1') {
                    currentTopics++;
                }
            }
            // Update global maximums
            if (currentTopics > maxTopics) {
                maxTopics = currentTopics;
                teamCount = 1;
            } else if (currentTopics == maxTopics) {
                teamCount++;
            }
        }
    }

    // Return the result as a list [maxTopics, teamCount]
    return Arrays.asList(maxTopics, teamCount);
    }

}

public class ACMICPCTeam {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

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
