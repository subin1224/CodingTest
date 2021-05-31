package subin;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        /*
        https://leetcode.com/problems/two-sum/
        두개의 수를 합쳐서 target이 되면 해당 index 반환
        */
		int a=0 , b=0;
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					a=i; b=j;
				}
			}
		}
		return new int[] {a, b};
    }
	
	//sol1 => 이렇게 생각했는데 IllegalArgumentException 생각 못함 아니면 그냥 return new int[]{};해도 되었을듯?
    public int[] twoSum1(int[] nums, int target) {
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
    }
    
	//sol2 => 1ms 맵을 이용하여 풀이, for문 1번만 돌려서 시간 단축!
	public int[] twoSum2(int[] nums, int target) {
		int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        if (map.containsKey(target - nums[i])) {
	            result[1] = i;
	            result[0] = map.get(target - nums[i]);
	            return result;
	        }
	        map.put(nums[i], i); // put 했으니까 그 후 i에서는 containsKey 찾을 수 있음!
	    }
	    return result;
    }
}
