package bit_manipulation;

public class Solution {


    public static void main(String[]args){
        int val = 4;
        System.out.println(get(val, 2));
        System.out.println(set(val, 3));
    }

    public static int updateBit(int num, int i){
        int value = isBit1(num, i) ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }

    public static boolean isBit1(int num, int i){
        return (num & (1 << i)) != 0;
    }

    public static int clearBit(int num, int i){
        int mask = ~(1 << i);
        return num & mask;
    }

    public static int clearRightBits(int num, int i){
        int mask = -1 << (i + 1);
        return num & mask;
    }

    public static int clearLeftBits(int num, int i){
        int mask = (1 << i) - 1;
        return num & mask;
    }

    public static boolean get(int num, int i){
        return ((num & (1 << i)) != 0);
    }

    public static int set(int num, int i){
        return (num | (1 << i));
    }


}
