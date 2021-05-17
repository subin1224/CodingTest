package subin;

public class Make_PrimeNumber {
	public int solution(int[] nums) {
		/*
		https://programmers.co.kr/learn/courses/30/lessons/12977
		return 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수
		중복된 숫자 X
		*/
        int answer = 0;
        
        for(int i=0; i<nums.length-2; i++) {
        	for(int j=i+1; j<nums.length-1; j++) {
        		for(int h=j+1; h<nums.length; h++) {
        			int n = nums[i]+nums[j]+nums[h];
        			if(isPrime(n)) answer ++;
        		}
        	}
        }

        return answer;
    }
	
	//소수인지 판별하는 메서드
	public boolean isPrime(int n) {
		if(n<2) return false;
		if(n==2) return true;
		
		for(int i=2; i<n; i++) {
			if(n%i==0) return false;
		}
		
		return true;
	}
	
	//백트래킹 (다른사람 풀이)
	public int result = 0;
	public int solution2(int[] nums) {
		int answer=0;
		int n = nums.length;
		int r = 3; 	//3개의 수를 뽑음
		
		int[] arr = new int[n];
		combination(arr, 0, n, r, 0, nums);	//처음 index, target은 0부터 시작
		answer = result;
		
		return answer;
	}
	
	
	public void combination(int[] arr, int index, int n, int r, int target, int[] nums) {
		if(r ==0) print(arr, index);
		else if (target == n) return;
		else {
			arr[index] = nums[target];
			combination(arr, index+1, n, r-1, target+1, nums);
			combination(arr, index, n, r, target+1, nums);
		}
	}
	
	//재귀함수 를 사용한다면
	public int combination2(int n, int r) {
		if(n==r || r==0) return 1;
		else return combination2(n-1, r-1) + combination2(n-1, r);
	}
	
	
	public void print(int[] arr, int length) {
		int cnt=0;
		boolean isPrime = false;
		for(int i=0; i<length; i++) {
			cnt += arr[i];
		}
		
		for(int i=2; i<cnt; i++) {
			if(cnt%i==0) {
				isPrime = true; 
				break;				
			} 
		}
		
		if(!isPrime) result++;
	}
	
}
