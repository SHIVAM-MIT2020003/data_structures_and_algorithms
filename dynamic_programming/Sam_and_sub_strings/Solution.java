package Sam_and_sub_strings;

import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner scanner  = new Scanner(System.in);
        String num = scanner.nextLine();
        long result = solve(num, num.length());
        System.out.println(result);
    }

    public static long solve(String pat, int n){

        char[] digits = pat.toCharArray();
        long MOD7 = 1000000007;
        long temp = (int)pat.charAt(0);
        long result = temp;

        for(int i = 1; i < n; i++){
            temp =  10 * temp + (i + 1) * (digits[i] - '0');
            temp = result % MOD7;
            result = (result + temp) % MOD7;
        }
        return result;
    }

    public static int solve(String pat, int len, int offset){
        int result = 0;
        if(len == 0)
            return 0;

        for(int i = 0; i < len; i++){
            result += Integer.parseInt(pat.substring(i, i + offset));
        }

        return (result + solve(pat, len - 1, offset + 1)) % ((int)Math.pow(10, 9) + 7);
    }
}
