package subin;

public class Carpet {
	public static void main(String[] args) {
		int b = 8;
		int y = 1;
		int[] result = solution(b, y);
		for(int n : result)System.out.print(n + " ");
	}
	public static int[] solution(int brown, int yellow) {
		/*
		https://programmers.co.kr/learn/courses/30/lessons/42842
		완전탐색
		return 가로 세로 크기 순서대로 int[] 배열
		
		answer[0]*answer[1] = brown + yellow
		(answer[0] - 2) * (answer[1] - 2 ) = yellow
		
		a[0] * a[1] = brown + (a[0]-2) * (a[1]-2)
		b + ( -2a[0] -2a[1] ) + 4 = 0
		b + 4 = 2a[0] + 2a[1]
		
		b = 2(a[0]+a[1]) - 4
		*/
        int a = (brown+4)/2;
        int b = yellow+2*a-4;
        //Math.sqrt = 제곱근
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2, (int)(a-Math.sqrt(a*a-4*b))/2};
        
        return answer;
    }
}
