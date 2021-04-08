package subin;

import java.util.Stack;

public class Progresses {
	public static void main(String[] args) {
		//int[] p= {95, 90, 99, 99, 80, 99};
		int[] p = {99, 99, 99};
		//int[] s= {1, 1, 1, 1, 1, 1};
		int[] s = {1, 1, 1};
		int[] answer = solution(p,s);
		System.out.println(":: MAIN :: ANSWER :: ");
		for(int n : answer) System.out.print(n + " ");
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		/*
		https://programmers.co.kr/learn/courses/30/lessons/42586
		앞에 기능이 먼저 완성 되어야 다른 기능들도 배포가 가능함
		Stack 이용
		
		다른사람 코드
		
		int[] answer;

        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : dayOfend) {
            if(i!=0) {list.add(i);}
        }

        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
		
		*/
		Stack<Integer> q = new Stack<Integer>();
		
		int[] time = new int[progresses.length]; //100%가 되는 일수의 배열
		
		for(int i=0; i<progresses.length; i++) {
			if((100-progresses[i])%speeds[i]!=0) {
				time[i]=((100-progresses[i])/speeds[i])+1;
			}else {
				time[i]=((100-progresses[i])/speeds[i]);
			}
		}
		
		for(int i=0; i<time.length; i++) { // 5, 10, 1, 1, 20, 1
			if(!q.isEmpty()) {
				if(q.peek()>=time[i]) {
					time[i]=q.peek(); // 5 10 10 10 20 20
				}else {
					q.push(time[i]); // 5 10 10 10 20
				}
			}else {
				q.push(time[i]);
			}
		}
		System.out.println(q);
		int[] answer = new int[q.size()];
		
		for(int i=q.size()-1; i>=0; i--) {
			int count=0;
			for(int z=time.length-1; z>=0; z--) {
				if(time[z]==q.peek()) {
					count++;
				}
			} //안쪽 for
			q.pop();
			answer[i]=count;
		}
		
        return answer;
    }
}
