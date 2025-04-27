package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/*
    Problem Statement:
    You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
    You can only see the k numbers in the window. Each time the sliding window moves right by one position.
    Return the max sliding window.

    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    Output: [3,3,5,5,6,7]
    Explanation: 
    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
    1 [3  -1  -3] 5  3  6  7       3
    1  3 [-1  -3  5] 3  6  7       5
    1  3  -1 [-3  5  3] 6  7       5
    1  3  -1  -3 [5  3  6] 7       6
    1  3  -1  -3  5 [3  6  7]      7

    Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    1 <= k <= nums.length
*/ 

public class MaximumSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(maxSlidingWindow(nums, k));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int n = nums.length;
        int[] ans = new int[n-k+1];

        // Deque will store indices to quickly check if the max element in the deque is outside of current window, if so we will remove it.
        // Before pushing element into deque we will push it from back side, so that all useless smaller elements are removed ans current element is placed at correct position
        Deque<Integer> deque = new LinkedList<>();

        for(int end=0; end<k; end++){
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[end]){
                deque.pollLast();
            }
            deque.offerLast(end); // storing indices
        }
        ans[0] = nums[deque.peek()];


        for(int end=k; end<n; end++){
            start++;
            while(!deque.isEmpty() && deque.peek() < start){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[end]){
                deque.pollLast();
            }
            deque.offerLast(end); // storing indices

            ans[end-k+1] = nums[deque.peek()];
        }

        return ans;
    }
}
