package bit_manipulation.odd_even_pos_bit_swap;

import java.util.Scanner;

public class Solution {
    public static void main(String[]ags){
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        int res = oddEvenSwapper(num);
        System.out.println(res);

    }

    public static int oddEvenSwapper(int num){

        for(int i = 0; i <= 16; ){
            if((num & (1 << i)) == 0 && (num & (1 << (i + 1))) == 0){
                i += 2;
                continue;
            }else if((num & (1 << i)) > 0 && (num & (1 << (i + 1))) > 0){
                i += 2;
                continue;
            }else{
                num ^= (1 << i);
                num ^= (1 << (i + 1));
                i += 2;
            }
        }
        return num;
    }
}
