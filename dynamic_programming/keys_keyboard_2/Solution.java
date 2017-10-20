package keys_keyboard_2;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int res = new Solution().minSteps(n);
        System.out.println(res);

    }

    public int minSteps(int n){
        if(n == 0 || n == 1)
            return 0;

        return 1 + minSteps(n - 1, 1);
    }

    public int minSteps(int n, int copyChar){
        if(n == 0 || n == 1)
            return 0;

        if(copyChar > n){
            return Integer.MAX_VALUE / 2;
        }

        if(n < 0)
            return Integer.MAX_VALUE / 2;


        return 1 + Math.min(minSteps(n, copyChar + 1),
                minSteps(n - 1, copyChar));
    }

}
