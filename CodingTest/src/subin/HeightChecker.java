package subin;

import java.util.Arrays;

public class HeightChecker {
	public static void main(String[] args) {
		int[] h = {1,1,4,2,1,3};
		System.out.println(":::::MAIN::::"+heightChecker(h));
	}
	
	public static int heightChecker(int[] heights) {
        /*
        https://leetcode.com/problems/height-checker/
        Input: heights = [1,1,4,2,1,3]
		Output: 3
		Explanation: 
		heights:  [1,1,4,2,1,3]
		expected: [1,1,1,2,3,4]
		Indices 2, 4, and 5 do not match.
        */
		int[] expected = Arrays.copyOf(heights, heights.length); //혹은 for문 돌려서 expected[i] = heights[i]
		Arrays.sort(heights);
		int answer=0;
		for(int i=0; i<heights.length; i++) {
			if(heights[i]!=expected[i]) answer++;
		}
		return answer;
    }
}
