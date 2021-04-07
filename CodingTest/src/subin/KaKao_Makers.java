package subin;

import java.util.ArrayList;

public class KaKao_Makers {

	public static void main(String[] args) {
		int[] gift= {4, 5, 3, 2, 1};
		int[] want= {2, 4, 4, 5, 1};
		System.out.println(solution(gift,want)); //1
	}
	
    public static int solution(int[] gift_cards, int[] wants) {
    	/*
    	#1
    	4 5 3 2 1 / 2 4 4 5 1 => 1
    	1) 1번째사람, 4번째사람 교환
    	2 5 3 4 1
    	2) 2번째사람, 4번째사람 교환
    	2 4 3 5 1
    	=> 최종적으로 3번째사람은 원하는걸 못받으니 1
    	#2
    	5 4 5 4 5 / 1 2 3 5 4 => 3
    	1) 4번째사람과 5번째 사람 교환
    	5 4 5 5 4
    	=> 더 바꿀 수 없으므로 최종적으로 3
    	
    	최종적으로 받지 못하는 사람을 최솟값
    	*/
    	 ArrayList<Integer> giftArr = new ArrayList<Integer>();
         ArrayList<Integer> wantsArr = new ArrayList<Integer>();

         for (int i=0; i<gift_cards.length; i++) {
             giftArr.add(gift_cards[i]);
             wantsArr.add(wants[i]);
         }

         for(int k=0; k<giftArr.size(); k++){
             for(int l=0; l<wantsArr.size(); l++){
                 if(giftArr.get(k)==wantsArr.get(l)){
                     giftArr.remove(k);
                     wantsArr.remove(l);
                 }
             }
         }

         return wantsArr.size();
    	
    }
}
