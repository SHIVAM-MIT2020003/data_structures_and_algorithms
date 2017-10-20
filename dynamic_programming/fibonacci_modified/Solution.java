package fibonacci_modified;

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    public static int t1, t2;
    public static int n;
    public static BigInteger[] bigInts;
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        t1 = kb.nextInt();
        t2 = kb.nextInt();
        n = kb.nextInt();
        bigInts = new BigInteger[n + 1];

        BigInteger result = fibo(n);
        System.out.println(result);
    }

    public static BigInteger fibo(int n){
        if(n == 1)
            return new BigInteger(t1 + "");
        else if(n == 2)
            return new BigInteger(t2 + "");
        else
            bigInts[n] = fibo(n - 2).add(square(fibo(n - 1)));

        return bigInts[n];

    }

    public static BigInteger square(BigInteger num){
        BigInteger temp = new BigInteger(num.toString());
        temp = temp.multiply(num);
        return temp;
    }
}