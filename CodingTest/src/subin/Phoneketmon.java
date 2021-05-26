package subin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Phoneketmon {
    public static void main(String[] args) {
        int[] n = {3,3,3,2,2,2};
        System.out.println(":::::::MAIN:::::::::::"+solution(n)); //2
    }

    public static int solution(int[] nums) {
        /*
        https://programmers.co.kr/learn/courses/30/lessons/1845
        return 선택할 수 있는 폰켓못 종류 번호의 갯수 최댓값
        */
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        if(map.size()>nums.length/2){
            answer = nums.length/2;
        }else{
            answer=map.size();
        }

        return answer;
    }

    //다른 사람 풀이 방법
    public int solution2(int[] nums){
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            hs.add(nums[i]);
        }

        if(hs.size() > nums.length/2) return nums.length/2;

        return hs.size();
    }
}