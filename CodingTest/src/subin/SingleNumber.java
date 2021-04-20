package subin;

import java.util.Arrays;

public class SingleNumber {
	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		System.out.println("MAIN ::" + singleNumber(nums)); //1
	}
	public static int singleNumber(int[] nums) { //2번째 방법 5ms
		Arrays.sort(nums);
		
		if(nums.length==1 || nums[0]!=nums[1]) {
			return nums[0];
		}
		
		for(int i=0; i<nums.length-2;i+=2) {
			if(nums[i]!=nums[i+1]) {
				return nums[i];
			}
		}
		
	
		return nums[nums.length-1];
	}
	
	
	
	/* 1번째방법 - 10ms
	public static int singleNumber(int[] nums) {
        
        https://leetcode.com/problems/single-number/
        
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		
		System.out.println(map);
		
		int answer=0;
		for(int i=0; i<nums.length; i++) {
			if(map.get(nums[i])==1) answer=nums[i];
		}
		
		return answer;
    }
    */
}
