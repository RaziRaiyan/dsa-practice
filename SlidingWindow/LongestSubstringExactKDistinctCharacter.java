package SlidingWindow;

import java.util.HashMap;

/*
    Problem Statement: Longest Substring with Exactly K Distinct Characters
    
    Given a string s and an integer k,
    find the length of the longest substring that contains exactly `k distinct characters**.

    Example:
    s = "aaabbcc", k = 2
    Output: 5
*/ 

public class LongestSubstringExactKDistinctCharacter {
    public static void main(String[] args) {
        String s = "aaabbcc";
        int k = 2;
        System.out.println(longestSubstringExactKDistinctCharacter(s, k));
    }

    static int longestSubstringExactKDistinctCharacter(String s, int k){
        int n = s.length();
        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        for(int right=0; right<n; right++){
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0)+1);

            while (freq.size() > k) {
                freq.put(s.charAt(left), freq.getOrDefault(s.charAt(left), 0)-1);

                if(freq.get(s.charAt(left)) == 0){
                    freq.remove(s.charAt(left));
                }

                left++;
            }

            if(freq.size() == k){
                maxLen = Math.max(maxLen, right-left+1);
            }
        }

        return maxLen;
    }
}
