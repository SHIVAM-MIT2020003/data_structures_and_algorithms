package sorting.counting_sort;

import java.util.Scanner;

public class CountingSort {
    public int[] sort(int[] a){
        int len = findMax(a) + 1;
        int[] A = new int[len];
        int[] C = new int[len];

        for(int i = 0; i < a.length; i++){
            C[a[i]]++;
        }

        for(int i = 1; i < C.length; i++){
            C[i] = C[i - 1] + C[i];
        }

        for(int i = 0; i < a.length; i++){
            A[C[a[i]]] = a[i];
            C[a[i]]--;
        }
        return A;
    }

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }

        int[] res = new CountingSort().sort(a);
        for(int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");




    }


    public static int findMax(int[] a){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++){
            max = Integer.max(max, a[i]);
        }
        return max;
    }

}
