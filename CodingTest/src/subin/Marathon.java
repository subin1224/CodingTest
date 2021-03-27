package subin;

import java.util.Arrays;

public class Marathon {
    public static void main(String[] args) {
        //https://programmers.co.kr/learn/courses/30/lessons/42576
        String[] p = {"leo", "kiki", "eden"};
        String[] c = {"eden", "kiki"};
        String answer=solution(p, c);
        System.out.println("정답 !!! " +answer);
    }
    public static String solution(String[] participant, String[] completion) {
        //마라톤에 참여한 선수들 participant , 완주한 선수들 completion, 완주하지 못한 사람 answer
        //단 한명만 완주하지 못함
        //참가자의 이름은 1개이상 20개 이하의 알파벳 소문자, 참가자중에는 동명이인이 있을 수 있음
        String answer = ""; //완주하지 못한 사람
        Arrays.sort(participant);
        for(String str : participant){
            System.out.println(str);
        }
        Arrays.sort(completion);
        for(String str : completion){
            System.out.println(str);
        }
        for(int i=0;i<completion.length;i++){
            if(!participant[i].equals(completion[i])){
                answer=participant[i];
                break;
            }
        }

        if(answer.isEmpty() || answer==null){
            answer=participant[participant.length-1];
        }
        return answer;
    }

}
