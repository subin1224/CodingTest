package subin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {
	class Job{
		int startTime;
	    int requiredTime;

	    public Job (int startTime, int requiredTime) {
	    	this.startTime = startTime;
	    	this.requiredTime = requiredTime;
	    }
	}
	
	public int solution(int[][] jobs) {
		/*
		https://programmers.co.kr/learn/courses/30/lessons/42627
		jobs의 길이는 1이상 500이하
		작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마나 되는지
		소수점 이하의 수는 버림.
		[작업이 요청되는 시점, 작업의 소요 시간]
		한번에 하나의 작업만 수행. 해당 작업이 끝나야 다음 작업 수행
		작업 요청시간이 겹친다면 작업 소요 시간이 가장 긴것을 마지막에 작업.
		
		이차원 배열의 정렬
		Arrays.sort(jobs, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if(o1[0]==o2[0]) {
						return o1[1] - o2[1];
					}else {
						return o1[0] - o2[0];
					}
				}
		});
		*/
		int answer = 0;
		
		//배열 정렬 - 요청 시간이 길다면 수행 시간이 짧은 것 부터 먼저 수행 하도록
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) { //만약 요청시간이 같은 경우에는
					return o1[1] - o2[1]; //작업 처리 시간이 짧은 순 먼저
				}else { //그렇지 않은 경우에는
					return o1[0] - o2[0]; //요청 시간이 빠른 순서대로 정렬
				}
			}
		});
		
		//Job의 내부 인자인 requiredTime이 오름차순으로 정렬하도록. 람다식  함수 적용
		PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> a.requiredTime - b.requiredTime);
		
		int cnt = jobs[0][0] + jobs[0][1]; //현재 시간 선언, 처음 호출된 작업의 시간 + 그 작업이 걸리는 시간 = 처음 호출된 작업이 끝나는 시간
		int idx = 1; //Index
		int complete = 1; // 완료된 작업의 갯수
		answer = cnt - jobs[0][0]; //answer :: 현재시간 - 처음 작업이 불린 시간
		
		while(complete != jobs.length) {
			//PQ에 수행 목록을 채우는 작업, PQ에 채워져 있는 수행 목록을 실행하는 작업 실시
			for(int i=idx; i<jobs.length; i++) {
				if(cnt>=jobs[i][0]) {
					//작업 목록 중 작업의 시작 시간이 현재 시간보다 길다면.. = 바로 실행 할 수 있다면
					pq.add(new Job(jobs[i][0], jobs[i][1])); //우선순위 큐에 작업 객체를 생성하여 넣는다.
					if( i == jobs.length-1) idx = jobs.length;
				}else {
					//바로 실행 할 수 없다면 해당 인덱스에서 멈춘다
					idx=i;
					break;
				}
			}
			
			//만약 pq가 비어있지 않다면 하나를 실행
			if(pq.isEmpty()) {
				Job out = pq.poll();
				cnt += out.requiredTime;
				answer += cnt - out.startTime;
				complete++;
			}else {
				//바로 실행 할 작업 목록이 없다면, 현재 시간을 다음 시작할 작업의 시작 시간으로 옮기고 루프 하나 종료
				cnt = jobs[idx][0];
			}
		} //while
		
		answer = answer / jobs.length;
		
		return answer;
    }
	
}
