package bit_manipulation.next_number;
import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int bits = (int)(Math.ceil(Math.log(num) / Math.log(2)));
        if(num == Math.pow(2, bits)){
            bits++;
        }
        int countOnes = oneCount(num);

        int largest = 0;
        int smallest = 0;
        for(int i = 0,large = bits, small = 0; i < countOnes; i++){
            int maskLarge = 1 << --large;
            int maskSmall = 1 << small++;

            largest = largest | maskLarge;
            smallest = smallest | maskSmall;
        }

        System.out.println("smallest Number: " + smallest);
        System.out.println("largest Number: " + largest);
    }

    public static int oneCount(int num){
        int count = 0;
        int offset = 1;
        for(int i = 0; i <= 30; i++){
            if((num & (1 << i)) != 0){
                count++;
            }
        }
        return count;
    }

}
