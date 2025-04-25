package Recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String[] dictionary = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        System.out.println(wordBreak(str, Arrays.asList(dictionary)));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        for(String word: wordDict){
            dict.add(word);
        }

        return helper(s, 0, dict);
    }

    public static boolean helper(String s, int start, HashSet<String> dict){
        if(start == s.length()){
            return true;
        }

        for(int i=start+1; i<=s.length(); i++){
            boolean self = dict.contains(s.substring(start, i));
            if(!self){
                continue;
            }
            boolean next = helper(s, i, dict);
            if(next){
                return true;
            }
        }

        return false;
    }
    
    
    
    
}
