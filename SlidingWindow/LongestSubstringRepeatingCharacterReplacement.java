package SlidingWindow;
/*
    You are given a string s and an integer k. 
    You can choose any character of the string and change it to any other uppercase English character. 
    You can perform this operation at most k times.
    Return the length of the longest substring containing the same letter you can get after performing the above operations.

    Example 1:
    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.
    
    Example 2:
    Input: s = "AABABBA", k = 1
    Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.
    There may exists other ways to achieve this answer too.

    Constraints:
    1 <= s.length <= 105
    s consists of only uppercase English letters.
    0 <= k <= s.length
*/ 

public class LongestSubstringRepeatingCharacterReplacement {
    public static void main(String[] args) {
        // long string test case
        String s = "ABAB";
        int k = 2;
        System.out.println(longestSubstringRepeatingCharacterReplacement(s, k));
        
    }

    /*
        Intuition:
        1. Maintain a window.
        2. On each iteration expand the window to the right by one element and increment the frequency counter.
        3. We want to know how many characters can be replaced to maintain the condition. For this since we have now just added an element to frequency counter. Get the maxCount from the frequency map.
        4. If the window size minus maxCount is greater than k, then this means the window is not valid and we need to shrink the window. Keep shrinking the window until the condition becomes valid once again.
        5. Once all the operation are done, we are sure that the window is valid, update the maxLen.
    */ 
    public static int longestSubstringRepeatingCharacterReplacement(String s, int k) {
        int left = 0;
        int n = s.length();
        int maxLen = 0;
        int maxCount = 0;

        int[] map = new int[26];

        for(int right=0; right<n; right++){
            map[s.charAt(right)-'A'] += 1;

            maxCount = Math.max(maxCount, map[s.charAt(right)-'A']);

            while((right - left+1)-maxCount > k){
                map[s.charAt(left)-'A'] -= 1;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
