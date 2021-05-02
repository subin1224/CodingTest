package subin;

public class ClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println("MAIN :::: " + minCostClimbingStairs(cost)); //return 15
    }

    public static int minCostClimbingStairs(int[] cost) {
        /*
        https://leetcode.com/problems/min-cost-climbing-stairs/
        DP 문제 #Easy
        시작은 idx 가 0 혹은 1
        건너 뛸 수 있음
        Return 마지막 혹은 마지막+1 까지 도달하는데에 필요한 최소 cost

        1)
        int[] dp = new int[cost.length+1];
        for(int i=2; i<dp.length; i++){
            int oneStep = dp[i-1] + cost[i-1];
            int twoStep = dp[i-2] + cost[i-2];
            dp[i] = Math.min(oneStep, twoStep);
        }
        return dp[dp.length-1];
        */

        //2)
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<cost.length; i++){
            dp[i] = Math.min(dp[i-2], dp[i-1]) + cost[i];
        }
        return Math.min(dp[cost.length-1], dp[cost.length-2]);

    }

    // Bottom up computation - O(n) time, O(1) space
    // Best Solution
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n<=2) return Math.min(first, second);
        for (int i=2; i<n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }
}