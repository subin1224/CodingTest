package subin_Study;

public class Divisor {
	//약수 알고리즘을 이용하여 최소공배수, 최대공약수 구하기
	
	//유클리드 (a를 b로 나눈 나머지가 0보다 클 때 까지 반복) 호제법 사용 - 시간복잡도 O(n)
	static int gcd(int a, int b) { //최대공약수
		while(b!=0) {
			int r=a%b;
			a=b;
			b=r;
		}
		return a;
	}
	
	//재귀함수 사용 - 구현이 간단, 코드 간결, 시간 복잡도 O(logN)
	static int GCD(int a, int b) { //최대공약수 - 재귀함수 사용
		if(a%b ==0) {
			return b;
		}
		return GCD(b, a%b);
	}
	
	static int lcm(int a, int b) { //최소공배수
		/*
		두 자연수 A,B의 최대공약수가 G, 최소공배수가 L일때
		A= a*G, B=b*G (a,b는 서로소) 라고 하면
		L=a*b*G
		A*B=L*G
		두개의 식이 성립 이를 이용
		*/
		
		//L=A*B/G
		//0이 아닌 두 수의 곱 / 두 수의 최대 공약수
		return a*b / gcd(a,b);
	}
	
}
