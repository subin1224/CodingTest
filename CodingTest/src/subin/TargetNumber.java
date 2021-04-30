package subin;

public class TargetNumber {
	public static void main(String[] args) {
		int[] n = {1,1,1,1,1};
		int t = 3;
		System.out.println("::MAIN::" + solution(n, t)); //return 5
	}
	
	public static int solution(int[] numbers, int target) {
		/*
		Lv2. DFS/BFS 파트
		https://programmers.co.kr/learn/courses/30/lessons/43165
		사용할 수 있는 숫자가 담긴 배열 numbers, (2개이상 20개이하, 숫자는 1이상 50이하인 자연수)
		타겟 넘버 target (1이상 1000이하 자연수)
		return 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수
		
		DFS => 재귀함수 이용 - 모든 경우의 수 (더하고 빼고) 로 다 넣어서 구함. 만들어진 최종 값이 target과 일치한 경우 1 return.
		*/
		int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
	
	public static int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        //n이 numbers.length 에 도달할때 까지 반복
        //sum + numbers[n] : 다음 숫자가 양수 인 경우, 음수 인 경우 반복
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
