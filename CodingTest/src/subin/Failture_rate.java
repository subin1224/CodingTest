package subin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Failture_rate {
    public static void main(String[] args) {
        int n = 5;
        int[] s = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] ma = solution(n, s);
    }

    public static int[] solution(int N, int[] stages) {
        /*
        https://programmers.co.kr/learn/courses/30/lessons/42889
        실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
        return 실패율이 높은 스테이지 부터 내림차순으로 스테이지의 번호가 담겨있는 배열

        스테이지의 개수 N은 1이상 500이하
        stages 배열 내에 있는 N+1 은 마지막 스테이지 까지 클리어한 사용자를 뜻함
        실패율이 같은 스테이지가 있다면 작은번호의 스테이지가 먼저 오도록
        스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0으로 정의
        
        문제를 읽어보면 알 수 있듯이 이 문제는 정렬을 이용해서 풀 수 있습니다.

        먼저 주어진 배열의 길이를 이용하여 전체 사용자 수를 구하고, stages 를 순회하며 각 스테이지에 몇 명의 사용자가 도달했는지 세줍니다.
         이렇게 만들어둔 배열(각 스테이지별 사용자 수가 들어있는)을 순회하면서 stages 를 참고하여 스테이지별 실패율을 계산합니다. 
        이때, 스테이지에 도달한 사용자가 0명인 경우 예외 처리를 해야 합니다. 
        스테이지별 실패율을 구했다면, 각 스테이지 번호와 묶어서 실패율 내림차순으로 정렬합니다. 
        실패율이 같은 경우는 스테이지 번호가 작은 것을 먼저 오도록 정렬하면 됩니다.
        */
        int[] answer = new int[N];

        int people = stages.length; //사용자

        float[] cnt = new float[N]; //스테이지에 도달한 사람

        for(int x=0; x<N; x++){ //스테이지
            for(int i=0; i<stages.length; i++){
                if(x+1 < stages[i]){ //스테이지에 도달한 사람
                    cnt[x]++;
                }
            }
        }

        for(float f : cnt){
            System.out.print(f + " ");
        }

        return answer;

    }
}