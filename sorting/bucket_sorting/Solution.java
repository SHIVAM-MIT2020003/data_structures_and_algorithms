package sorting.bucket_sorting;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double[] arr = new double[n];
        for(int i = 0 ; i < n; i++){;
            arr[i] = Double.parseDouble(scanner.nextLine());
        }
        sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static double[] sort(double[] a){
        TreeMap<Integer, TreeSet<Double>> map = new TreeMap<>();
        double max = max(a);
        int size = ((int)max / 5) * 5 + 5;
        for(int i = 0; i < size; i++){
            map.put(i, new TreeSet<>());
        }

        for(int i = 0; i< a.length; i++){
            TreeSet<Double> s = map.get((((int)a[i]) / 5) * 5);
            s.add(a[i]);
        }

        double[] arr = new double[size];

        int i = 0;
        for(int key : map.keySet()){
            TreeSet<Double> set = map.get(key);
            for(double val : set){
                arr[i++] = val;
            }
        }
        return arr;
    }

    public static double max(double[] a){
        double max = -1;
        for(int i = 0; i< a.length; i++){
            max = Double.max(max, a[i]);
        }
        return max;
    }
}
