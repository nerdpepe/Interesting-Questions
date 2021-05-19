import java.util.Arrays;

public class MinimumMoves2Equal {

    static int leastCount(int[] arr, int start, int end) {
        int count = 0;

        for(int i = start; i<=end; i++) {
            int c = 0;
            for(int num : arr) {
                c += Math.abs(num - i);
            }
            if((i!=start && c<count) || i==start)
                count = c;
        }
        return count;
    }

    static int minMoves2(int[] nums) {
        int length = nums.length;
        int count = 0;
        int count_avg = 0;
        int count_oddArray_median = 0;
        int count_evenArray_median = 0;

        int odd_med_start, odd_med_end = 0;
        
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        int avg = sum/length;

        for(int n : nums)
            count_avg += Math.abs(avg - n);

        Arrays.sort(nums);

        if(length%2 != 0) {
            for(int n : nums) {
                count_oddArray_median += Math.abs(nums[length/2] - n);
            }

            if(count_avg < count_oddArray_median && count_avg>=0)
                count = count_avg;
            else
                count = count_oddArray_median;

        } else {
            odd_med_start = nums[length/2 - 1];
            odd_med_end = nums[length/2];
            
            count_evenArray_median = leastCount(nums, odd_med_start, odd_med_end);

            if(count_avg < count_evenArray_median && count_avg>=0)
                count = count_avg;
            else
                count = count_evenArray_median;
        }
            return count;

    }

    public static void main(String ...arg) {
        int[] nums = new int[]{203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143};
        int ans = minMoves2(nums);
        System.out.println(ans);    
    }
}
