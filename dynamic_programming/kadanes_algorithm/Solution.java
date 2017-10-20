package kadanes_algorithm;

import java.util.Scanner;

public class Solution {
    public static void main(String[]a){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        int res = kandanesDP(arr);
        System.out.println(res);
    }

    public static int kandanesDP(int[] nums){
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for(int i = 0; i < nums.length; i++){
            maxEndingHere += nums[i];
            if(maxEndingHere < 0)
                maxEndingHere = 0;

            if(maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar == 0 ? max(nums) : maxSoFar;
    }

    public static int max(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
