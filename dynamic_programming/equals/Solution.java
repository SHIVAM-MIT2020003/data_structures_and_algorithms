package equals;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int test = kb.nextInt();
        while(test-- > 0){
            int size = kb.nextInt();
            int[] friends = new int[size];
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < friends.length; i++){
                friends[i] = kb.nextInt();
                min = Math.min(min, friends[i]);
            }
            int minOperations = Integer.MAX_VALUE;
            for(int i = min; i >= 0; i--){
                int result = 0;
                for(int j = 0; j < size; j++){
                    result += (friends[j] - i) / 5;
                    result += (friends[j] - i) % 5 / 2;
                    result += (friends[j] - i) % 5 % 2 / 1;
                }
                minOperations = Math.min(minOperations, result);
            }
            System.out.println(minOperations);
        }
    }
}