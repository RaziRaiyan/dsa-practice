package SlidingWindow;

/*
    Problem Statement
    Given a string s, return the length of the longest substring that contains at most two distinct characters.

    Example 1:
    Input: s = "eceba"
    Output: 3
    Explanation: The substring is "ece" which its length is 3.

    Example 2:
    Input: s = "ccaabbb"
    Output: 5
    Explanation: The substring is "aabbb" which its length is 5.
*/ 

public class LongestSubstringAtMost2DistnictCharacters {
    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int maxLen = 0;
        char char1 = '_';
        char char2 = '_';
        int freq1 = 0;
        int freq2 = 0;
        int n = s.length();

        for(int right=0; right<n; right++){
            char c = s.charAt(right);
            if (c == char1) {
                freq1++;
            } else if (c == char2) {
                freq2++;
            } else if (freq1 == 0) {
                char1 = c;
                freq1 = 1;
            } else if (freq2 == 0) {
                char2 = c;
                freq2 = 1;
            }else{
                while(freq1 > 0 && freq2 > 0){
                    if(char1 == s.charAt(left)){
                        freq1--;
                    }
                    else if(char2 == s.charAt(left)){
                        freq2--;
                    }
                    left++;
                }

                if(freq1 == 0){
                    char1 = s.charAt(right);
                    freq1 = 1;
                }else if(freq2 == 0){
                    char2 = s.charAt(right);
                    freq2 = 1;
                }
            }
            
            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
