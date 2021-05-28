import java.util.HashMap;

// https://leetcode.com/problems/maximum-erasure-value/
public class MaxErasureValue {
    static int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        int start = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1); 
            }
            else {
                int count = map.get(nums[i]);
                map.put(nums[i], ++count);
            }
            sum += nums[i];
            while(map.get(nums[i]) > 1) {
                int c = map.get(nums[start]);
                map.put(nums[start], --c);
                sum -= nums[start];
                start++;
            }
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }

    public static void main(String... arg) {
        int[] nums = new int[] {187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434};
       // int[] nums = new int[] {4,2,4,5,6};
        int ans = maximumUniqueSubarray(nums);
        System.out.print(ans);
    }
}