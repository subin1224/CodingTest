package subin;

import java.util.Stack;

public class OneTwoFour {
    public static void main(String[] args) {
        int n = 513;
        System.out.println("MAIM :::: " + solution(n));
    }
    public static String solution(int n) {
        /*
        https://programmers.co.kr/learn/courses/30/lessons/12899
        Lv2 .. return 124의 나라 언어
        10 = 41
        11 = 42
        12 = 44
        13 = 111
        */
        String answer = "";
        Stack<Integer> stack = new Stack<>();

        while(n>3){
            int temp = n%3;
            if(temp==0){
                stack.push(3);
                n = n/3 -1;
            }else{
                stack.push(n%3);
                n /= 3;
            }
        }
        stack.push(n);

        while(!stack.isEmpty()){
            switch (stack.pop()){
                case 0: answer+="4"; break;
                case 1: answer+="1"; break;
                case 2: answer+="2"; break;
                case 3: answer+="4"; break;
            }
        }

        return answer;
    }

    //다른사람 풀이 방법
    public String solution2(int n) {
        String[] num = {"4","1","2"};
        String answer = "";

        while(n > 0){
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
            /*
            n-1 모르는 사람을 위해 설명하자면, 1,2,4 숫자 체계에서 3씩 나누면 한 칸씩 당겨집니다.
            다만 문제가 생기죠. 이에 대해 설명 하면, 1, 2, 4를 1, 2, 3이라고 칩시다.
            133일경우 한 칸씩 당기면 13.3이 되는데 이때 0.1은 10진수로 1/3이됩니다.
            그래서 13.3의 0.3이 1이되어서 몫에 영향을 주게 됩니다.
            그래서 나누기전에 -1을 해주면 소수점 값이 0.3일때 몫에 영향을 줄일 이 없게 됩니다.
            그리고 111을 당길경우 1을빼면 33이되고 이를 3으로 나누어서 당겨주면 3.3이되는데
            0.3은 1이되므로 3 + 1해서 11이되어서 정상적으로 당겨지게 됩니다.
            당기면서 3모듈러연산하면 1의자리수 알 수있으니 계속 당기면서 1의자리 추출해준겁니다 .
            */
        }
        return answer;
    }
}