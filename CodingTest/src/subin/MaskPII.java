package subin;

public class MaskPII {
	public static void main(String[] args) {
		String email = "ABCD@leetcode.com";
		String number = "86-(10)12345678";
		
		System.out.println("::MAIN 이메일::" + maskPII(email));
		System.out.println("::MAIN 번호 ::" + maskPII(number));
	}
	
	public static String maskPII(String S) {
        /*
        https://leetcode.com/problems/masking-personal-information/
        @가 있으면 : 이메일 
        +,(,),,- : 전화번호
        모든 이름은 소문자로 변환되어야 하고 첫 번째 이름의 첫 번째와 마지막 문자 사이의 모든 문자는 5 별표로 교체
        @앞이 두글자면 첫글자와 마지막 사이에 별표 5개가 있어야 함
        전화번호 : 국가 코드는 선택사항 / 마지막 4 자리 만 노출하고 다른 모든 숫자를 마스킹하려고합니다.
        */
		
		String answer="";
		//이메일인지 전화번호 인지 체크
		if(S.indexOf('@')!=-1) { //이메일이 아닌 경우
			S=S.toLowerCase(); //소문자로 변환
			
			int index = S.indexOf('@');
			String start = S.substring(0,1);
			String end = S.substring(index-1,index);
			answer = start + "*****" + end + S.substring(index);
		}else { //전화번호인 경우
			S = S.replaceAll("[^0-9]", ""); //숫자만 추출
			String number = S.substring(S.length()-4);
			
			if(S.length()==10) { //국가 번호가 없는 경우
				answer = "***-***-" + number;
			}else { //국가 번호가 있는 경우 S.length()!=10
				//501 321 502 3431
				S = S.substring(0, S.length()-4); //501 321 502
				String th = S.substring(S.length()-3);
				th=th.replaceAll("[0-9]", "*");
				S = S.substring(0, S.length()-3); //501 321
				String sec = S.substring(S.length()-3);
				sec=sec.replaceAll("[0-9]", "*");
				S = S.substring(0, S.length()-3); //501
				S = S.replaceAll("[0-9]", "*");
				answer = "+" + S + "-" + sec + "-" + th + "-" + number;
			}
		}
		
		return answer;
    }
}
