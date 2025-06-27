package Monotonics;

import java.util.Deque;
import java.util.LinkedList;

/*
    Given an integer array nums and an integer k, return the maximum sum of a non-empty 
    subsequence of that array such that for every two consecutive integers in the subsequence,
    nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.

    A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array,
    leaving the remaining elements in their original order.

    Example 1:
    Input: nums = [10,2,-10,5,20], k = 2
    Output: 37
    Explanation: The subsequence is [10, 2, 5, 20].

    Example 2:
    Input: nums = [-1,-2,-3], k = 1
    Output: -1
    Explanation: The subsequence must be non-empty, so we choose the largest number.

    Example 3:
    Input: nums = [10,-2,-10,-5,20], k = 2
    Output: 23
    Explanation: The subsequence is [10, -2, -5, 20].

    Intuition
    1. When you see subsequence you might directly jump for a recursion + memoization solution and you might try to find out the decisions that you have to make
    2. But the approach for this is slightly twisted here 
    3. Think of this - [16, -13, -5, -10, 4, 3, 9] 
    3.1. To make our subsequence sum max, you would want to take as many positive number as possible
    3.2. And in the process we would not want to include any negative numbers
    3.3. But, the catch is - you can only exclude upto k last negative numbers - so which negative in the last last k integers you include to maintain the condition?
    3.4. -- Answer is whichever is giving you max sum in the last k elements
    4. Anything clicked? - Let me explain
    4.1. You've to basically maintain a running max sum - where runningMaxSum[i] = nums[i] + runningMaxSum[j], for all j in [i-k, i-1]
    4.2. Okay the above solution TC is O(N*K)
    4.3. Can we do better? - What are we doing when we are traversing j? We are looking for max running sum, for all j in [i-k, i-1]
    4.4. Is there a better way to find out running sum max in the last [i-k, i-1] ? Yes there is - We can do by maintaining a descending monotonic deque
    5. But why this would be better? - We will still need to process the deque to maintain monotonocity, right? - Because it will be much less processing than k elements
    5.1. So the TC for monotonic deque solution would be O(N*⍺), where ⍺ << k, so we can evaluate TC to be O(N)
    5.2. If you've not done any monotonics problem I would highly recommend to solve https://leetcode.com/problems/sliding-window-maximum/ first
    6. Coming back to Monotonics solution.
    6.1. Approach would be maintain a decreasing monotonic deque for quick running sum max lookup, 
    6.2. Before lookup we have to make sure that if the max value has went out of K size window we need to remove it first.
    6.3. We get the running sum max from our decreasing monotonic deque, calculate the ans
    6.4. Then we will try to put our current running sum into monotonic deque, for this we need to maintain monotonocity - !deque.isEmpty() && deque.peekLast().maxSum < current
    6.5. After maintaining the monotonocity, we will add current running sum max to the deque.
    6.5. Whoalla!! We did it

*/

public class ConstrainedSubsequenceSum {
    static class Pair{
        int index, runningMaxSum;
        public Pair(int maxSum, int index){
            this.index = index;
            this.runningMaxSum = maxSum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {16, -13, -5, -10, 4, 3, 9};
        int k = 2;
        System.out.println(constrainedSubsequenceSum(nums, k));
    }

    public static int constrainedSubsequenceSum(int[] nums, int k){
        int ans = nums[0];
        int n = nums.length;
        // int[] runningMaxSum = new int[n];

        // for(int i=0; i<n; i++){
        //     runningMaxSum[i] = nums[i];

        //     for(int j=i-1; j>=Math.max(0, i-k); j--){
        //         runningMaxSum[i] = Math.max(runningMaxSum[i], nums[i]+runningMaxSum[j]);
        //     }

        //     ans = Math.max(runningMaxSum[i], ans);
        // }

        Deque<Pair> deque = new LinkedList<>();
        deque.offerLast(new Pair(nums[0], 0));

        for(int i=1; i<n; i++){
            if(!deque.isEmpty() && deque.peekFirst().index < (i-k)){
                deque.pollFirst();
            }

            int currentRunningSum = nums[i];
            if(!deque.isEmpty() && deque.peekFirst().runningMaxSum > 0){
                currentRunningSum += deque.peekFirst().runningMaxSum;
            }
            ans = Math.max(ans, currentRunningSum);

            while (!deque.isEmpty() && deque.peekLast().runningMaxSum < currentRunningSum) {
                deque.pollLast();
            }
            deque.offerLast(new Pair(currentRunningSum, i));
        }

        return ans;

    }
}
