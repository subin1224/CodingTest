package subin;

import java.util.*;

public class MostCommonWord {
    public static void main(String[] args) {
        String p = "a, a, a, a, b,b,b,c, c";
        String[] b = {"a"};
        System.out.println("MAIN:::::::::" + mostCommonWord(p, b));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        /*
        https://leetcode.com/problems/most-common-word/
        Easy

        result => 15ms , 48.67%
        */
        paragraph = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();

        String str = "";
        if(banned.length!=0){
            for(int i=0; i<banned.length;i++){
                paragraph = paragraph.replace(banned[i], "").replace("  ", " ");
            }

            String[] answer = paragraph.split(" ");

            int max = 0;
            for(int i=0; i<answer.length; i++){
                int cnt=0;
                for(int j=0; j<answer.length; j++){
                    if(answer[j].equals(answer[i])) cnt++;
                }
                if(cnt>=max && !answer[i].equals("")){
                    max=cnt;
                    str=answer[i];
                }
            }

        }else{
            String[] answer = paragraph.split(" ");
            int max = 0;
            for(int i=0; i<answer.length; i++){
                int cnt=0;
                for(int j=0; j<answer.length; j++){
                    if(answer[j].equals(answer[i])) cnt++;
                }
                if(cnt>=max && !answer[i].equals(" ")){
                    max=cnt;
                    str=answer[i];
                }
            }
        }

        return str;
    }

    //다른사람 풀이 .. 난 Map 안쓰고 풀음 ㅇ,ㅇ
    public String mostCommonWord2(String paragraph, String[] banned) {

        // 1). replace the punctuations with spaces,
        // and put all letters in lower case
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        String[] words = normalizedStr.split("\\s+");

        Set<String> bannedWords = new HashSet();
        for (String word : banned)
            bannedWords.add(word);

        Map<String, Integer> wordCount = new HashMap<>();
        // 3). count the appearance of each word, excluding the banned words
        for (String word : words) {
            if (!bannedWords.contains(word))
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 4). return the word with the highest frequency
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}