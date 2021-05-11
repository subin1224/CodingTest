package subin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PreMusic {
	public static void main(String[] args) {
		//2017년 카카오공채 4번문제 "방금그곡"
		
		String m = "CC#BCC#BCC#BCC#B";
		String[] music = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		System.out.println("MMMAIN ::: "+solution(m, music));
	}
	
	//hh:mm 형식의 두 시간의 차를 분단위로 리턴
	public static int getMin(String startTime, String endTime) {
		String[] arr;
		arr = startTime.split(":");
		int startMin = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
		
		arr = endTime.split(":");
		int endMin = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
		
		//Math.abs : 절댓값
		return Math.abs(endMin-startMin);
	}
	
	
	public static String solution(String m, String[] musicinfos) {
		ArrayList<String> matchMusic = new ArrayList<String>();
		
		//#문자와 혼동을 피하기 위해 대문자#을 소문자로 변경
		m = m.replace("C#", "c").replace("D#","d").replace("F#", "f").replace("A#", "a");
		
		for(String str : musicinfos) {
			String[] arr = str.split(",");
			
			//실제 재생 시간
			int playLen = getMin(arr[0], arr[1]);
			
			//원곡 멜로디
			String orgPlayStr = arr[3];
			
			//원곡 멜로디도 치환
			orgPlayStr = orgPlayStr.replace("C#", "c").replace("D#","d").replace("F#", "f").replace("A#", "a");
			
			//멜로디 구하기
			int j=0;
			String realPlayStr = "";
			for(int i=0; i<playLen; i++) {
				j = i % orgPlayStr.length();
				realPlayStr += orgPlayStr.charAt(j);
			}
			
			if(realPlayStr.contains(m)) {
				matchMusic.add(str);
			}
		}
		
		//조건에 맞는 음악이 여러개인 경우 재생시간이 긴 곡, 재생시간도 같다면 먼저 입력 된 곡이 앞에 오도록
		Collections.sort(matchMusic, new Comparator<String>() {
	        @Override
	        public int compare(String o1, String o2) {
	            String arr[] = o1.split(",");
	            int len1 = getMin(arr[0], arr[1]);
	            int len2 = getMin(arr[0], arr[1]);
	            return len2 - len1;
	        }
	    });

		return (matchMusic.size()>0) ? matchMusic.get(0).split(",")[2] : "(None)";
    }
}
