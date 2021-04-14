package subin;

import java.util.*;

public class MaxNumber {
    public static void main(String[] args) {
        int[] n = {6, 10, 2}; //return 6210
        //int[] n = {3, 30, 34, 5, 9}; //return 9534330

        System.out.println("::MAIN::" + solution(n));
    }

    public static String solution(int[] numbers) {
        /*
        https://programmers.co.kr/learn/courses/30/lessons/42746
        0또는 양의 정수가 주어졌을때 정수를 이어 붙여 만들 수 있는 가장 큰 수 알아내기
        return 가장 큰 수를 문자열로 바꿈 (정답이 클 수 있으니..)
        numbers의 원소는 0이상 1000이하!!

        6, 10, 2 => 6210 ( 6 2 10 )
        3, 30, 34, 5, 9 => 9534330 ( 9 5 34 3 30 )
        12, 121 => 12121 ( 12 121 )
        21, 212 => 21221 ( 212 21 )
        0, 0, 0, 0 => 0
        */
        String[] sArr = new String[numbers.length];
        for(int i=0; i< numbers.length; i++){
            sArr[i]=String.valueOf(numbers[i]); //String.valueOf(int n) : n을 String으로 바꿔줌
        }

        //정렬 : 새로 배운 부분!! new Comparator를 오버라이딩 하자!
        Arrays.sort(sArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((o2+o1).compareTo(o1 + o2));
            }
        });

        //0만 여러개 있는 경우 0 리턴
        if(sArr[0].equals("0")) return "0";

        String answer = "";
        for(String str : sArr) answer+=str;
        return answer;

    }
}