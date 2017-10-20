package coin_change;

import java.io.*;
import java.util.*;

public class Solution {

    public static long possibleCombination(int money, int[] coins){
        return possibleCombination(money, coins, 0, memory);
    }

    private static Map<String, Long> memory = new HashMap<>();
    private static long possibleCombination(int money, int[] coins, int index, Map<String, Long> memory){
        if(money == 0){
            return 1;
        }

        if(index >= coins.length){
            return 0;
        }

        String key = money + "=" + index;
        if(memory.containsKey(key)){
            return memory.get(key);
        }


        int remainingMoney = 0; long ways = 0;
        while(remainingMoney <= money){
            int remain = money - remainingMoney;
            ways += possibleCombination(remain, coins, index + 1, memory);
            remainingMoney += coins[index];
        }
        memory.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int money = kb.nextInt();
        int coin = kb.nextInt();
        int[] coins = new int[coin];
        for(int i = 0; i < coin; i++){
            coins[i] = kb.nextInt();
        }
        long ways = possibleCombination(money, coins);
        System.out.println(ways);
    }

}