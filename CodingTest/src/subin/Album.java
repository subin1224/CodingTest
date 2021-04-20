package subin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album {
	public static void main(String[] args) {
		String[] genres= {"classic", "pop", "classic", "classic", "pop"};
		//String[] genres= {"classic", "pop", "classic", "classic","jazz","pop", "Rock", "jazz"};
		int[] plays= {500, 600, 150, 800, 2500}; // 4 1 3 0
		//int[] plays= {500, 600, 150, 800, 1100, 2500, 100, 1000}; //answer : 5 1 4 7 3 0 6
		
		int[] answer = solution(genres,plays);
		
		System.out.println("====Main===");
		for(int n : answer) System.out.print(n+" "); //4 1 3 0
	}
    public static int[] solution(String[] genres, int[] plays) {
    	/*
    	1. 속한 노래가 많이 재생된 장르 먼저 수록
    	2. 장르 내에서 많이 재생된 노래 먼저 수록
    	3. 재생 횟수가 같다면 고유 번호가 낮은 노래 수록
    	return 베스트 앨범에 들어갈 노래의 고유 번호 (한 장르당 가장 많은 plays를 가진 2개의 곡만)
    	genres[i] : 고유번호가 i인 노래의 장르
    	plays[i] : 고유번호가 i인 노래가 재생된 횟수
    	장르에 속한 곡이 하나라면, 하나의 곡만 선택 / 재생된 횟수 중복 X
    	*/
    	Map<Integer, Integer> album = new HashMap<Integer, Integer>();
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	ArrayList<Map<String, Integer>> list = new ArrayList<Map<String,Integer>>();
    	
    	//Map에 저장
    	for(int i=0; i<genres.length; i++) {
    		album.put(plays[i],i); //album 은 plays와 고유번호 i가 담겨져 있음
    		map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]); //해당 장르에 몇번이 play되었는지
    	}
    	list.add(map);
    	//Collections.sort(list, new Comparator<>() {
    		
		//});
    	
    	
    	//return 고유번호들
        int[] answer = {};
        return answer;
    }
}
