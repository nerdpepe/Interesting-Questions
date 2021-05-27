import java.util.ArrayList;
import java.util.List;

public class MaxWordLengthProduct {

        public int maxProduct(String[] words) {
            int n = words.length;
            int[] charsContained = new int[n];
            for (int i = 0 ; i < n ; i++) {
                int[] pos = new int[26];
                for (char ch : words[i].toCharArray())
                    pos[ch - 'a'] = 1;
                
                int bitmask = 0;
                for (int j = 25 ; j >= 0 ; j--) {
                    bitmask <<= 1;
                    if (pos[j] == 1)
                        bitmask |= 1;
                }
                charsContained[i] = bitmask;
            }
            
            int maxProd = 0;
            for (int i = 0 ; i < words.length ; i++) {
                for (int j = i + 1 ; j < words.length ; j++) {
                    if ((charsContained[i] & charsContained[j]) == 0)
                        maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
    
            return maxProd;
        }

    public static void main(String... arg) {
        int ans;
        String[] words = new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
        ans = maxProduct(words);
        System.out.print("Output: -" + ans);
    }
}