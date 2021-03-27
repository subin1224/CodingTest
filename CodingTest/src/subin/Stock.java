package subin;

import java.util.Stack;

public class Stock {
    public static void main(String[] args) {
        int[] prices = {6, 4, 6, 3, 10, 11, 12, 13, 6, 8, 5};
        System.out.println(" ---------- 완료 ------------ ");
        solution(prices);
    }

    public static int[] solution(int[] prices) {
        /*
        https://programmers.co.kr/learn/courses/30/lessons/42584?language=java#
        prices 가 1 2 3 2 3 이면
        answer 는 4 3 1 1 0
        Stack 클래스 이용
        */

        //prices[i] 보다 낮은게 있으면 해당 index에서 i 빼기
        //없으면 length 에서 해당 i+1 빼기
        //prices[i] 보다 낮은게 있다는것을 어떻게 표현할까 ....
        /*
        public Element push(Element item); // 데이터 추가
        public Element pop(); // 최근에 추가된(Top) 데이터 삭제
        public Element peek(); // 최근에 추가된(Top) 데이터 조회
        public boolean empty(); // stack의 값이 비었는지 확인, 비었으면 true, 아니면 false
        public int seach(Object o); // 인자값으로 받은 데이터의 위치 반환, 그림으로 설명하겠음
        */
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        //1. stack에 저장
        for(int i=0; i<prices.length;i++){
            //stack 이 비어있지 않을때까지 그리고, i번째 값이 stack에 나중에 넣은 값 보다 클때까지 pop이 돌아감
            while(!stack.isEmpty() && (prices[i] < prices[stack.peek()])){ //즉 값이 떨어진다면
                System.out.println(i+" 번 stack.peek ::: " + stack.peek());
                answer[stack.peek()] = i - stack.peek(); //answer 의 나중에 넣은 값 idx
                stack.pop(); //답을 구했기 때문에 제거
            }
            stack.push(i);
            System.out.println(i+"번째 stack ::: " + stack);
        }

        while(!stack.isEmpty()){ //끝까지 떨어지지않는 주식가격들
            answer[stack.peek()]=prices.length - stack.peek() - 1;
            stack.pop();
        }

        System.out.println("answer 출력");
        for(int n : answer){
            System.out.print(n + " ");
        }
        return answer;
    }

}
