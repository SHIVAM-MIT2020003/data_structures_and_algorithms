package Sum_of_all_substrings_of_a_number;

import java.io.*;
import java.util.*;

public class Solution {
    private static Reader in = new Reader();
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static void solve() throws Exception {
        int t = in.nextInt();
        while(t-- > 0){
            String pat = in.nextLine();
            int[][] dp = new int[pat.length()][pat.length()];
            for(int i = 0; i < dp.length; i++){
                dp[i][i] = Integer.parseInt(pat.charAt(i) + "");
            }


            for(int len = 2; len <= pat.length(); len++){
                for(int i =  0; i < dp.length - len + 1;  i++){
                    int j = i + len - 1;
                    int k = len / 2;
                    dp[i][j] = dp[i][j - k] + dp[j - k + 1][j];
                }
            }

            int res = 0;
            for(int i = 0; i < dp.length;  i++){
                for(int j = i; j < dp.length; j++){
                    res += dp[i][j];
                }
            }
            printMatrix(dp);
            out.println(res);
        }
    }

    public static void printMatrix(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                out.print(mat[i][j] + " ");
            }
            out.println("");
        }
    }

    public static void main(String[] args) throws Exception {
        solve();
        out.flush();
    }


    public static int pow(int n, int a){
        return new Double(Math.pow(n, a)).intValue();
    }

    private static class Reader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        Reader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = new StringTokenizer("");
        }

        String nextLine() throws IOException{
            return reader.readLine();
        }

        String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException{
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException{
            return Double.parseDouble(next());
        }
    }
}