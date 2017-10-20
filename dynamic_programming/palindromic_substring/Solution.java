package palindromic_substring;

import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println(extendedPalindromic(kb.nextLine()));
    }

    static int count = 0;
    public static int extendedPalindromic(String str){
        if(str == null || str.length() == 0)
            return count;

        for(int i = 0; i < str.length(); i++){
            countPalindrome(str, i, i); //odd.
            countPalindrome(str, i, i + 1); //even.
        }

        return count;
    }

    public static void countPalindrome(String str, int l, int r){
        while(l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)){
            count++;
            l--;
            r++;
        }
    }
}
