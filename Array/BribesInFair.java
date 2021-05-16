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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

   // https://www.hackerrank.com/challenges/new-year-chaos/problem

public static void minimumBribes(List<Integer> q) {
    int bribes=0;

    //  1 2 3 4 5 6 7 8 - i
    //  1 2 5 3 4 7 8 6 - q[i-1]

    //  0 1 2 3 4 5 6 7 - i-1

    //  2 1 5 3 4       - q[i-1]
    //  1 2 3 4 5       - i
    //  0 1 2 3 4         i -1

    for(int i = q.size(); i>=1; i --) { // i = 5->1
        
        //check for chaotic condition
        if((q.get(i-1) - i) > 2) {
            System.out.println("Too chaotic");
            return;
        }

        //case where it is not chaotic
        int startPos = Math.max( q.get(i-1)-3, 0 ); 
        int endPos   = i-2;

        for(int j = startPos; j<=endPos; j++) {
            if(q.get(j) > q.get(i-1))
                bribes++;
        }
    }

    System.out.println(bribes);  
}
}

public class BribesInFair {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
