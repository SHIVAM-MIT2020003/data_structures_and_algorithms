package bit_manipulation.xor_sequence;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            long L = in.nextLong();
            long R = in.nextLong();
            long result = 0;
            long diff = R - L + 1;
            long quo = diff / 4;
            long rem = diff % 4;

            if((quo) > 1 && (rem == 0)){
                if((quo - 1) / 2 == 0){
                    result = 0;
                }else{
                    result = 2;
                }
            }else if(quo != 1 && rem != 0){
                if(quo / 2 == 0){
                    result = 0;
                }else{
                    result = 2;
                }
            }else{
                result = 0;
            }



            boolean isDone = false;
            for(long i = L + 1; i % 4 <= 3 && !isDone; i++){
                if(i % 4 == 0){
                    result ^= 0;
                }else if(i % 4 == 1){
                    result ^= (4 * (i / 4));
                }else if(i % 4 == 2){
                    result ^= 1;
                }else{
                    isDone = true;
                    result ^= (3 + (i / 4) * 4);
                }
            }

            isDone = false;
            for(long i = R + 1; i % 4 >= 0 && !isDone; i--){
                if(i % 4 == 0){
                    isDone = true;
                    result ^= 0;
                }else if(i % 4 == 1){
                    result ^= (4 * (i / 4));
                }else if(i % 4 == 2){
                    result ^= 1;
                }else{
                    result ^= (3 + (i / 4) * 4);
                }
            }

            System.out.println(result);

        }
    }
}
