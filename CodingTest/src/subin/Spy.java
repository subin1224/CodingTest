package subin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Spy {
    public static void main(String[] args) {
        String[][] clothes={{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.println(solution(clothes)); //5
    }

    public static int solution(String[][] clothes) {
        /*
        https://programmers.co.kr/learn/courses/30/lessons/42578
        Value에는 얼굴, 상의, 하의, 겉옷 이 올 수 있다.
        (의상종류 별 의상 수 + 1)씩 모두 곱한다 : 의상종류 별 의상수에 그 의상을 안 입는 경우의 수도 생각
		그 후 -1 : 아무것도 모두 안 입는 경우의 수 빼야함 (문제에서 최소 1개이상 입어야한다고 함)
        */
    	int answer=1;
        Map<String, Integer>map = new HashMap<>();
        for(int i=0; i< clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        
        Iterator<Integer> iter = map.values().iterator();
        while(iter.hasNext()) {
        	answer *= iter.next().intValue()+1;
        }
        return answer-1;
    }
 

}
