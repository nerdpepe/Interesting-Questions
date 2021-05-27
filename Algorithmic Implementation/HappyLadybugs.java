import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class HappyLadybugs {
    static boolean canSwap;

    static boolean countMinTwo(HashMap<Character, Integer> countMap) {
        boolean minTwo = true;
        for(int num : countMap.values()) {
            if ( num == 1) return false;
        }
        return minTwo;
    }

    static void updateCount(HashMap<Character, Integer> countMap, char ch) {
        if (ch == '_')
            canSwap = true;
        else {
            if(countMap.containsKey(ch)) {
                int c = countMap.get(ch);
                countMap.put(ch, ++c);
            } else {
                countMap.put(ch, 1);
            }
        }
    }

    public static String happyLadybugs(String str) {
        canSwap = false;
        HashMap<Character, Integer> countMap = new HashMap<>();

        // base case
        if (str.length() == 1) {
            if (str.charAt(0) == '_')
                return "YES";
            else
                return "NO";
        }
        // RRBBYY
        // RBBYY
        boolean safe = true;
        boolean isAlone = false;
        char prev = '.';
        for (char ch : str.toCharArray()) {
            updateCount(countMap, ch);
            if (ch != prev) {
                if (safe) {
                    safe = false;
                    prev = ch;
                } else {
                    prev = ch;
                    isAlone = true;
                }
            } else {
                safe = true;
            }
        }

        if ( (safe && !isAlone) || (countMinTwo(countMap) && canSwap) )
            return "YES";
        else
            return "NO";
    }

    public static void main(String... arg) {
        String q = "AABCBC";
        System.out.println(happyLadybugs(q));
    }
}