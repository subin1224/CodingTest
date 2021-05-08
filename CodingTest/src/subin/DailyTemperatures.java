package subin;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        /*
        https://leetcode.com/problems/daily-temperatures/
        Medium 문제 ..
        각 날짜에 대해 더 따뜻한 온도까지 기다려야하는 날 수를 알려주는 목록을 반환
        가능한 날이 없다면 0을 리턴
        */

        //1) 내가 푼 방법 - 시간을 많이 잡아먹음 ㅠ,ㅠ 이중 for문이라 ....
        int[] day = new int[T.length];

        for(int i=0; i<T.length-1; i++){
            for(int j=i; j<T.length; j++){
                if(T[j]>T[i]){
                    day[i] = (j-i);
                    break;
                }
            }
        }

        day[T.length-1] = 0;

        return day;
    }

    //2) Stack을 이용한 풀이
    public int[] stackSolution(int[] T){
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[T.length];
        for(int i=0; i<T.length; i++){
            while(stack.isEmpty() && T[i] > T[stack.peek()]){
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }

        return ret;
    }
}
