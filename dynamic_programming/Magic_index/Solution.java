package Magic_index;

public class Solution {
    public static void main(String[]args){
        int[] a = {-1,-5,0,2,4,8,9};
        int ind = magicIndex(a);
        System.out.println(ind);
    }

    public static int magicIndex(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            mid = (left + right)/ 2;
            if(nums[mid] == mid){
                return mid;
            }else if(nums[mid] < mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
