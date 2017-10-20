package bit_manipulation.cipher;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine());
        int len = Integer.parseInt(stringTokenizer.nextToken());
        int key = Integer.parseInt(stringTokenizer.nextToken());
        StringBuffer stringBuffer = new StringBuffer(scanner.nextLine());

        String dat = stringBuffer.reverse().toString();
        String decodedMessage = "";
        try{
            decodedMessage = decodeMessage(dat, len, key);
            System.out.println(decodedMessage);
        }catch(Exception e){}

    }

    public static String decodeMessage(String message, int len, int key)throws Exception{
        int tempKey = key;
        String mes = "";
        for(int i = 0; i < len; i++){
            if(i == 0){
                mes = message.charAt(0) + "";
                tempKey--;
            }else if(tempKey > 0){
                mes = (Integer.parseInt(message.charAt(i - 1) + "", 2) ^ Integer.parseInt(message.charAt(i) + "", 2)) + mes;
                tempKey--;
            }else{
                mes = (Integer.parseInt(performXor(mes.substring(0, key - 1)) + "", 2) ^ Integer.parseInt(message.charAt(i) + "", 2)) + mes;

            }
        }
        return mes;
    }

    public static int performXor(String pat){
        int res = 0;
        for(int i = 0; i < pat.length(); i++){
            res ^= Integer.parseInt(pat.charAt(i) + "");
        }
        return res;
    }
}
