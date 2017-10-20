package maximum_subarray;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int cases = kb.nextInt();
        for(int i = 0; i <  cases; i++){
            int size = kb.nextInt();
            int[] arr = new int[size];
            for(int j = 0; j < arr.length; j++){
                arr[j] = kb.nextInt();
            }
            int maxContiguous = maxSubArrContiguous(arr);
            int maxNonContigous = maxNonContiguous(arr);

            System.out.println(maxContiguous + " " + maxNonContigous);
        }
    }

    private static int maxNonContiguous(int[] nums){
        int maxAns = 0;
        boolean isPositive = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                maxAns += nums[i];
                isPositive = true;
            }
        }
        if(!isPositive){
            int maxV = nums[0];
            for(int i = 1; i < nums.length; i++){
                if(maxV < nums[i]){
                    maxV = nums[i];
                }
            }
            return maxV;
        }
        return maxAns;
    }

    private static int maxSubArrContiguous(int[] nums){
        int maxEnd = nums[0], maxAns = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxEnd = Math.max(maxEnd + nums[i], nums[i]);
            maxAns = Math.max(maxEnd, maxAns);
        }
        return maxAns;
    }

    private static int maxOf(int a, int b, int c){
        return Math.max(Math.max(a, b), c);
    }
    private static int minOf(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
    }
}