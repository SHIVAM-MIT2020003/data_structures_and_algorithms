package kingdom_division;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner sc = new Scanner(System.in);
    static PrintWriter writer = new PrintWriter(System.out);
    static int MOD = 1_000_000_007;

    public static void main(String[] args) {
        int N = sc.nextInt();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            int U = sc.nextInt() - 1;
            int V = sc.nextInt() - 1;
            g.get(U).add(V);
            g.get(V).add(U);
        }
        int[] order = new int[N];
        int[] parent = new int[N];
        Arrays.fill(parent, -1);
        order[0] = 0;
        int pos = 1;
        for (int i = 0; i < N; i++) {
            int cur = order[i];
            for (int next : g.get(cur)) {
                if (parent[cur] == next) continue;
                order[pos++] = next;
                parent[next] = cur;
            }
        }
        long[][] dp = new long[2][N];
        for (int i = N - 1; i >= 0; i--) {
            int cur = order[i];
            long m0 = 1;
            long m1 = 1;
            for (int c : g.get(cur)) {
                if (c == parent[cur]) continue;
                m0 *= (dp[0][c] * 2 + dp[1][c]);
                m0 %= MOD;
                m1 *= dp[0][c];
                m1 %= MOD;
            }
            dp[0][cur] = (m0 - m1 + MOD) % MOD;
            dp[1][cur] = m1;
        }
        writer.println(dp[0][0] * 2 % MOD);
        writer.flush();
    }
}