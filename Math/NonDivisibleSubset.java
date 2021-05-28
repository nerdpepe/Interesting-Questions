import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class NonDivisibleSubset {

    static int nonDivisibleSubset(int k, List<Integer> list) {
        
        if(k == 0)
            return 1;

        int maxSubset = 0;
        HashSet<Integer> set = new HashSet<>();
        int[] remArr = new int[k];

        for(int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if(set.add(num)) {
                int rem = num % k;
                remArr[rem]++;
            }
        }


        if(remArr[0] > 1)
            maxSubset = 1;
        
        for(int i = 1; i <= (k/2); i++) {
            if(i == k - i)
                maxSubset++;
            else {
                maxSubset += Math.max(remArr[i], remArr[k-i]);
            }
        }

        return maxSubset;
    
    }

    public static void main(String ...arg) {
        int k = 3;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(4);
        int n = nonDivisibleSubset(k, list);
        System.out.print(n);
    }
}