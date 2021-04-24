package subin;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        String j = "aA";
        String s = "aAAbbbb";
        System.out.println("MAIN :::: " + numJewelsInStones(j, s));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        /*
        #Hash , Easy
        https://leetcode.com/problems/jewels-and-stones/
        대소문자 구분
        return 해당 stones에 jewels 가 몇개가 있는지
        */
        Set<Character> set = new HashSet<>();

        int answer=0;
        for(Character jew : jewels.toCharArray()) set.add(jew);

        for(Character stone : stones.toCharArray()){
            if(set.contains(stone)) answer++;
        }
        return answer;
    }
}
