package bit_manipulation.flip_bit_to_win;

import java.util.Scanner;

public class Solution {
    public static void main(String[]ars){
        Scanner kb = new Scanner(System.in);
        int[] zeroIndex = new int[32];
        int num = kb.nextInt();
        int index = 0;
        for(int i = 0; i < 32; i++){
            if((num & (1 << i)) == 0){
                zeroIndex[index++] = i;
            }
        }

        int max = Integer.MIN_VALUE / 4;
        int i  = 1;
        while(zeroIndex[i++] != 0){
            if(i - 1 == 1){
                max = zeroIndex[1];
            }else{
                max = Math.max(max, zeroIndex[i - 1] - zeroIndex[i- 3]);
            }
        }
        System.out.println(max);
    }
}
