package SlidingWindow;

import java.util.HashMap;

/*
    Given two strings s and t of lengths m and n respectively,
    return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
    If there is no such substring, return the empty string "".
    The testcases will be generated such that the answer is unique.

    Example:
    Input: s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"
    Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
*/ 

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowSubstring(s, t));
    }

    static String minimumWindowSubstring(String s, String t){
        int minLength = s.length()+1;
        String ans = "";
        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0)+1);
        }

        int formed = 0;
        int left = 0;
        int required = targetMap.size();
        for(int right=0; right<s.length(); right++){
            windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0)+1);

            if(windowMap.get(s.charAt(right)) == targetMap.get(s.charAt(right))){
                formed++; // found one more character
            }

            while(formed == required){
                if(minLength > (right-left+1)){
                    minLength = right-left+1;
                    ans = s.substring(left, right+1);
                }

                windowMap.put(s.charAt(left), windowMap.getOrDefault(s.charAt(left), 0)-1);

                if(windowMap.getOrDefault(s.charAt(left), 0) < targetMap.getOrDefault(s.charAt(left), 0)){
                    formed--;
                }

                left++;
            }
        }

        return ans;
    }
}
