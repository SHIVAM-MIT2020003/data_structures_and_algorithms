package bit_manipulation.counter_game;


import java.math.BigInteger;
import java.util.Scanner;

public class OptimalSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numOfTestCases = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numOfTestCases; i++) {
            BigInteger n = new BigInteger(in.nextLine());
            System.out.println(largestTwoIndex(n) % 2 == 0 ? "Richard" : "Louise");
        }
    }

    private static long largestTwoIndex(BigInteger n) {
        String binaries = n.toString(2);
        boolean findOne = false;
        int count = 0;
        for (int i = binaries.length() - 1; i >= 0; i--) {
            if (findOne)
                if (binaries.charAt(i) == '1')
                    count++;
            else
                if (binaries.charAt(i) == '0')
                    count++;
                else {
                    findOne = true;
                }
        }
        return count;
    }

}