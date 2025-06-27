package Monotonics;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeNumberInWindow {
    public static void main(String[] args) {
        int[] nums = {12, -1, -7, 8, 15, 30, 16, 28};
        int k = 3;
        System.out.println(Arrays.toString(firstNegativeNumberInWindow(nums, k)));
    }

    public static int[] firstNegativeNumberInWindow(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[n-k+1];

        Deque<Integer> deque = new LinkedList<>();

        int end = 0;
        for(; end<k; end++){
            if(nums[end] < 0){
                deque.offerLast(end); // store indices not value so that we can pop out those elements which goes out of window
            }
        }
        ans[0] = deque.isEmpty() ? 0 : nums[deque.peek()];

        int start = 0;
        for(end=k; end<n; end++){
            start++;
            while (!deque.isEmpty() && deque.peek() < start) {
                deque.pollFirst();
            }

            ans[end-k+1] = deque.isEmpty() ? 0: nums[deque.peek()]; 

            if(nums[end] < 0){
                deque.offerLast(end);
            }
        }


        return ans;
    }
}
