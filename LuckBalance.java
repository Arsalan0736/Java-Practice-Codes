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
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY contests
     */

    public static int luckBalance(int k, List<List<Integer>> contests) {
    // Write your code here
        int totalLuck = 0;
    List<Integer> importantContests = new ArrayList<>();

    for (List<Integer> contest : contests) {
        int luck = contest.get(0);
        int importance = contest.get(1);

        if (importance == 0) {
            // Unimportant contests: always lose to add luck
            totalLuck += luck;
        } else {
            // Store luck of important contests to sort later
            importantContests.add(luck);
        }
    }

    // Sort important contests in ascending order
    Collections.sort(importantContests);

    // Lena must win some if number of important contests > k
    // We lose the largest ones, and win the smallest ones.
    int mustWinCount = importantContests.size() - k;

    for (int i = 0; i < importantContests.size(); i++) {
        if (i < mustWinCount) {
            // Win the smallest luck contests (subtract from balance)
            totalLuck -= importantContests.get(i);
        } else {
            // Lose the largest luck contests (add to balance)
            totalLuck += importantContests.get(i);
        }
    }

    return totalLuck;
    }

}

public class LuckBalance {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> contests = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                contests.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
