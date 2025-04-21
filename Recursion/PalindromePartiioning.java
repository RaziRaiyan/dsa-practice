package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
    Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
    
    Example 1:
    Input: s = "aab"
    Output: [["a","a","b"],["aa","b"]]

    Example 2:
    Input: s = "a"
    Output: [["a"]]

    Example 3:
    Input: s = "aabb"
    Output: [["a","a","b", "b"],["aa","b", "b"], ["aa", "bb"], ["a", "a", "bb"]]
    

    Constraints:
    1 <= s.length <= 16
    s contains only lowercase English letters.
*/ 

public class PalindromePartiioning {
    public static List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        helper(s, 0, new ArrayList<>());
        return ans;
    }

    public static void helper(String s, int start, List<String> res){
        if(start == s.length()){
            // We have reached the end that means, we must have checked for all the partitions and got till the end
            // So let's add whatever substring we have collected till now to our ans
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i=start; i<s.length(); i++){
            if(isPalindromicSubstring(s, start, i)){
                // We got that from `start` to `i` - it is a palindromic substring, so let's add it to our res and check for rest of the substring next
                res.add(s.substring(start, i+1));
                helper(s, i+1, res);
                // There are chances that we can get a substring larger than start - i, so let's remove the last added substring and look for a larger substring
                res.remove(res.size()-1);
            }
        }
    }

    public static boolean isPalindromicSubstring(String s, int start, int end){
        while (start < end) {
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

}
