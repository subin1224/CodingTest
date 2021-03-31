package subin;

import java.util.Arrays;

public class PhoneBook {
    public static void main(String[] args) {
        String[] pb={"119", "97674223", "1195524421"};
        System.out.println(solution(pb));
    }
    public static boolean solution(String[] phone_book) {
        /*
        https://programmers.co.kr/learn/courses/30/lessons/42577
        어떤 번호가 다른 번호의 접두어인 경우가 있으면 false, 그렇지 않으면 true
        문자열 Arrays sort
        false면 STOP
        */
        Arrays.sort(phone_book);
        boolean answer=false;
        for(int i=0; i< phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = true;
                break;
            }
        }
        return !answer;
    }
}