package subin;


public class Dev_01 {

	public static void main(String[] args) {
		int[] lo= {45, 4, 35, 20, 3, 9};
		int[] wi= {20, 9, 3, 45, 4, 35};
		int[] answer = solution(lo, wi);
		for(int n : answer) System.out.println(n);
	}
	public static int[] solution(int[] lottos, int[] win_nums) {
		/*
		lottos = 길이가 6인 정수 배열, 원소들은 0이상 45이하, 각각 하나만 0은 중복가능
		win_nums역시 길이가 6 1이상 45이하, 같은 숫자 2개이상 X
		*/
		int num=0;
		int k=0;
		for(int i=0; i<lottos.length; i++) {
			for(int j=0; j<lottos.length; j++) {
				if(lottos[i]==win_nums[j]) num++;
			}
			if(lottos[i]==0) k++;
		}
		System.out.println("num = " + num + ", k =" + k);
		
		int rank=0;
		int[] answer = new int[2];
		for(int i=0; i<2; i++) {
			switch(num+k) {
				case 0, 1: rank=6; break;
				case 2 : rank=5; break;
				case 3 : rank=4; break;
				case 4 : rank=3; break;
				case 5 : rank=2; break;
				case 6 : rank=1; break;
			}
			answer[i]=rank;
			num-=k;
		}
		
		
        return answer;
    }
}
