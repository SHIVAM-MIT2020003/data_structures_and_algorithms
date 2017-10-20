package range_sum_query;

public class Solution {
    public static void main(String[] args) {

    }

    private int[] nums;
    public Solution(int[] nums){
        this.nums = nums;
    }

    public int sumRange(int i, int j){
        //cummulative array size always greater than actual size by 1.
        // cumm[k] = { summation(i->0 to i-> k - 1)nums k >
        //              0 : k == 0
        // }
        //
        int[] cummulativeSum = new int[this.nums.length + 1];
        for(int k = 0; k < this.nums.length; k++){
            cummulativeSum[k + 1] = cummulativeSum[k] + nums[k];
        }

        return cummulativeSum[j + 1] - cummulativeSum[i];
    }
}
