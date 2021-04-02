package subin;

import java.util.Arrays;

public class FindK {

	public static void main(String[] args) {
		int[] array= {1, 5, 2, 6, 3, 7, 4};
		int[][] commands= {{2,5,3}, {4,4,1}, {1,7,3}};
		for(int n : solution(array, commands)) System.out.print(n);
	}
	
    public static int[] solution(int[] array, int[][] commands) {
    	/*
    	https://programmers.co.kr/learn/courses/30/lessons/42748
    	array는 주어진 배열
    	commands 에서는 [i, j, k], [i2, j2, k2]...
    	i ~ j 까지 자르고, k번쨰의 숫자 = answer에 들어감
    	*/
    	int[] answer = new int[commands.length];
    	
    	for(int i=0; i<commands.length; i++) {
    		int[] cut = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
    		Arrays.sort(cut);
    		answer[i] = cut[commands[i][2]-1];
    	}
        return answer;
    }
	
}
