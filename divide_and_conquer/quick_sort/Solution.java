package quick_sort;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1000,1,3,2,6,15,9,100};
        quickSort(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void quickSort(int [] arr){
        quickSort(arr, 0, arr.length - 1);
    }
    public static void quickSort(int[] arr, int s, int e){
        if(s < e){
            int part = partition(arr, s, e);
            quickSort(arr, s, part - 1);
            quickSort(arr, part + 1, e);

        }
    }

    public static int partition(int[] arr, int s, int e){
        int pivot = arr[e];
        int lm = 0;
        for(int i = 0; i < e; i++){
            if(arr[i] <= pivot){
                swap(arr, lm, i);
                lm++;
            }
        }
        swap(arr, lm, e);
        return lm;
    }

    static Set<Integer> set = new HashSet<>();
    public static void randomizedPartition(int[] arr, int s, int e){
        int rand = -1;
        while(set.contains(rand = ThreadLocalRandom.current().nextInt(s, e + 1)));
        swap(arr, s, rand);
        partition(arr, s, e);
    }
}
