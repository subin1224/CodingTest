package subin;

import java.util.ArrayList;
import java.util.List;

public class Partition_labels {

	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		List<Integer> list = partitionLabels(s);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static List<Integer> partitionLabels(String S) {
        /*
        https://leetcode.com/problems/partition-labels/
        String s = "ababcbacadefegdehijhklij";
        a b a b c b a c a   ~ 9
        8 5 8 5 7 5 8 7 8	a=8
        
        d e  f  e  g d e   ~ 7
        14 15 11 15 13 14 15	a=15
        
        h  i  j  h  k  l  i j  ~ 8
        19 22 23 19 20 21 22 23	a=23
        
        S는 1~500, a ~ z까지 소문자, 최대한 많은 파트로 쪼개야함
        */
		int[] index = new int[26];
		for(int i=0; i<S.length(); i++) {
			index[S.charAt(i)-'a']=i; //a-z 마지막 index 몇인지 저장
		}
		
		List<Integer> list = new ArrayList<Integer>();
		int a = 0;
		int b = 0;
		
		for(int i=0; i<S.length();i++) {
			a = Integer.max(index[S.charAt(i)-'a'], a);
			if(i == a) {
				//list.add(a); 8 15 23
				list.add(a - b + 1);
				b=a+1;
			}
		}
		
		return list;
		
    }
}
