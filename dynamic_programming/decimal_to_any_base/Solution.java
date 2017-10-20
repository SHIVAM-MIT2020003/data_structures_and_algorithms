package decimal_to_any_base;

import java.util.Scanner;

public class Solution {
    static String pat = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int base = scanner.nextInt();

        String result = converter(num, base);
        System.out.println(result);
    }

    public static String converter(int num, int base){
        if(num / base == 0){
            return pat.charAt(num % base) + "";
        }

        return converter(num / base, base) + pat.charAt(num % base) ;
    }
}
