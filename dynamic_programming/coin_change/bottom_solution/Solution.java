package coin_change.bottom_solution;
import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    static long countWays(int S[], int m, int n)//m = coinsCount n = money
    {
        long[] table = new long[n+1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];

        return table[n];
    }

    public static void main(String args[])
    {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();//money
        int t = kb.nextInt();//coins
        int[] coins = new int[t];
        for(int i = 0; i < t; i++)
            coins[i] = kb.nextInt();
        long res = countWays(coins, t, n);
        System.out.println(res);
    }
}
