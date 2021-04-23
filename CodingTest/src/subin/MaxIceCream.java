package subin;

import java.util.Arrays;

public class MaxIceCream {
	public static void main(String[] args) {
		int[] c = {10,6,8,7,7,8};
		int coins = 5;
		System.out.println("::::MAIN::::"+maxIceCream(c, coins));
	}
	public static int maxIceCream(int[] costs, int coins) {
        /*
        https://leetcode.com/problems/maximum-ice-cream-bars/
        coins로 살 수 있는 아이스크림 최대 갯수
        costs = 아이스크림 가격 배열
        */
		Arrays.sort(costs);
		
		int answer=0;
		for(int i=0; i<costs.length;i++) {
			if(costs[i]<=coins) {
				answer++;
				coins-=costs[i];
			}else {
				break;
			}
		}
		
		return answer;
    }
}
