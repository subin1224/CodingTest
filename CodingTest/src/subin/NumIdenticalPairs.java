package subin;

import java.util.HashMap;
import java.util.Map;

public class NumIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        /*
        #Hash Table , Easy 문제
        https://leetcode.com/problems/number-of-good-pairs/

        내가 생각한 방법
        1) 이중for문을 쓴다.
        2) Map.getOrDefault를 쓴다.
        */

        //첫번째 방법 for문을 두번 쓴다 -> 시간이 오래 걸릴 수 있다.
        int answer=0;
        for(int i=0; i<nums.length;i++){
            for(int j=0; j<i; j++){
                if(nums[i]==nums[j]) answer++;
            }
        }
        return answer;
    }

    public int numIdenticalPairs2(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            res += map.get(n) - 1;
        }
        return res;
    }

    public static int numIdenticalPairs3(int[] nums) {
        /*
        다른 방법 : faster than 100.0%
        nums.length 는 1보다 크거나 같고, 100보다 크거나 같다.
        해당 nums안에 있는 숫자들 역시 1보다 크거나 같고, 100보다 크거나 같다.
        이 점을 이용하여 풀자.

        배열을 사용하여 각 숫자의 빈도 계산이 가능하다.
        숫자 n 번 나타나면이 숫자로 n * (n – 1) / 2 쌍을 만들 수 있다.
        */

        int answer=0;
        int[] count = new int[101];

        for(int n : nums){ //중복 되는 값이면 ++ 해준다
            count[n]++;
            System.out.println("count["+n+"]=="+count[n]);
        }

        for(int n : count){
            answer += (n*(n-1))/2; //같은 값의 쌍의 갯수를 찾는다...
            /*
            해당 main에 있는 nums로 대입해보면, count[1]=4 즉, 1이 중복되는 숫자가 4개가 된다.
            그렇다면 4개중에 3개를 뽑을 수 있으며, i<j 이므로, /2를 해준다. (i>j 가 되는경우를 생각)
            */
            System.out.print(" answer ::: " + answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] n = {1,1,1,4,2,1,9,5,4,3};
        System.out.println();
        System.out.println("MAIN::"+numIdenticalPairs3(n));
    }

}
