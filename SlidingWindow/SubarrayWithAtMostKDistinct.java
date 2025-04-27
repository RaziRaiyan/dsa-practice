package SlidingWindow;

import java.util.HashMap;

/*
    Problem Statement: Longest subarray with At Most K Distinct Elements
    Example: s = [1, 2, 1, 2, 3], k = 2
    Output: 4

    Same problem on String
    Problem Statement: Longest substring with At Most K Distinct Characters
    Example: s = eceba, k = 2
    Output: 3
*/ 

public class SubarrayWithAtMostKDistinct {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarrayWithAtMostKDistinct(nums, k));

        String s = "eceba";
        System.out.println(substringWithAtMostKDistinct(s, k));
    }

    static int subarrayWithAtMostKDistinct(int[] nums, int k){
        int start = 0;
        int n = nums.length;
        int maxLen = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int end=0; end<n; end++){
            freq.put(nums[end], freq.getOrDefault(nums[end], 0)+1);
            
            while(freq.size() > k){
                freq.put(nums[start], freq.get(nums[start])-1);
                if(freq.get(nums[start]) == 0){
                    freq.remove(nums[start]);
                    start++;
                }
            }

            maxLen = Math.max(maxLen, end-start+1);
        }

        return maxLen;
    }

    static int substringWithAtMostKDistinct(String s, int k){
        int start = 0;
        int n = s.length();
        int maxLen = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        for(int end=0; end<n; end++){
            freq.put(s.charAt(end), freq.getOrDefault(s.charAt(end), 0)+1);
            
            while(freq.size() > k){
                freq.put(s.charAt(start), freq.get(s.charAt(start))-1);
                if(freq.get(s.charAt(start)) == 0){
                    freq.remove(s.charAt(start));
                    start++;
                }
            }

            maxLen = Math.max(maxLen, end-start+1);
        }

        return maxLen;
    }
    
    
}
