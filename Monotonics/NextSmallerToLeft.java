package Monotonics;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextSmallerToLeft {
    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 0, 2, 4};
        System.out.println(Arrays.toString(nextSmallerToLeft(nums)));
    }

    public static int[] nextSmallerToLeft(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];

        Deque<Integer> deque = new LinkedList<>();

        for(int i=0; i<n; i++){
            while(!deque.isEmpty() && deque.peekLast() >= nums[i]){
                deque.pollLast();
            }

            ans[i] = deque.isEmpty() ? -1 : deque.peekLast();

            deque.offerLast(nums[i]);
        }


        return ans;
    }
}
