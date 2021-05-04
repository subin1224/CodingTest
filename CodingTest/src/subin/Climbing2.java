package subin;

public class Climbing2 {
	public int climbStairs(int n) {
        /*
        https://leetcode.com/problems/climbing-stairs/
        DP _ EASY
        n을 1 or 2 step
        return ways
        1 <= n <= 45
        
        n = 4
        1 1 1 1
        2 1 1 / 1 2 1 / 1 1 2
        2 2
        */		
		if(n<=2) return n;
		
		int[] stairs = new int[n+1];
		stairs[0]=1;
		stairs[1]=1;
		
		for(int i=2; i<n+1; i++) {
			stairs[i] = stairs[i-1] + stairs[i-2];
		}
		
		return stairs[n];
    }
}
