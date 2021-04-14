package subin;

import java.util.*;

public class HIndex {
    public static void main(String[] args) {
        int[] c={3, 0, 6, 1, 5}; //return 3
        System.out.println("::MAIN::" + solution(c));
    }

    public static int solution(int[] citations) {
        /*
        https://programmers.co.kr/learn/courses/30/lessons/42747
        1 <= citations.length = n <= 1000
        h번이상 인용된 논문이 h편 이상이고
        나머지 논문이 h번 이하 인용 되었다면
        h의 최댓값 return
        0 <= h <= 10000
        TestCase
        [12, 11, 10, 9, 8, 1] 5
        [6, 6, 6, 6, 6, 1] 5
        [4, 4, 4] 3
        [4, 4, 4, 5, 0, 1, 2, 3] 4
        [10, 11, 12, 13] 4
        [3, 0, 6, 1, 5] 3
        [0, 0, 1, 1] 1
        [0, 1] 1
        [10, 9, 4, 1, 1] 3
        */
        Arrays.sort(citations);

        for(int n : citations) System.out.print(n + " ");
        System.out.println();
        int answer=0;
        //원소 값은 점점 감소하고, 원소 값 이상인 것의 개수는 점점 감소, 이 두 값의 최소값의 변화가 증가하다가 감소하는 지점을 찾으면... 그것이 답이 된다
        for(int i= citations.length-1; i>=0; i--){
            int min = (int)Math.min(citations[i], citations.length-i);
            if(min > answer) answer=min;
            System.out.println(i+"번째의 min="+min);
            System.out.println(i+"번째의 citiations[i]="+citations[i]);
            System.out.println("citations.length-i="+(citations.length-i));
        }

        return answer;
    }
}