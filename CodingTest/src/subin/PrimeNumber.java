package subin;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class PrimeNumber {
    public static void main(String[] args) {
        String n = "17";
        System.out.println("::MAIN::");
        System.out.println(solution(n));
    }

    public static int solution(String numbers) {
        /*
        https://programmers.co.kr/learn/courses/30/lessons/42839
        numbers는 1이상 7이하인 문자열, 0~9까지의 숫자만으로 이루어짐
        return 소수 몇개를 만들 수 있는지

        - 순열과 소수를 찾는 2가지가 결합된 문제
        */

        HashSet<Integer> set = new HashSet<>();

        permutation("", numbers, set); //순열

        int answer=0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) answer++; //2는 소수
            if(a%2!=0 && isPrime(a)) answer++;
        }
        return answer;
    }

    public static boolean isPrime(int n){
        //소수인지 판별하는 메서드
        // 0 과 1 : 소수 아님 && 제곱근 값 까지만 나누어 떨어지는지 검색하면 된다. ( int sqrt = (int) Math.sqrt(n); )
        //소수의 판별 여부는 결국 약수가 있냐 없냐를 찾아보는 과정
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            //sqrt 메서드 이용
            if(n%i==0) return false;
        }
        return true;
    }

    public static void permutation(String prefix, String str, HashSet<Integer> set){
        //순열방식으로 각각의 자리를 만들기
        int n = str.length();
        //if(n==0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix)); //숫자라면, Integer로 변환해서 set에 추가

        //그 후 재귀함수 돌려서 찢은애들로 만들 수 있는 숫자 배열 만들기기
       for(int i=0; i<n; i++){
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }
    }

    //다른 순열 조합 방법
    /**
     * 순열 알고리즘
     *
     * @param arr    : 원본 리스트
     * @param result : 결과 담을 리스트
     * @param n      : 전체 갯수
     * @param r      : 선택할 갯수
     */
    private TreeSet<String> set = new TreeSet<>(); //TreeSet은 저장이 느리지만 검색이 빠르다는 장점을 가지고있다.
    private int count;

    public void permutation2(List<Character> arr, List<Character> result, int n, int r) {

        if (r == 0) {

            // 0으로 시작하는 부분집합은 제외
            if (result.get(0) != '0') {

                String str = "";
                int size = result.size();
                for (int i = 0; i < size; i++) {
                    str += result.get(i);
                }

                int num = 0;

                // 이미 나온 숫자 조합이 아닐 경우
                if (!set.contains(str)) {
                    num = Integer.parseInt(str);
                    set.add(str);

                    // 소수 판별
                    if (isPrime(num)) {
                        System.out.println(num);
                        count++;
                    }
                }
            }

            return;
        }

        for (int i = 0; i < n; i++) {

            result.add(arr.remove(i));
            permutation2(arr, result, n - 1, r - 1);
            arr.add(i, result.remove(result.size() - 1));
        }

    }

}
