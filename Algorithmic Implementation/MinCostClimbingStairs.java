public class MinCostClimbingStairs {

    static int minCostClimbingStairs(int[] cost) {

        int[] totalcost = new int[cost.length];
        totalcost[0] = cost[0];
        totalcost[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            totalcost[i] = cost[i] + Math.min(totalcost[i - 1], totalcost[i - 2]);
        }

        return Math.min(totalcost[cost.length - 1], totalcost[cost.length - 2]);
    }

    public static void main(String... args) {
        int[] cost = new int[] {1,100,1,1,1,100,1,1,100,1 };
        System.out.print(minCostClimbingStairs(cost));
    }
}