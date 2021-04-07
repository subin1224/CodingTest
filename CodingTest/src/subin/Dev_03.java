package subin;

import java.util.HashSet;
import java.util.Set;

public class Dev_03 {
	public static void main(String[] args) {
		int[][] queries= {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[] answer = solution(6, 6, queries);
		for(int n : answer) System.out.print(":::::::::"+n);
	}
    public static int[] solution(int rows, int columns, int[][] queries) {
    	/*
    	2<=rows, columns<=100
    	아무 회전도 하지 않았을 때, i 행 j 열에 있는 숫자는 ((i-1) x columns + j)
    	1 ≤ x1 < x2 ≤ rows, 1 ≤ y1 < y2 ≤ columns
    	모든 회전은 순서대로
    	최솟값 구하기
    	*/
        //int[] answer = new int[queries.length];
    	int[] answer = {};
        int[][] array = new int[rows][columns];
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<rows; i++) {
        	for(int j=0; j<columns; j++) {
        		array[i][j] = (i * columns + j + 1);
        	}
        }
       
        int a, b, c, d=0;
        int temp=0;
        for(int i=0; i<queries.length; i++) {
        	a=queries[i][0]; //2
        	b=queries[i][1]; //2
        	c=queries[i][2]; //5
        	d=queries[i][3]; //4
        	
        	for(int j=a; j<c; j++) {
        		temp=array[j][b];
        		array[j][b]=array[j+1][b];
        		array[j][b+1]=temp;
        		set.add(temp);
        	}
        	array[c][b]=array[c][b+1];
        	
        }
        
        
        return answer;
    }
	
}
