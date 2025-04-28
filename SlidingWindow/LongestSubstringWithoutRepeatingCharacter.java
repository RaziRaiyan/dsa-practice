package SlidingWindow;

import java.util.Arrays;

/*
    Problem Statement:
    Given a string s, find the length of the longest substring without duplicate characters

    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    Constraints:
    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
*/ 

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int n = s.length();
        int maxLen = 0;

        int[] map = new int[256];
        Arrays.fill(map, -1);

        for(int end=0; end<n; end++){
            char ch = s.charAt(end);
            if(map[ch] != -1){
                start = Math.max(start, map[ch]+1);
                // If we would have done just start = map[ch]+1
                // You would wrongly move start BACKWARD!
                // And corrupt your window!
            }
            map[ch] = end;
            maxLen = Math.max(maxLen, end-start+1);
        }

        return maxLen;
    }
}
