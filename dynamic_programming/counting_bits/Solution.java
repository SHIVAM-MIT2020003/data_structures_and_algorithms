package counting_bits;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] res = countBits(n);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }


    public static int[] countBits(int num){
        if(num == 0){
            return new int[]{0};
        }

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[num + 1];
        for(int i = 0; i <= num; i++){
            res[i] = findBits(i, map);
            map.put(i, res[i]);
        }
        return res;
    }

    //my solution.
    public static int findBits(int n, Map<Integer, Integer> map){
        if(n == 0){
            return 0;
        }
        if(map.containsKey(n))
            return map.get(n);

        return (n % 2) + findBits(n / 2, map);
    }
}

