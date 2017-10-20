package longest_palindromic_subsequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Set<String> flag;
    static{
        flag = new HashSet<>();
    }
    private static String result = "";
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        int res = lps(pattern);
        System.out.println(res);
        System.out.println(result);

    }

    public  static int lps(String pat){
        HashMap<String, Integer> map = new HashMap<>();
        return lps(pat, 0, pat.length() - 1, map);
    }

    public static int lps(String pat, int i, int j, HashMap<String, Integer> brain){
        String key = (i + 1) + ":" + (j - 1);
        if(i == j)
            return 1;

        if(pat.charAt(i) == pat.charAt(j)){
            String fKey = i + ":" + j;
            if(!flag.contains(fKey)){
                String leftSub = result.substring(0,result.length() / 2);
                String rightSub = result.substring(result.length() / 2);
                leftSub += pat.charAt(i);
                rightSub = pat.charAt(j) + rightSub;
                result = leftSub + rightSub;
                flag.add(fKey);
            }

            if(i + 1 == j){
                return 2;
            }else{
                int val = lps(pat, i + 1, j - 1, brain);
                brain.put(key, val);
                return 2 + brain.get(key);
            }
        }else{
            String leftKey = (i + 1) + ":" + (j);
            String rightKey = (i) + ":" + (j - 1);

            int left = Integer.MIN_VALUE / 2;
            int right = Integer.MIN_VALUE / 2;
            if(brain.containsKey(leftKey)){
                left = brain.get(leftKey);
            }else{
                left = lps(pat, i +  1, j, brain);
                brain.put(leftKey, left);
            }

            if(brain.containsKey(rightKey)){
                right = brain.get(rightKey);
            }else{
                right = lps(pat, i, j - 1, brain);
                brain.put(rightKey, right);
            }

            return Math.max(left, right);
        }
    }
}
