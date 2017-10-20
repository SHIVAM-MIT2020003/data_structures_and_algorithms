package heap;

public class HeapSort {
    public static void main(String[]args){
        int[] nums = {5,3,12,7,1};
        heapSort(nums);
        for(int val : nums){
            System.out.print(val + " ");
        }
    }

    public static void heapSort(int[] nums){
        buildHeap(nums);

        for(int i = nums.length - 1; i >= 0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, 0, i);
        }
    }

    public static void buildHeap(int[] nums){
        for(int i = nums.length / 2; i >= 0; i--){
            heapify(nums, i, nums.length);
        }
    }

    public static void heapify(int[] nums, int i, int heapSize){
        int l, r, largest;
        l = 2 * i;
        r = 2 * i + 1;
        if(l < heapSize && nums[l] > nums[i]){
            largest = l;
        }else{
            largest = i;
        }

        if(r < heapSize && nums[r] > nums[largest]){
            largest = r;
        }

        if(largest != i){
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            heapify(nums, largest, heapSize);
        }
    }
}
