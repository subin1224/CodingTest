package subin;

public class CountingBits {
	public int[] countBits(int num) {
        /*
        https://leetcode.com/problems/counting-bits/
        DP - Medium 문제
        0 ~ 주어진 num 숫자를 이진법으로 나타내고,
        1이 각각 얼마나 쓰이는지의 배열 return
        */
		int[] arr = new int[num+1];
		arr[0]=0;
		
		//1) 기존에 푼 방법
		for(int i=1; i<num+1; i++) {
			arr[i] = arr[i/2];
			if(i%2==1) arr[i]++;
		}
		
		
		//2) for문안에 i, j 둘 다 쓰는것
		int n =1;
		for(int i=1, j=0; i<num+1; i++, j++) {
			if(i==n) {
				n*=2;
				j=0;
			}
			arr[i] = arr[j]+1;
		}
		
		return arr;
    }
	
}
