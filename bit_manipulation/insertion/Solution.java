package bit_manipulation.insertion;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int M = kb.nextInt();
        int N = kb.nextInt();

        int j = kb.nextInt();
        int i = kb.nextInt();

        M = M << j;
        N = N | M;
        System.out.println(N);
    }
}
