package subin;

public class MoveZeroes {
	public static void main(String[] args) {
		int[] nums= {0,1,0,3,12};
		moveZeroes(nums);
		System.out.println("::MAIN::");
		for(int n : nums) {
			System.out.print(n+" ");
		}
	}
	
	public static void moveZeroes(int[] nums) {
        /*
        https://leetcode.com/problems/move-zeroes/ 
        copy Array 안쓰고 
        */
		int idx=0;
		for(int i=0; i<nums.length;i++) {
			if(nums[i]!=0) {
				nums[idx]=nums[i];
				idx++;
			}
		}
		System.out.println(idx);
		for(int i=idx; i<nums.length; i++) {
			nums[i]=0;
		}
    }
}
