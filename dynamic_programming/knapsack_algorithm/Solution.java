package knapsack_algorithm;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[]args){
        Scanner kb = new Scanner(System.in);
        int items  = kb.nextInt();
        int[] weight = new int[items];
        int[] values = new int[items];
        TreeMap<Integer, Integer> unitPrice = new TreeMap<>();

        for(int i = 0; i < items; i++){
            weight[i] = kb.nextInt();
            values[i] = kb.nextInt();
            unitPrice.put(values[i] / weight[i], weight[i]);
        }

        System.out.println("enter the knapsack size: ");
        int sackSize = kb.nextInt();
        System.out.println(unitPrice);

        double totalPrice = 0.0;

        NavigableMap<Integer, Integer> map = unitPrice.descendingMap();
        for(int key : map.keySet()){
            int value = map.get(key);
            if(sackSize >= value){
                sackSize -= value;
                totalPrice += key * value;
            }else{
                totalPrice += sackSize * key;
                break;
            }
        }
        System.out.println("Total amount: " + totalPrice);
    }
}
