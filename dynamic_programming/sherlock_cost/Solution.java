package sherlock_cost;

import java.io.*;
import java.util.*;

public class Solution {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;

    void solve() throws IOException {
        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        int dpLow = 0;
        int dpHigh = 0;

        for (int i = 1; i < n; i++) {
            int nextLow = Math.max(dpLow, dpHigh + a[i - 1] - 1);
            int nextHigh = Math.max(dpLow + a[i] - 1,
                    dpHigh + Math.abs(a[i] - a[i - 1]));
            dpLow = nextLow;
            dpHigh = nextHigh;
            System.err.println(dpLow + " " + dpHigh);
        }

        //out.println(Math.max(dpLow, dpHigh));
    }

    Solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int t = nextInt();
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }

    String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}