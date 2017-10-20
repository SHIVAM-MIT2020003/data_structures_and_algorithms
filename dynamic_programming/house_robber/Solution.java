package house_robber;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] houses = {1,2,3,4,1};
        int res = new Solution().rob(houses);
        System.out.println(res);
    }

    public int rob(int[] nums){
        Map<Integer, Integer> brain = new HashMap<>();
        return rob(nums, 0, brain);
    }


    public int rob(int[] nums, int from, Map<Integer, Integer> memo){
        if(memo.containsKey(from))
            return memo.get(from);

        if(from >= nums.length)
            return 0;

        int max = Integer.MIN_VALUE;

        max = Math.max(max, nums[from] + rob(nums, from + 2, memo));

        if(from + 1 < nums.length)
            max = Math.max(max, nums[from + 1] + rob(nums, from + 3, memo));

        memo.put(from, max);
        return max;
    }
}
