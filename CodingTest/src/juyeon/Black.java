package juyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class Black {

    public static void main(String[] args) throws IOException {
        // write your code here
        // 1 ~ N 까지의 정수가 한번씩 등장하는 길이 N의 수열
        // 이 수열을 모두 같은 수로 변경 ( 가장 작은 수 )
        // 기준점은 K

        /*
            입력 형식 ( N, K )
            - N은 수열의 길이를 나타내는 2 이상 10만 이하의 자연수
            - K는 한 번에 연속적으로 골라야 하는 정수의 개수를 나타내는 2 이상 N 이하의 자연수
        */

        /*
            출력 형식
            - 주어진 수열을 모두 같은 수로 만들고자 할 때 골라야 하는 최소 횟수를 출력
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String List = br.readLine();
        String[] inputList = input.split(" ");
        String[] originList = List.split(" ");
        int N = Integer.parseInt(inputList[0]);
        int K = Integer.parseInt(inputList[1]);
        int[] numList = new int[N];

        /* 해당 수열을 int 배열로 변경 */
        for ( int i = 0; i < originList.length ; i++ ){
            numList[i] = Integer.parseInt(originList[i]);
        }

        // 오름차순으로 배열 변경
        Arrays.sort(numList);
        int change = 0;
        int i = 0;
        while (i < N-1) {
            for (int a = i; a < (Math.min(i + K, N)); a++ ) {
                numList[a] = numList[i];
            }
            change++;
            i += K-1;
        }
        // 1 2 3 4 5
        // 1 1 1 4 5
        // 1 1 1 1 1


        /* Debugger */
        for ( int num : numList ) {
            System.out.print(num);
        }
        /* change 횟수 */
        System.out.print(change);

    }
}
