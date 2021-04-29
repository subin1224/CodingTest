package subin;

import java.util.Arrays;

public class LifeBoat {

	public static void main(String[] args) {
		int[] p = {70, 50, 80, 50};
		int l = 100;
		System.out.println(":::: MAIN ::::" + solution(p,l));
	}
	
	public static int solution(int[] people, int limit) {
		/*
		Greedy Lv.2
		https://programmers.co.kr/learn/courses/30/lessons/42885
		- return 모든 사람을 구출하기 위해 필요한 구명보트의 개수의 최솟값
		한번에 최대 2명밖에 못태움
		몸무게, limit 은 40kg이상 240kg이하.
		무게 제한은 항상 사람의 몸무게 중 최댓값 보다 크게 주어지므로 사람 구출할 수 없는 경우는 없음
		
		-> 무게 최솟값을 가진 사람과 최댓값을 가진 사람. 몇번째까지 같이 탈 수 있는지 찾아내고 최솟값을 가진 사람 태웠으면
		그 다음 최솟값을 가진 사람과 ... 반복 
		*/
        int answer = 0;
        
        //오름차순 정렬
        Arrays.sort(people);
        
        //idx 설정
        int right = people.length-1;
        int left = 0;
        
        while(right>=left) {
        	int weight = people[right--];
        	if(weight + people[left] <= limit) {
        		left++;
        	}
        	answer++;
        }
        
        return answer;
    }
}
