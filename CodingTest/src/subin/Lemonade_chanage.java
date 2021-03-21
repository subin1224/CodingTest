package subin;

public class Lemonade_chanage {
	static class Solution {
	    public static boolean lemonadeChange(int[] bills) {
	    	/*
	    	레몬에이드 5
	    	구매자는 5 10 20 만 지불 가능
	    	거스름돈은 5 10 으로만 줄 수 있음
	    	예를들어 구매자가 20 지불하면 5 10 줌
	    	
	    	 1) 처음에는 5만 받아야 함. 그게 아니면 return false
	    	 2) 5와 10이 둘 다 가지고 있지 않으면 20을 받지 않음 return false
	    	 3) 10을 받으면 가지고있는 돈에서 5를 빼야함.
	    	 4) 5를 받으면 나는 5가 ++
	    	
	    	5 10 10 => false
	    	*/
	    	int five=0, ten=0;
	    	
	    	if(bills[0]!=5) return false;
	    	
	    	for(int i=0; i<bills.length; i++) {
	    		if(bills[i]==5) {
	    			five++;
	    		}else if(bills[i]==10) { 
	    			if(five<=0) return false;
	    			ten++; five--;
	    			
	    		}else { //20
	    			if(five>=3 && ten==0) {
	    				five-=3;
	    			}else if(ten>=1 && five>=1) {
	    				ten-=1; five-=1;
	    			}else {
	    				return false;
	    			}
	    		}
	    	}//for
	    	return true;
	    }//
	   
	}
	
	public static void main(String[] args) {
		int[] bills = {5, 10, 10}; //test -> false
		System.out.println(Solution.lemonadeChange(bills));
	}
}
