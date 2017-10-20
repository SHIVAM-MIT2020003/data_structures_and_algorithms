package find_length;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$'};
        int len = findLength(nums);
        System.out.println(len);
    }

    public static int findLength(int[] arr){
        int mid = 0;
        int l , r;
        l = r = 1;
        while(arr[r] != '$'){
            l = r;
            r = 2 * r;
        }

        while(l < r){
            mid = (r - l) / 2 + 1;
            if(arr[mid] == '$'){
                r = mid;
            }else{
                l = mid;
            }
        }
        return r;
    }
}
