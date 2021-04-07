package subin;

import java.util.LinkedList;
import java.util.Queue;

public class Bridge {
	   public static void main(String[] args) {
	        int len = 2;
	        int weight = 10;
	        int[] truck = {7,4,5,6};
	        int answer = solution(len, weight, truck);
	        System.out.println(":::MAIN::::" + answer);
	    }
	    public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        /*
	        https://programmers.co.kr/learn/courses/30/lessons/42583
	        return 모든 트럭이 다리를 건너기 위한 최소 사간
	        1초에 길이가 1씩 트럭이 움직이며 다리에 있는 트럭들은 weight 을 넘으면 안됨
	        먼저 들어간 자료가 먼저 나오는 구조인 FIFO 형식 => Queue 로 풀자
	        */
	        int answer = 0; //경과 시간
	        Queue<Integer> qu = new LinkedList<Integer>();
	        int sum=0; //다리에 있는 트럭의 무게 합
	        
	        /*
	        for문으로 안되니까 무한루프로 돌려보자
	        */
	        
	        
	        for(int i=0; i< truck_weights.length; i++){
	            sum+=truck_weights[i];
	            qu.offer(truck_weights[i]);
	            
	            System.out.println(i+"번째 if 들어가기 전 qu = " + qu);
	            
	            if(qu.size()>bridge_length) {
	            	sum-=qu.poll();
	            	if(sum>weight) {
	            		sum-=qu.poll();
	            		answer+=(bridge_length-qu.size()+1);
	            	}else {
	            		answer++;
	            	}
	            }else {
	            	if(sum>weight) {
	            		sum-=qu.poll();
	            		answer+=bridge_length;
	            	}else {
	            		answer++;
	            	}
	            }
	            
	            System.out.println(i+"번째 sum :: " + sum);
	            System.out.println(i+"번째 경과시간 :: " + answer);
	          
	        }
        	if(sum>weight) {
        		sum-=qu.poll();
        		answer+=(bridge_length-qu.size()+1);
        	}
        	
	        //answer+=bridge_length;

	        return answer;
	    }
	}