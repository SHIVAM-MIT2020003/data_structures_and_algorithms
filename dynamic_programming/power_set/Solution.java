package power_set;

import java.io.*;
import java.util.*;

public class Solution {
    private static Reader in = new Reader();
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    private static void solve() throws Exception {
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,3};
        List<HashSet<Integer>> powerSets = powerSet(arr);
        for(HashSet<Integer> set : powerSets){
            out.println(set);
        }
        out.flush();
    }

    private static List<HashSet<Integer>> powerSet(int[] arr){
        List<HashSet<Integer>> sets = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i <= arr.length; i++)
            powerSet(arr, i, sets);
        return sets;
    }

    private static void powerSet(int[] arr, int n, List<HashSet<Integer>> sets){
        if(n == 0){
            sets.add(new HashSet<>());
            return;
        }

        int size = sets.size();
        for(int i = 0; i < size; i++){
            HashSet<Integer> set = new HashSet<Integer>(sets.get(i));
            set.add(arr[n - 1]);
            sets.add(set);
        }
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