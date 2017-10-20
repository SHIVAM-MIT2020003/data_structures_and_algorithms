package bit_manipulation.binary_to_string;


import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        String pattern = "0.";
        double fraction = num - (int)num;
        int count = 30;
        String fractionPart = "";
        String result = "";
        while(count-- > 0){
            fraction = 2 * fraction;
            int real = (int)fraction;
            fractionPart = real + fractionPart;
            if(count == 0 && fraction != 0){
                result = "Error";
            }
            fraction = fraction - (int)fraction;
        }

        result = result.equals("Error") ? "Error" : pattern + fractionPart;
        System.out.println(result);

    }
}
