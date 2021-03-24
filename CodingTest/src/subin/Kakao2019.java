package subin;

import java.util.HashMap;
import java.util.Map;

public class Kakao2019 {
	public static void main(String[] args) {
		//https://programmers.co.kr/learn/courses/30/lessons/42888

		/*
	        채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수
	        모든 기록이 처리 된 후 최종적으로 방을 개설한 사람이 보게되는 메세지를
	        문자열 배열 형태로 return
	        모든 유저는 [유저 아이디] 로 구분, 닉네임 중복 허용
	        첫 단어는 Enter, Leave, Change 중 하나
	        명령어 [유저아이디] [닉네임]
	        각 단어는 공백으로 구분, 알파뎃 대문자, 소문자, 숫자로만 이루어짐
	        유저아이디와 닉네임은 알파뎃 대소문자 구별 , 닉네임은 1이상 10이하
	        채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못된 입력은 XXXX

	        "Enter uid1111 Muzi", "Enter uid2222 Ryan", "Leave uid2222", "Enter uid2222 SSSS", "Enter uid3333 BBBB", "Change uid1111 SSSS", "Leave uid1111", "Change uid2222 CCCC"

		 */

		String[] record={"Enter uid1111 Muzi", "Enter uid2222 Ryan", "Leave uid2222", "Enter uid2222 SSSS", "Enter uid3333 BBBB", "Change uid1111 SSSS", "Leave uid1111", "Change uid2222 CCCC"};
		solution(record);
	}
	public static String[] solution(String[] record) {

		Map<String, String> user=new HashMap<String, String>();
		int len=record.length;
		System.out.println("record의 길이" + len);

		//user의 정보 뽑기
		for(int i=0;i<record.length;i++) {
			String[] save = record[i].split(" "); //Enter, uid1234, Muzi. Leave uid2222
			String key = save[1]; //id

			//명령어로 구분
			if (save[0].equals("Enter")) {
				user.put(save[1], save[2]); // 들어오면 user에 기록
			}else if (save[0].equals("Change")) { //닉네임이 변경되었으면
				//해당 Key를 찾아서 Value를 바꾼다.
				String oldValue = (String) user.get(key);
				boolean debug = user.replace(key, oldValue, save[2]); //user에 기록된 닉네임 변경
				System.out.println(i+"번째의 Change :: "+debug); //디버깅작업 잘 바뀌었는지..
				len--; //change 경우에는 출력이 되지 않으므로
			}


		}//for

		System.out.println("최종 return 할 배열의 길이 ==== " + len);

		String[] result=new String[len];
		int z=0; //result의 순서

		//명령어와 user의 기록들 정리
		for(int i=0; i<record.length; i++){
			String[] save = record[i].split(" ");
			if(save[0].equals("Enter")){
				result[z]=user.get(save[1])+"님이 들어왔습니다.";
				z++;
			}else if(save[0].equals("Leave")){
				result[z]=user.get(save[1])+"님이 나갔습니다.";
				z++;
			}
		}

		for(String str : result){
			System.out.println(str);
		}
		return result;
	}

}
