package subin;

import java.util.ArrayList;
import java.util.List;

public class FindNumber {
	public static void main(String[] args) {
		int[] nums= {4,3,2,7,8,2,3,1};
		findDisappearedNumbers(nums);
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        /*
        https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
        Array - Easy
        n == nums.length
        return 1 ~ n 까지 숫자 중 nums에 없는 정수 List
        */
		
		int n = nums.length;
		List<Integer> list = new ArrayList<Integer>();
		int count[] = new int[n+1];
		
		//0~n까지 숫자 중 nums에 있으면 최소 1.. 없으면 0이 들어가짐
		for(int i : nums) count[i]++;
		
		//@디버깅
		for(int z : count) System.out.print(z + " ");
		
		//0이라면 1~n까지의 숫자 중 nums에 없는거니까 그 숫자만 list에 추가한다.
		for(int i=1; i<n+1; i++) {
			if(count[i]==0) list.add(i);
		}
		return list;
    }
}
