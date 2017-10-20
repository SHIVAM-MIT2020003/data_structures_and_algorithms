package power_set.combinatoric;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        ArrayList<ArrayList<Integer>> list = getPowerSet(nums);
        for(ArrayList<Integer> t : list){
            out.println(t);
        }
    }

    public static ArrayList<ArrayList<Integer>> getPowerSet(int[] nums){

        int max = 1 << nums.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < max; i++){
            ArrayList<Integer> subList = convertIntToSet(nums, i);
            list.add(subList);
        }

        return list;
    }

    public static ArrayList<Integer> convertIntToSet(int[] nums, int k){
        ArrayList<Integer> t = new ArrayList<>();
        int ind = 0;
        for(int i = k; i > 0; i = i >> 1){
            if((i & 1) > 0){
                t.add(nums[ind]);
            }
            ind++;
        }
        return t;
    }
}
