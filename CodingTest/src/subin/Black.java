package subin;
import java.io.*;
import java.util.Arrays;

public class Black {
    public static void main(String[] args) throws Exception {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           String input = br.readLine();

           String[] inputArr=input.split(" ");
           int n= Integer.parseInt(inputArr[0]);
           int k= Integer.parseInt(inputArr[1]);

           //n배열
           int nArr[]=new int[n];
           for(int i=0;i<inputArr.length-2;i++){
               nArr[i]=Integer.parseInt(inputArr[i+2]);
           }
          
           //k배열
           //nArr 중 에서 k개의 배열 kArr을 뽑을거임 순서는 연속된 순서
           //가장 작은 수를 찾자
           Arrays.sort(nArr); //먼저 오름차순으로 정렬
           int a=0;
           int count=0;
           while(true){
               for(int x=a;x<k;x++){ // k=4
                   nArr[x]=nArr[a]; //nArr[3] 까지 1이 된다.
               }
               a+=k-1; // 그럼 이제 3 4 5 6
               count++;
               if(a>=n-1) break; //숫자 n의 index는 n-1
           }

           System.out.println("Hello Goorm! Your input is " + count);
       }

       /*
       1부터 N까지 정수가 한 번씩 등장하는 길이 N -> N이 4면 1 3 2 4 , 순서는 랜덤
       연속된 K개의 정수 만약 K=3 이라면 1 3 2 혹은 3 2 4
       뽑은 K개의 정수는 하나의 배열로 만들어지고 그 배열은 뽑은 숫자들 중 가장 작은수로 바뀜
       1 3 2 경우에 1 1 1, 3 2 4 경우에는 2 2 2
       그럼 맨 처음의 수열을 모두 같은 수로 만들고자 할때 최소 몇번을 골라야 하는가
       1 1 1 4 -> 1 1 4 고르면 1 1 1 1 -> 2번 나옴
       1 2 2 2 -> 1 2 2 고르면 1 1 1 1 -> 2번 나옴

       입력
       두 정수 N과 K가 차례로 주어짐 = 공백으로 구분
       두 번째 줄에는 공백으로 구분된 N개의 정수가 주어짐

       테스트
       7 3 1 8 4 6 2 5
       k가 3
       오름차순으로 정리하면 1 2 3 4 5 6 7 8 -> n배열
       a=1, k개만큼 a로 변해 1 1 1 4 5 6 7 8 = 0 1 2
       그 다음 nArr[2], nArr[3], nArr[4] 가 a로 변해
       012,234,456,678 =>4번
       만약 k가 4라면
       0123 3456 5678 => 3번
       0~k-1 , k-1~k+3,  ~n-1

       12345678
       11145678
       111 11 678
       111 11 11 8
       111 11 11 1
       */

}