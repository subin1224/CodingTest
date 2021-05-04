package subin;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] n = {5,4,-1,7,8};
        System.out.println("MAIN :::: " + maxSubArray(n)); //23
    }

    public static int maxSubArray(int[] nums) {
        /*
        DP 문제 - EASY
        https://leetcode.com/problems/maximum-subarray/
        contiguous subarray
        적어도 숫자 하나 포함, 연속된 배열이여야 함 => 가장 큰 수 return
        */
    	int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with dp[i];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
