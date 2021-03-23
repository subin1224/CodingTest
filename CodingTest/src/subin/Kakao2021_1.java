package subin;

import java.util.regex.Pattern;

public class Kakao2021_1 {

	public static void main(String[] args) {
		
	}
	
	class Solution {
	    public String solution(String new_id) {
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
    		new_id.toLowerCase();
    		
	    	//2. 정규식에 맞지 않은 문자들을 새로운 문자 배열에 추가
    		String[] idArr=new_id.split("");
    		String[] anArr=new String[idArr.length]; //answer 들의 String배열
    		
    		for(int i=0;i<idArr.length;i++) {
    			//if(pattern.matches("^[a-z-_.0-9]*$", idArr[i])) idArr[i]=anArr[i];
    		}
    		
    		
	    	
	    	String answer = "";
	        return answer;
	    }
	}
}
