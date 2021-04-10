package subin;

import java.util.Stack;

public class Printer {
    public static void main(String[] args) {
        //int[] p= {2, 1, 3, 2}; //A B C D => C D B A
        int[] p = {1, 1, 9, 1, 1, 1};
        //int l= 2; //return 1 l=2 > C 를 뜻함 C는 몇번쨰에 나오는지 1번째로 나옴
        int l=0; //return 5
        System.out.println("Main ::::: " + solution(p,l));
    }

    public static int solution(int[] priorities, int location) {
      /*
      https://programmers.co.kr/learn/courses/30/lessons/42587
      1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
      2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
      3. 그렇지 않으면 J를 인쇄합니다.

      중요도 숫자가 높을수록 먼저 출력 => 중요도 숫자가 같다면 먼저 대기한게 출력
      location = 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지. ( 가령 A B C D 라면, 3 이면 C문서는 몇번째 출력하는지 )
      return 몇 번째로 인쇄 되는지
      location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.

      1) 우선순위 큐를 이용 = PriorityQueue .. (숫자가 낮을수록 더 높은거임)
      2) 아니면 그냥 큐 이용
      */
        int answer=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=0; i<priorities.length; i++){
            for(int j=0; j<i; j++){
                if(priorities[i] < priorities[j]){ // 1 2
                    System.out.println("p[i]=" + priorities[i] + ", p[j]=" + priorities[j]);
                    stack.pop();
                    System.out.println(i + ", " + j + " stack.pop = " + stack);
                    stack.push(i);
                    System.out.println(i + ", " + j + " stack.push j = " + stack);
                    stack.push(j);
                    System.out.println(i + ", " + j + " stack.push i = " + stack);
                    System.out.println(i + ", " + j + " stack.peek = " + stack.peek());
                }else{
                    if(j==i-1){
                        stack.push(i);
                        System.out.println("else 문의 "+i + ", " + j + " stack.push i = " + stack);
                    }
                }
            }
        } //for

        System.out.println(stack);
        while(!stack.isEmpty()){
            if(stack.pop()!=location){
                answer++;
            }else{
                break;
            }
        }
        return answer+1;
    }
}