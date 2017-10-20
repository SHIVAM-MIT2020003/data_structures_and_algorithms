package bit_manipulation.flip_bit;

import java.util.Scanner;
public class Solution {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        int res = requiredFlip(from, to);
        System.out.println(res);
    }

    public static int requiredFlip(int from, int to){
        int count = 0;
        for(int i = 0; i < 31; i++){
            if((from & (1 << i)) != (to & (1 << i))){
                count++;
            }
        }
        return count;
    }
}
