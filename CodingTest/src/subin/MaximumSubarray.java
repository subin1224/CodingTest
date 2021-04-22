package subin;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] n = {5,4,-1,7,8};
        System.out.println("MAIN :::: " + maxSubArray(n)); //23
    }

    public static int maxSubArray(int[] A) {
        /*
        다시한번 봐야함 : DP 문제
        https://leetcode.com/problems/maximum-subarray/
        contiguous subarray
        적어도 숫자 하나 포함, 연속된 배열이여야 함 => 가장 큰 수 return
        */
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
