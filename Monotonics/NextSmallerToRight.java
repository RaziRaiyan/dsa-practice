package Monotonics;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextSmallerToRight {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nextSmallerToRight(nums)));
    }

    public static int[] nextSmallerToRight(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];

        Deque<Integer> deque = new LinkedList<>();

        for(int i=n-1; i>=0; i--){
            while(!deque.isEmpty() && deque.peekLast() >= nums[i]){
                deque.pollLast();
            }

            ans[i] = deque.isEmpty() ? -1 : deque.peekLast();

            deque.offerLast(nums[i]);
        }

        return ans;
    }
}
