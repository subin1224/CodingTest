package subin;

import java.util.Stack;

public class MakeMaxNumber {
	public static void main(String[] args) {
		String n = "1231234";
		int k = 3;
		
		System.out.println("MAIN::::" + solution(n, k)); //return "3234"
	}

	public static String solution(String number, int k) {
		/*
		Greedy 문제 Lv2
		https://programmers.co.kr/learn/courses/30/lessons/42883
		return number 에서 k개의 수를 제거했을때 얻을 수 있는 가장 큰 숫자
		k는 1이상 number의 자릿수 미만인 자연수
		배열을 재배치하는것이 아니라 숫자 그대로 연속되어야함..
		
		우선순위를 두자 => 첫번째 오는 숫자는 가장 커야함. 단, 그 숫자 이후의 숫자의 갯수는 k개가 넘어야함
		그 후 k=0이 될때까지 뒤에있는 숫자가 크면 해당 숫자 지우고 뒤에있는 숫자를 select
		k=0이면 그 뒤에있는 숫자를 쭉 붙임
		*/
		
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
	
	
	//다른사람 풀이
	public static String solution2(String number, int k) {		
		StringBuilder answer = new StringBuilder();
		int idx=0;
		char max;
		
		//0일때는
		if(number.charAt(0)=='0') return "0";
		
		for(int i=0; i<number.length()-k;i++) {
			max='0';
			for(int j=idx; j<=k+i; j++) {
				if(max < number.charAt(j)) {
					max=number.charAt(j);
					idx=j+1;
				}
			} //안쪽 for
			answer.append(max);
		}
		
		return answer.toString();
    }
}
