package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.

    
    Example 1:
    Input: candidates = [10,1,2,7,6,1,5], target = 8
    Output: 
    [
    [1,1,6],
    [1,2,5],
    [1,7],
    [2,6]
    ]

    Example 2:
    Input: candidates = [2,5,2,1,2], target = 5
    Output: 
    [
    [1,2,2],
    [5]
    ]
    

    Constraints:
    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    1 <= target <= 30
*/ 

public class CombinationSumII {
    
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args){
        int[] candidates = {10,1,2,7,6,1,5};
        int  target = 8;

        // Solution
        Arrays.sort(candidates);
        combination(candidates, 0, target, new ArrayList<>());
        System.out.println(ans);
    }

    public static void combination(int[] nums, int start, int target, List<Integer> res){
        if(target == 0){
            ans.add(new ArrayList<>(res));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i=start; i<nums.length; i++){
            if(i > start && nums[i-1] == nums[i]){
                continue;
            }

            if(nums[i] > target){
                break;
            }

            res.add(nums[i]);
            combination(nums, i+1, target-nums[i], res);
            res.remove(res.size()-1);
        }
    }
}
