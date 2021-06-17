package subin;

public class Bits {
	 public static void main(String[] args) {
	        long[] l = {2,7};
	        long[] answer = solution(l);

	        System.out.println("::::::::::::::MAIN::::::::::::");
	        for(long i : answer){
	            System.out.print(i + " "); //3 11
	        }
	    }

	    public static long[] solution(long[] numbers) {
	        /*
	        https://programmers.co.kr/learn/courses/30/lessons/77885
	        양의 정수 x
	        f(x) = x보다 크고 x와 비트가 1~2개 다른 수 들 중에서 제일 작은 수
	        예를들어 f(2) = 3 , f(7) = 11
	        정수들이 담긴 배열 numbers
	        각 수의 f값을 차례대로 answer에 담아 return
	        */
	        long[] answer = new long[numbers.length];

	        for(int i=0; i<numbers.length; i++){
	            answer[i] = function(numbers[i]);
	        }

	        return answer;
	    }
	    public static long function(long num){
	        if(num%2==0) return num+1; else return num+(num^(num+1)+1)/4+1;
	    }

	    //다른 해결책 ::  비트논리연산자, 쉬프트 연산자 이용
	    public long[] solution2(long[] numbers) {
	        long[] answer = new long[numbers.length];
	        for(int i = 0; i< answer.length; i++){
	            answer[i]++;
	            answer[i] += (answer[i]^numbers[i])>>>2;
	        }

	        return answer;
	    }

	    /*
	    [ 비트 연산자 정리 ]
	    종류 : & | ^ ~
	    비트 연산자는 피연산자의 각 비트들을 대상으로 연산이 이루어 지며 총 4개의 연산자가 있다.
	    & : 비트 단위의 AND - 피연산자 양 쪽이 모두 1일때만 1을 결과로 얻고 그 외에는 0을 얻는다.
	    | : 비트 단위의 OR - 한쪽이 1이면 1을 결과로 얻고 그 외에는 0을 얻는다.
	    ^ : XOR (배타적 OR) - 피연산자의 값이 서로 다를 때만 1을 결과로 얻고 그 외에는 0을 얻는다.
	    ~ : 0은 1로, 1은 0으로 바꾼다.

	    [ 쉬프트 연산자 정리 ]
	    쉬프트 연산자는 피연산자의 각 비트들을 오른쪽(>>) 또는 왼쪽(<<) 으로 이동시킨다.
	    >> : bit 값을 오른쪽으로 이동 (빈 자리는 부호값으로 대입) - 2의 n승으로 나눈 결과와 같다다
	   << : bit 값을 왼쪽으로 이동 (빈 자리는 0으로 대입) - 2의 n승을 곱한 결과와 같다
	    >>> : bit값을 오른쪽으로 이동 (빈 자리는 0으로 대입)
	    ---- 예시 ----
	    논리 오른쪽 시프트 연산자 >>>
	    178 >>> 2 : 오른쪽으로 2 비트 시프트한다.
	    자바에 추가된 논리 시프트는 오른쪽으로 밀면서 비게되는 앞쪽 비트를 무조건 0 으로 채워넣는 것이다.
	    10110010
	    0010110010
	    으로 되는 것으로,
	    역시 오른쪽으로 밀려난 2개 비트 10 은 삭제되고, 비게되는 왼쪽 2비트는 무조건 0으로 채워진다.
	    따라서 10110010 을 오른쪽으로 논리 시프트 하면, 00101100 이 된다. //
	    --------------------------------

	    더 자세한 설명 :
	    https://coding-factory.tistory.com/521

	    문제 해설 :
	    https://prgms.tistory.com/57
	    */
	}