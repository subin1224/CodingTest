package subin;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        System.out.println("MAIN :::: " + isHappy(n)); //true
    }

    public static boolean isHappy(int n) {
        /*
        https://leetcode.com/problems/happy-number/
        각 자리의 숫자들을 제곱해서 더한다 < 반복
        1이 나오면 true 그게 아니라면 false
        */
        int x = n;
        int y = n;
        while(x>1){
            x = cycle(x) ;
            if(x==1) return true ;
            y = cycle(cycle(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }

    public static int cycle(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }
}
