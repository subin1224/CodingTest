package subin;

import java.util.Arrays;

public class IntTriangle {
	public int solution(int[][] triangle) {
		/*
		https://programmers.co.kr/learn/courses/30/lessons/43105
		DP. LV3
		정수 삼각형에서 꼭대기에서 바닥까지 가는데에 거쳐간 숫자의 합이 가장 큰 경우를 찾으려 함.
		단 아래칸으로 이동 할 때에는 대각선의 방향으로 한칸 오른쪽 또는 왼쪽으로만 이동 가능
		삼각형의 정보가 담긴 배열 : triangle
		return 거쳐간 숫자의 합 최댓값
		*/
        
		//1) 내가 푼 방법 // Test: 8 계속 틀림
		
		//삼각형의 높이는 1이상 500이하
		int[][] dp = new int[501][501];
		
		dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0] + triangle[1][0];
        dp[1][1] = dp[0][0] + triangle[1][1];
        
        //첫번째 idx, 마지막 idx
        for(int i=2; i<triangle.length; i++) {
        	dp[i][0] = dp[i-1][0] + triangle[i][0];
        	dp[i][i-1] = dp[i-1][i-1] + triangle[i][i];
        }
        
        //중간 : 최댓값을 찾아야 하니까
        for(int i=2; i<triangle.length; i++) {
        	for(int j=1; j<i; j++) {
        		dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
        	}
        }
        
        int answer = -1; //삼각형 이루는 숫자는 0이상 이니까
        for(int i=0; i<triangle.length; i++) {
        	if(dp[triangle.length-1][i] > answer) {
        		answer = dp[triangle.length-1][i];
        	}
        }
        
        return answer;
    }
	
	
	//2) 답지
	public int solution2(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++) 
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
	
	//3)
    public int solution3(int[][] triangle) {
        int[][] copyTriangle = new int[triangle.length][triangle.length];

        copyTriangle[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            copyTriangle[i][0] = copyTriangle[i - 1][0] + triangle[i][0];
            copyTriangle[i][i] = copyTriangle[i - 1][i - 1] + triangle[i][i];
        }

        for (int i = 2; i < triangle.length; i++) {
            for (int j = 1; j < i; j++) {
                copyTriangle[i][j] = Math.max(copyTriangle[i - 1][j - 1], copyTriangle[i - 1][j])
                    + triangle[i][j];
            }
        }

        int maxNo = copyTriangle[copyTriangle.length - 1][0];
        for (int i = 1; i < triangle.length; i++) {
            int checkNo = copyTriangle[copyTriangle.length - 1][i];
            if (maxNo < checkNo) {
                maxNo = checkNo;
            }
        }
        return maxNo;
    }
}
