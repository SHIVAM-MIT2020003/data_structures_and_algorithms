package sorting.sell_sort;
import java.util.Scanner;
public class SellSort {

    public void sort(int[] nums){
        for(int gap = nums.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < nums.length; i++){
                int key = nums[i];
                int j = 0;
                for(j = i; j >= gap && nums[j - gap] > key; j -= gap){
                    nums[j] = nums[j - gap];
                }
                nums[j] = key;
            }
        }
    }

    public static void main(String[]ags){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        new SellSort().sort(nums);
        for(int i = 0; i < n; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
