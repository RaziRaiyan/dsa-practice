package BinarySearch.Hard;

import java.util.Arrays;

/*
    Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
    Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
    If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

    Return the minimum integer k such that she can eat all the bananas within h hours.

    Example 1:
    Input: piles = [3,6,7,11], h = 8
    Output: 4

    Example 2:
    Input: piles = [30,11,23,4,20], h = 5
    Output: 30

    Example 3:
    Input: piles = [30,11,23,4,20], h = 6
    Output: 23
    

    Constraints:
    1 <= piles.length <= 104
    piles.length <= h <= 109
    1 <= piles[i] <= 109
*/ 

public class KokoEatingBanana {
    public static void main(String[] args){
        int[] piles = {3,6,7,11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for(int i=0; i<piles.length; i++){
            max = Math.max(piles[i], max);
        }

        int low = 1, high = max;
        int ans = max;

        while(low <= high){
            int mid = low + (high - low)/2;
            boolean finish = canFinish(piles, mid, h);

            if(finish){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    public static boolean canFinish(int[] nums, int k, int h){
        int totalHours = 0;
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        for(int i=0; i<numsCopy.length; i++){
            int currTime = (int)Math.ceil(((double)numsCopy[i])/k);
            totalHours += currTime;
        }
        return totalHours <= h;
    }
}
