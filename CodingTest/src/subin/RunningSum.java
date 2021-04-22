package subin;

public class RunningSum {
    public static void main(String[] args) {
        int[] n = {1,2,3,4};
        int[] answer = runningSum(n);
        System.out.println("::::MAIN:::::");
        for(int o : answer) System.out.print(o+" ");
    }
    public static int[] runningSum(int[] nums) {
        /*
        https://leetcode.com/problems/running-sum-of-1d-array/
        runningSum[i] = sum(nums[0]…nums[i])
        */
        /* 첫번째 방법 효율성 떨어짐 4ms
        int[] answer = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<=i; j++){
                answer[i]+=nums[j];
            }
        }

        return answer;
         */
        //두번째 방법 ..
        for(int i=1; i<nums.length; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}