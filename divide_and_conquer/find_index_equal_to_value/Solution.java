package find_index_equal_to_value;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = kb.nextInt();
        }

        System.out.println(find(arr));
    }


    public static int find(int[] arr){
        int l = 0;
        int r = arr.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(arr[mid] == mid){
                return mid;
            }else if(arr[mid] < mid){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }
}


