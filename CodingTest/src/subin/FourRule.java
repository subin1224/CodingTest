package subin;

import java.util.HashSet;
import java.util.Set;

public class FourRule {

	public static void main(String[] args) {
		int n = 2;
		int number = 11;
		System.out.println("MAIN :::: " + solution(n, number));
	}
	
	public static int solution(int N, int number) {
		/*
		https://programmers.co.kr/learn/courses/30/lessons/42895
		프로그래머스 DP LV3
		N과 사칙연산만 사용해서 number를 표현 할 수 있는 방법
		return N 사용 횟수의 최솟값
		1 <= N <= 9
		number는 1이상 32,000이하
		수식에는 괄호와 사칙연산만 가능, 나누기 연산에서 나머지는 무시
		최솟값이 8보다 크면 -1 return
		
		예)
		N=5, number=12
		( 55 + 5 ) / 5 return 4
		
		N=2, number=11
		22 / 2 return 3
		*/
		
		//접근 :=> N을 8번 사용하여 그 안에 만들 수 있는 모든 수를 만들기
        int answer = -1;
        Set<Integer>[] setArr = new Set[9];
        int t = N;
        for(int i=1; i<9; i++) {
        	setArr[i] = new HashSet<Integer>();
        	setArr[i].add(t);
        	t = t * 10 + N;
        }
        
        //모든 사칙연산 다 사용해서 ... 해당 set배열에 넣기
        for(int i=1; i<9; i++) {
        	for(int j=1; j<i; j++) {
        		for(Integer a : setArr[j]) {
        			for(Integer b : setArr[i-j]) {
        				setArr[i].add(a+b);
        				
        				setArr[i].add(a-b);
        				
        				setArr[i].add(b-a);
        				
        				setArr[i].add(a*b);
        				if(b!=0) {
        					setArr[i].add(a/b);
        				}
        				
        				if(a!=0) {
        					setArr[i].add(b/a);
        				}
        			}
        		}
        	}
        }
        
        //그 안에 포함되어있는지 확인
        for(int i=1; i<9; i++) {
        	if(setArr[i].contains(number)) {
        		answer = i;
        		break;
        	}
        }
        
        
        return answer;
    }
	

	
}
