package longest_palindromic_subsequence;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionDP {
    public static void main(String[]args){
        Scanner scanner =  new Scanner(System.in);
        String pat = scanner.nextLine();
        int res = DP(pat);
        System.out.println(res);
    }

    public static int DP(String p){
        HashMap<String, Integer> brain = new HashMap<>();
        return DP(p, 0, p.length() - 1, brain);
    }

    public static int DP(String pattern, int i , int j, Map<String, Integer> brain){
        if(i == j){
            return 1;
        }

        if(pattern.charAt(i) == pattern.charAt(j)){
            if(i == j - 1){
                return 2;
            }else{
                String key = (i + 1) + "=" + (j - 1);
                brain.put(key, DP(pattern, i + 1, j - 1, brain));
                return 2 + brain.get(key);
            }
        }

            int val1, val2;
            String key1 = (i + 1) + "=" + j;
            if(brain.containsKey(key1)){
                val1 = brain.get(key1);
            }else{
                brain.put(key1, DP(pattern, i + 1, j, brain));
                val1 = brain.get(key1);
            }
            String key2 = i + "=" + (j - 1);
            if(brain.containsKey(key2)){
                val2 = brain.get(key2);
            }else{
                brain.put(key2, DP(pattern, i, j - 1, brain));
                val2 = brain.get(key2);
            }
            return 2 + Math.max(val1, val2);
    }
}

