// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

public class AllBallsToEachBox_FASTER {
    static int[] minOperations(String boxes) {
        int boxesLen = boxes.length();
        int[] ansArr = new int[boxesLen];

        /*We move twice.
          First from left to right
          then right to left

          Hence two for-loops
        */
        int boxesCount = 0;
        int prev = 0;

        for(int i = 0; i<boxesLen; i++){
            int curResult = boxesCount + prev;
            ansArr[i] = curResult;
            prev = curResult;

            if(boxes.charAt(i) == '1')
                boxesCount++;
        }
        boxesCount = 0;
        prev = 0;

        for(int i = boxesLen-1; i>=0; i--){
            int curResult = boxesCount + prev;
            ansArr[i] += curResult;
            prev = curResult;

            if(boxes.charAt(i) == '1')
                boxesCount++;
        }

        return ansArr;
    }

    public static void main(String ...arStrings) {
        String boxes = "10111";
        int[] ans = minOperations(boxes);
        for(int n : ans)
         System.out.print(n);
    }
}