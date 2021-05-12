package subin;

import java.util.Stack;

public class Crane {
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println("MAIN :::: " + solution(board, moves));
	}
	
	public static int solution(int[][] board, int[] moves) {
        /*
        https://programmers.co.kr/learn/courses/30/lessons/64061
        board : 게임화면의 격자 상태
        moves : 크레인을 작동시킨 위치
        return 크레인을 모두 작동시킨후 터트려져 사라진 인형의 개수
        
        바구니에 같은 모양(숫자) 가 2개 연속해서 쌓이게 되면 두 인형은 터뜨려짐
        0 은 빈칸을 나타냄
        */
		int answer = 0;
		
		//바구니에 담아놓기
		Stack<Integer> q = new Stack<Integer>();
		for(int i=0; i<moves.length; i++) {
			for(int j=0; j<board.length; j++) {
				if(board[j][moves[i]-1]!=0) {
					if(!q.isEmpty()) {
						if(q.peek()==board[j][moves[i]-1]) {
							q.pop();
							answer+=2;
						}else {
							q.add(board[j][moves[i]-1]);							
						}
					}else {
						q.add(board[j][moves[i]-1]);
					}
					board[j][moves[i]-1]=0;						
					break;
				}//0이 아닐때
			}
		}
        return answer;
    }
	
	//기존에 푼거 => 틀림 => 문제 잘못 이해 - moves[i], j 좌표개념 잘못 잡음ㅜㅜ
	int solution2(int[][] board, int[] moves) {
		int answer=0;
		Stack<Integer> q = new Stack<Integer>();

		for(int i=0; i<moves.length; i++) {
			Stack<Integer> stack = new Stack<Integer>();
			for(int j=0; j<board.length; j++) {
				if(board[moves[i]-1][j]!=0) {
					stack.add(board[moves[i]-1][j]);
				}
			}
			
			int len = board.length-1;
			for(int z=0; z<i; z++) {
				if(moves[i]==moves[z]) {
					len--;
				}
			}
			if(!stack.empty()) {
				q.add(stack.pop());
				board[moves[i]-1][len]=0;
			}
		}
		System.out.println(q);
		while(!q.empty()) {
			int a = q.pop();
			if(q.empty()) break;
			if(a==q.peek()) {
				answer+=2;
				q.pop();
			}
		}
		
		return answer;
	}
}
