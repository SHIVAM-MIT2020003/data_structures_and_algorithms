package catalan_number;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int res = catalanNumberTD(n);
        System.out.println(res);
    }

    //recursive approach.
    public static int catalanNumber(int n){
        if(n == 0)
            return 1;

        int res = 0;
        for(int i = 1; i <= n; i++){
            res += catalanNumber(i - 1) * catalanNumber(n - i);
        }
        return res;
    }

    //top down approach
    public static int catalanNumberTD(int n){
        Map<Integer, Integer> map = new HashMap<>();
        return catalanNumberTD(n, map);
    }

    public static int catalanNumberTD(int n, Map<Integer, Integer> map){
        if(n == 0)
            return 1;

        if(map.containsKey(n))
            return map.get(n);

        int res = 0;
        for(int i = 1; i <= n; i++){
            res += catalanNumber(i - 1) * catalanNumberTD(n - i);
        }
        map.put(n, res);
        return res;
    }
}
