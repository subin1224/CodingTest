package subin;

public class Prg12954 {
	public long[] solution(int x, int n) {
		/*
		https://programmers.co.kr/learn/courses/30/lessons/12954
		*/
        long[] answer = new long[n];
        
        for(long i=0, t=x; i<n; i++, t+=x) {
        	answer[(int)i] = t;
        }
        
        //다른 문제 풀이
        answer[0] = x;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }
        
        return answer;
    }
}
