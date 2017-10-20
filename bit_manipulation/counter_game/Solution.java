package bit_manipulation.counter_game;

import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner kb = new Scanner(System.in);
        int test = kb.nextInt();
        while(test-- > 0){
            int counter = kb.nextInt();
            int result = solve(counter);
            System.out.println(counter % 2 == 0 ? "Richard" : "Louise");
        }
    }

    public static int solve(int counter){


        int count = 0;
        while(counter > 1){
            if(!isPowerOf2(counter)){
                counter -= largestPowerOfTow(counter);
            }else{
                counter -= (counter / 2);
            }
            count++;
        }
        return count;
    }


    public static boolean isPowerOf2(int num){
        int count = 0;
        for(int i = 0; i <= 31; i++){
            if((num & (1 << i)) > 0){
                count++;
            }
        }
        return count == 1;
    }

    public static int largestPowerOfTow(int num){
        int max = Integer.MIN_VALUE / 4;
        for(int i = 0; i <= 31; i++){
            if(max < (num & (1 << i))){
                max = (num & (1 << i));
            }
        }
        return max == num ? max / 2 : max;
    }
}
