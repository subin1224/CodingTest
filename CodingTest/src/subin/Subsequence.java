package subin;

public class Subsequence {
    public boolean isSubsequence(String s, String t) {
        /*
        https://leetcode.com/problems/is-subsequence/
        DP문제 #Easy
        t에 s가 포함되면 true 아니라면 false 를 return
        s의 순서는 지켜져야함
        */
        int cnt=0;
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    t=t.substring(j+1);
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(t);
        return (cnt==s.length()) ? true : false;
    }
}
