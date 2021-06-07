package subin;

public class Keypad {
	public static void main(String[] args) {
		int[] n = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String h = "right";
		System.out.println(":::MAIN::::");
		System.out.println(solution(n, h)); // "LRLLLRLLRRL"
	}

	public static String solution(int[] numbers, String hand) {
		/*
		 * https://programmers.co.kr/learn/courses/30/lessons/67256 123 456 789 0 부터 시작
		 * 147 왼손 # 부터 시작 369 오른손 2580 현재 키워드 위치에서 더 가까운 엄지손가락 (왼손 오른손) 두 엄지손가락 거리가 같다면
		 * 오른손잡이는 오른손 엄지손가락 / 왼손잡이는 왼손 엄지손가락
		 */
		String answer = "";

		int[] left = new int[2];
		int[] right = new int[2];
		left[0] = 4;
		left[1] = 1;
		right[0] = 4;
		right[1] = 3;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				left[1] = 1;
				if (numbers[i] == 1)
					left[0] = 1;
				if (numbers[i] == 4)
					left[0] = 2;
				if (numbers[i] == 7)
					left[0] = 3;
				answer += "L";
			}
			if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				right[1] = 3;
				if (numbers[i] == 3)
					right[0] = 1;
				if (numbers[i] == 6)
					right[0] = 2;
				if (numbers[i] == 9)
					right[0] = 3;
				answer += "R";
			}
			if (numbers[i] == 2) {
				if ((int) Math.abs(left[0] - 1) + (int) Math.abs(left[1] - 2) > (int) Math.abs(right[0] - 1)
						+ (int) Math.abs(right[1] - 2)) {
					answer += "R";
					right[0] = 1;
					right[1] = 2;
				} else if ((int) Math.abs(left[0] - 1) + (int) Math.abs(left[1] - 2) < (int) Math.abs(right[0] - 1)
						+ (int) Math.abs(right[1] - 2)) {
					answer += "L";
					left[0] = 1;
					left[1] = 2;
				} else {
					if (hand.equals("left")) {
						answer += "L";
						left[0] = 1;
						left[1] = 2;
					} else {
						answer += "R";
						right[0] = 1;
						right[1] = 2;
					}
				}
			}
			if (numbers[i] == 5) {
				if ((int) Math.abs(left[0] - 2) + (int) Math.abs(left[1] - 2) > (int) Math.abs(right[0] - 2)
						+ (int) Math.abs(right[1] - 2)) {
					answer += "R";
					right[0] = 2;
					right[1] = 2;
				} else if ((int) Math.abs(left[0] - 2) + (int) Math.abs(left[1] - 2) < (int) Math.abs(right[0] - 2)
						+ (int) Math.abs(right[1] - 2)) {
					answer += "L";
					left[0] = 2;
					left[1] = 2;
				} else {
					if (hand.equals("left")) {
						answer += "L";
						left[0] = 2;
						left[1] = 2;
					} else {
						answer += "R";
						right[0] = 2;
						right[1] = 2;
					}
				}
			}
			if (numbers[i] == 8) {
				if ((int) Math.abs(left[0] - 3) + (int) Math.abs(left[1] - 2) > (int) Math.abs(right[0] - 3)
						+ (int) Math.abs(right[1] - 2)) {
					answer += "R";
					right[0] = 3;
					right[1] = 2;
				} else if ((int) Math.abs(left[0] - 3) + (int) Math.abs(left[1] - 2) < (int) Math.abs(right[0] - 3)
						+ (int) Math.abs(right[1] - 2)) {
					answer += "L";
					left[0] = 3;
					left[1] = 2;
				} else {
					if (hand.equals("left")) {
						answer += "L";
						left[0] = 3;
						left[1] = 2;
					} else {
						answer += "R";
						right[0] = 3;
						right[1] = 2;
					}
				}
			}
			if (numbers[i] == 0) {
				if ((int) Math.abs(left[0] - 4) + (int) Math.abs(left[1] - 2) > (int) Math.abs(right[0] - 4)
						+ (int) Math.abs(right[1] - 2)) {
					answer += "R";
					right[0] = 4;
					right[1] = 2;
				} else if ((int) Math.abs(left[0] - 4) + (int) Math.abs(left[1] - 2) < (int) Math.abs(right[0] - 4)
						+ (int) Math.abs(right[1] - 2)) {
					answer += "L";
					left[0] = 4;
					left[1] = 2;
				} else {
					if (hand.equals("left")) {
						answer += "L";
						left[0] = 4;
						left[1] = 2;
					} else {
						answer += "R";
						right[0] = 4;
						right[1] = 2;
					}
				}
			}
		}

		return answer;
	}
	
	//다른사람 풀이
	class Solution {
	    //        0부터 9까지 좌표 {y,x}
	    int[][] numpadPos = {
	            {3,1}, //0
	            {0,0}, //1
	            {0,1}, //2
	            {0,2}, //3
	            {1,0}, //4
	            {1,1}, //5
	            {1,2}, //6
	            {2,0}, //7
	            {2,1}, //8
	            {2,2}  //9
	    };
	    //초기 위치
	    int[] leftPos = {3,0};
	    int[] rightPos = {3,2};
	    String hand;
	    public String solution(int[] numbers, String hand) {
	        this.hand = (hand.equals("right")) ? "R" : "L";

	        String answer = "";
	        for (int num : numbers) {
	            String Umji = pushNumber(num);
	            answer += Umji;

	            if(Umji.equals("L")) {leftPos = numpadPos[num]; continue;}
	            if(Umji.equals("R")) {rightPos = numpadPos[num]; continue;}
	        }
	        return answer;
	    }

	    //num버튼을 누를 때 어디 손을 사용하는가
	    private String pushNumber(int num) {
	        if(num==1 || num==4 || num==7) return "L";
	        if(num==3 || num==6 || num==9) return "R";

	        // 2,5,8,0 일때 어디 손가락이 가까운가
	        if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
	        if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";

	        //같으면 손잡이
	        return this.hand;
	    }

	    //해당 위치와 번호 위치의 거리
	    private int getDist(int[] pos, int num) {
	        return Math.abs(pos[0]-numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
	    }
	}
	
}
