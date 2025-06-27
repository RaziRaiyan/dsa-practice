package Monotonics;

import java.util.Deque;
import java.util.LinkedList;

/* Maximum Number of Robots Within Budget */
/* You have n robots. You are given two 0-indexed integer arrays, chargeTimes and runningCosts, 
    both of length n. The ith robot costs chargeTimes[i] units to charge and costs runningCosts[i] units to run.
    You are also given an integer budget.

    The total cost of running k chosen robots is equal to max(chargeTimes) + k * sum(runningCosts),
    where max(chargeTimes) is the largest charge cost among the k robots and sum(runningCosts) is the sum of running costs among the k robots.

    Return the maximum number of consecutive robots you can run such that the total cost does not exceed budget.


    Example 1:
    Input: chargeTimes = [3,6,1,3,4], runningCosts = [2,1,3,4,5], budget = 25
    Output: 3
    Explanation: 
    It is possible to run all individual and consecutive pairs of robots within budget.
    To obtain answer 3, consider the first 3 robots. The total cost will be max(3,6,1) + 3 * sum(2,1,3) = 6 + 3 * 6 = 24 which is less than 25.
    It can be shown that it is not possible to run more than 3 consecutive robots within budget, so we return 3.

##  Intuition:
    It is clearly given in the question that we need to include as many robot as we can till the condition satisfies.
    What's the condition? - max(chargeTimes) + k * sum(runningCosts) < budget

    So we need to find a subarray or a window in the numbers given where the condition satisfies.
    And we have to maintain 2 things for a given window - 1. max of the window of chargeTimes, 2. sum of the window of runningCosts

    1. Max of the window of chargeTimes can be managed by using a monotonically decreasing deque
    2. Sum of the window of runningCosts can be managed by using a prefix sum of runningCosts

    Once we have these, we will try to expand our window one element at a time, In the process we will do two things
    1. Make sure we are adding element to our monotonically decreasing deque from right end
    2. Then we have to make sure that the given condition is being satisfied - if not we will try to remove element from right side of our window

    Once the above two operations are done, that means our window is now valid. We will now get the maxLength or maxNumber of robots: (right - left + 1)
*/

public class MaxRobotsWithinBudget {

    class Pair {
        int index, maxSum;
        public Pair(int index, int maxSum){
            this.index = index;
            this.maxSum = maxSum;
        }
    }

    public static void main(String[] args) {
        int[] chargeTimes = {3,6,1,3,4};
        int[] runningCosts = {2,1,3,4,5};
        int budget = 25;

        System.out.println(maxRobotsWithinBudget(chargeTimes, runningCosts, budget));
    }

    public static int maxRobotsWithinBudget(int[] chargeTimes, int[] runningCosts, int budget){
        int n = chargeTimes.length;
        long[] prefixSum = new long[n+1];
        for(int i=1; i<=n; i++){
            prefixSum[i] = prefixSum[i-1] + runningCosts[i-1];
        }

        Deque<Integer> maxDeque = new LinkedList<>();

        int maxRobots = 0; 

        int left = 0;

        for(int right=0; right<n; right++){
            while(!maxDeque.isEmpty() && maxDeque.peekLast() < chargeTimes[right]){
                maxDeque.pollLast();
            }
            maxDeque.offerLast(chargeTimes[right]);

            while(!maxDeque.isEmpty() && (maxDeque.peekFirst() + (right-left+1)*(prefixSum[right+1] - prefixSum[left])) > budget){
                if(maxDeque.peekFirst() == chargeTimes[left]){
                    maxDeque.pollFirst();
                }
                left++;
            }

            maxRobots = Math.max(maxRobots, right-left+1);
        }

        return maxRobots;
    }
}
