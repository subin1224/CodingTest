package subin;

public class JoyStick {
	public static void main(String[] args) {
		String name = "JAN";
		System.out.println(":::MAIN::::"+solution(name));
	}
	
	public static int solution(String name) {
		/*
		Lv2 . Greedy : 우선순위가 중요. 
		https://programmers.co.kr/learn/courses/30/lessons/42860
		맨 처음에는 A로만 이루어짐
		▲ - 다음 알파벳
		▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
		◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
		▶ - 커서를 오른쪽으로 이동
		만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
		name은 알파벳 대문자. name의 길이는 1이상 20이하
		*/
		
		int answer = 0; //움직인 횟수
		int len = name.length();
		
		//먼저 한번씩 다 움직인것
		int min_move = len-1;
		
		for(int i=0; i<len; i++) {
			answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)-'A'); //알파벳 순서 커서 (위아래)
			System.out.println("dd=" + ('Z'-name.charAt(i)-'A'));
			//좌우커서
			int next = i+1; //만약 다음번쨰가 'A' 라면 next++;
			while(next<len && name.charAt(next)=='A') next++;
			
			min_move = Math.min(min_move, i+len-next+i); //계속적으로 최솟값을 찾아준다
		}
		
		answer += min_move;
		System.out.println("min_move="+min_move);
		System.out.println("answer="+answer);
		return answer;
    }
	
	//다른 문제풀이
	public int solution2(String name) {
        int answer = 0;
        int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
        for(char c:name.toCharArray()) answer+=diff[c-'A'];

        int length=name.length();
        int min=length-1; //최소 커서 이동 횟수

        for(int i=0;i<length;i++){
            int next=i+1;
            while(next<length && name.charAt(next)=='A'){
                next++;
            }                
            min=Math.min(min, i+length-next+Math.min(i,length-next));
            /*
            앞으로 쭉가는 경우는 처음 초기화로 하드코딩합니다. min = length. 
            그것보다 작은 경우를 찾는 알고리즘이 min = Math.min(min, i + length - next + Math.min(i, length - next));
            i+length-next는 '바로옆의 a들을 제외한 다른 문자들의 길이 -1' 입니다. 
            예를 들면 AAABBBBBBBAA 는 I=2일 경우 next = 10, 
            length는 12 이어서 4이됩니다. 
            즉, B를 건너지 않고 반대로 넘어가는 경우를 고려하는 것입니다. 
            여기서 문제는 우리의 시작점은 인덱스 0인것에 있습니다. 
            ==우리는 i까지 갔다가 되돌아가거나 처음부터 뒤로가서 length-next까지 갔다가 다시 돌아오는 경우를 생각해야합니다.==
            앞의 예에서는 i=2 두칸앞으로 갔다가 돌아오느냐, 처음부터 뒤로가서 length-next = 12 - 10 = 2를 고려해야하는 것입니다. 
            이 경우에는 두개가 같은 값이지만 다를 수 있어서 Math.min으로 방향을 선택해주는 것입니다
             */
        }

        return answer+min;
    }
}
