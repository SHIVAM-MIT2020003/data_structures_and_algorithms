package abbreviation;

import java.util.*;
public class Solution {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int test = Integer.parseInt(scanner.nextLine());
        while(test--  > 0){
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            boolean isYes = solve(a, b);
            if(isYes)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    public static boolean solve(String a, String b){
        return solve(a, b, 0, 0);
    }

    public static boolean solve(String a, String b, int aS, int bS){
        String key = aS + ":" + bS;

        if(a.length() == aS && b.length() == bS){
            return true;
        }

        if(a.length() == aS || b.length() == bS){
            if(a.length() == aS){
                return false;
            }else if(b.length() == bS && isAllInSmallLetter(a, aS)){
                return true;
            }else{
                return false;
            }
        }

        for(int i = aS; i < a.length(); i++){

            if((a.charAt(i) == b.charAt(bS) || (a.charAt(i) - b.charAt(bS)) == 32) && solve(a, b, i + 1, bS + 1)){
                return true;
            }else if(Character.isUpperCase(a.charAt(i))){
                return false;
            }
        }
        return false;
    }

    public static boolean isAllInSmallLetter(String a, int indx){
        for(int i = indx; i < a.length(); i++){
            if(Character.isUpperCase(a.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
