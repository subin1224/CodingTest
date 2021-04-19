package subin;

import java.util.ArrayList;

public class MathExam {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5}; //return 1
        int[] sol = solution(answers);
        System.out.println("::MAIN::");
        for(int n : sol){
            System.out.print(n);
        }

    }

    public static int[] solution(int[] answers) {
        /*
        https://programmers.co.kr/learn/courses/30/lessons/42840
        1 : 12345, 12345 ...
        2 : 21, 23, 24, 25, 21 23 24 25 ...
        3 : 33, 11, 22, 44, 55, 33, 11, 22, 44, 55..

        1번부터 마지막 문제까지의 정답 배열 answers
        가장 많은 문제 맞힌 사람 return
        높은 점수가 여러명일때는 오름차순으로 return
        문제의 정답은 1,2,3,4,5 중 하나. 시험은 최대 10,000문제
        */
        int[] first={1, 2, 3, 4, 5};
        int[] second={2, 1, 2, 3, 2, 4, 2, 5};
        int[] third={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int c1=0, c2=0, c3=0;
        for(int i=0; i< answers.length; i++){
            if(answers[i]==first[i%5]) c1++;
            if(answers[i]==second[i%8]) c2++;
            if(answers[i]==third[i%10]) c3++;
        }
        System.out.println("c1="+c1+", c2="+c2+", c3="+c3);

        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.max(c1, Integer.max(c2, c3));
        if(max==c1) list.add(1);
        if(max==c2) list.add(2);
        if(max==c3) list.add(3);

        int[] answer=new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i]=list.get(i);
        }

        return answer;
    }
}
