package subin;

public class GymClothes {
	public static void main(String[] args) {
		int n = 5;
		int[] l = {2,3,4};
		int[] r = {1,2,3};
		System.out.println("MAIN ::: " + solution(n,l,r)); //return 4
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
		/*
		
		Greedy (탐욕법) 알고리즘 - Lv1
		https://programmers.co.kr/learn/courses/30/lessons/42862
		체육복은 바로 앞번호나 바로 뒷번호 학생에게만 빌려 줄 수 있음
		전체 학생 수 n
		도난 당한 학생들의 번호가 담긴 배열 lost
		여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve
		return 체육복을 입을 수 있는 학생의 최댓값
		2 <= n <= 30
		1<=lost.length<=n 중복 번호 X
		1<=reserve.length<=n 중복 번호 X
		여벌이 있는 학생만 다른 학생에게 체육복을 빌려 줄 수 있음
		++) 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 
		남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
		*/
		int answer = n - lost.length; //참여 가능한 학생 수
		int cnt=0; //빌리거나 여분이 있는 학생
		
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length; j++) {
				if(lost[i]==reserve[j]) {
					cnt++;
					lost[i]=-1;
					reserve[j]=-1;
					break;
				}
			}
		}
				
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length; j++) {
				if(lost[i]==reserve[j]+1 || lost[i]==reserve[j]-1) {
					cnt++;
					reserve[j]=-1;
					break;
				}
			}
		}
		
		answer += cnt;
		
		return answer;
    }
	
	//다른 solution
	public int solution2(int n, int[] lost, int[] reserve) {
		//혹은 처음부터 배열 크기를 n+2로 선언하면 추가 조건 비교를 하지 않아도 됨.
		//체육복 없는 사람 기준으로 생각
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve) 
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }
}
