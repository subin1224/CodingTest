package subin;

import java.util.regex.Pattern;

public class Kakao2021_1 {
    public static void main(String[] args) {
        //2021 카카오 공채 문제 1번
        String new_id="abcdefghijklmn.p";
        /*
        answer 이 추천해주는 아이디. 3자이상 15자 이하
        알파벳 소문자, 숫자, 빼기 ( - ) , 밑줄 ( _ ) , 마침표 (.) 만 사용 가능
        단, 마침표는 처음과 끝에 사용 불가, 연속으로 사용 불가
        1. 대문자 -> 소문자
        2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        3. 마침표가 2번이상 연속 되었다면 하나의 마침표로 치환
        4. 빈 문자열 = 공백 이라면 "a" 를 대입
        5. 아이디 길이가 16자 이상이면 15개 이후부터는 제거, 만약 마침표가 끝에 위치한다면 끝 마침표 제거
        6. 아이디가 2자 이하면 마지막 문자를 길이가 3이 될때까지 계속 붙임
        */

        //정규식 이용 a~z, -, _, .
        Pattern pattern = Pattern.compile("^[a-z-_.0-9]*$");

        // 1. 소문자로 치환
        new_id=new_id.toLowerCase();
        System.out.println("1번 소문자로 치환 :::: "+new_id);


        //2. 정규식에 맞지 않은 문자들을 새로운 문자 배열에 추가
        String[] idArr=new_id.split("");
        String[] anArr=new String[idArr.length]; //answer 들의 String배열

        for(int i=0;i<idArr.length;i++) {
            if(pattern.matches("^[a-z-_.0-9]*$", idArr[i])){
                anArr[i]=idArr[i];
            }else{
                anArr[i]="";
            }
            System.out.println("정규식에 맞는것만 배열에 넣기 :: " + anArr[i]);
        }

        //3. 마침표가 2번 이상이면 1번으로 치환
        String answer= String.join("",anArr);
        System.out.println("join()을 이용해 문자열배열을 문자로 ::: "+answer);

        while(true){
            answer=answer.replace("..",".");
            if(answer.indexOf("..")==-1) break;
        }
        System.out.println("3번 ..을 .으로 replace ::: "+answer);

        //4. 공백이면 "a"를 대입, 처음에 .이 있다면 제거
        //.제거
        while(true){
            if(answer.indexOf(".")==0){
                answer=answer.substring(1,answer.length());
            } else{
                break;
            }
        }

        System.out.println("4번-1 처음에 나오는 문자가 . 이라면 제거 ::: "+answer);

        if(answer==null || answer.isEmpty()) answer+="a";
        System.out.println("4번 공백이 있다면 a로 치환 replace ::: "+answer);

        //5. 아이디 길이가 16자 이상이라면 15개 이후부터는 제거, 끝이 마침표라면 마침표 제거
        if(answer.length()>=16) {
            answer = answer.substring(0, 15); //제거
        }

        if(answer.substring(answer.length()-1).equals(".")) answer=answer.substring(0,answer.length()-1);
        System.out.println("5번 16장 이상이라면 15자까지 보이게 ::: "+answer);

        //6. 아이디가 2자 이하면 최소 글자인 3자가 될때까지 마지막 문자 추가
        while(true){
            if(answer.length()<=2){
                String last=answer.substring(answer.length()-1);
                answer+=last;
            }else{
                break;
            }
        }

        System.out.println("6번 2자 이하라면 최소 3자 될때까지 마지막 문자 추가::: "+answer);

        System.out.println("새로운 아이디 추천은 :::: "+answer);
    }
}