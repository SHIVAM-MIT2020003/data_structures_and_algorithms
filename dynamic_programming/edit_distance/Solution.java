package edit_distance;
import java.util.Scanner;
class Solution{
    public static void main(String[]args){

        Scanner kb = new Scanner(System.in);
        String firstString = kb.nextLine();
        String secondString = kb.nextLine();
        int res = minOperationRequired(firstString, secondString);
        System.out.println(res);
    }

    public static int minOperationRequired(String first, String second){
        int[][] table = new int[first.length() + 1][second.length() + 1];
        for(int i = 0; i <  table.length; i++)
            table[i][0] = i;
        for(int j = 0; j < table[0].length; j++)
            table[0][j] = j;

        for(int i = 1; i < table.length; i++){
            for(int j = 1; j < table[0].length; j++){
                if(first.charAt(i - 1) != second.charAt(j - 1)){
                    int min = Integer.MAX_VALUE / 2;
                    min = Math.min(Math.min(table[i][j - 1], table[i - 1][j - 1]), table[i - 1][j] );
                    table[i][j] = min + 1;
                }else{
                    table[i][j] = table[i - 1][j - 1];
                }
            }
        }
        return table[table.length - 1][table[0].length - 1];
    }
}