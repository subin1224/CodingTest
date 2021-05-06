package subin;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        /*
        https://leetcode.com/problems/permutations/
        Medium
        Backtracking - 재귀함수 이용
        return nums배열 안에 있는 원소들의 위치 전환
        */
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(nums.length == 0) return list;
		
		permutation(nums, 0, new ArrayList<>(), list);
		return list;
    }
	
	private void permutation(int[] nums, int start, List<Integer> permute, List<List<Integer>> list) {
		if(permute.size() == nums.length) {
			list.add(permute);
			return;
		}
		
		for(int i=0; i<=permute.size(); i++) {
			List<Integer> newPermute = new ArrayList<>(permute);
			newPermute.add(i, nums[start]);
			permutation(nums, start+1, newPermute, list);
		}
	}
}
