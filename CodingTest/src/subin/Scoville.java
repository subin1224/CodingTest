package subin;

import java.util.PriorityQueue;
import java.util.Queue;

public class Scoville {

	public static void main(String[] args) {
		int[] sc= {1, 1, 1};
		System.out.println("Main ::: " + solution(sc, 7));
	}
	
	public static int solution(int[] scoville, int K) {
		/*
		https://programmers.co.kr/learn/courses/30/lessons/42626
		모든 음식의 스코빌 지수를 K 이상
		스코빌 지수 = 가장 맵지않은 음직의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2 )
		모든 음식의 스코빌 지수가 K이상이 될때까지 반복하여 섞음
		이떄의 최소 횟수 return. 만약 모든 음식의 스코빌 지수를 K이상으로 만들 수 없는 경우에는 -1 리턴
		만약 k=5, 배열은 1 5 6 7 이면 1 + 5*2 = 11 => 11 6 7 , return 1
		1 11 6 7
		
		K=12 , 배열이 1 2 3 9 10 12 라면
		1 / 5 3 9 10 12 //i=0 
		1 5 /13 9 10 12 //i=1
		i=2 pass
		1 5 13 9 29 12 // i=3
		i=4 pass i=5 pass
		*/		
		int answer=0; //섞은 값		
		Queue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int n : scoville) pq.offer(n); 
		
		System.out.println("while 전 pq = " + pq);
		
		while(true) { //모든 음식의 지수가 K이상일때까지 돌린다
			int a=pq.poll();
			int b=pq.poll();
			pq.offer(shake(a, b));
			answer++;
			
			if(pq.peek()>K) break;
			if(pq.size()==1) return -1;
		}
		
		System.out.println(pq);
		System.out.println(answer);
        return answer;
    }
	
	public static int shake(int a, int b) {
		return a + (b*2);			
	}

}
