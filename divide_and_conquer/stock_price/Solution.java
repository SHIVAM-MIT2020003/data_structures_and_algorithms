package stock_price;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int days = kb.nextInt();
        int[] price = new int[days];
        for(int i = 0; i < price.length; i++){
            price[i] = kb.nextInt();
        }
        List<Interval> res = new Solution().buySellStock(price);
        if(res.isEmpty()){
            System.out.println("Stock empty");
        }else{
            for(Interval interval : res){
                System.out.println("buy " + interval.buy + " sell " + interval.sell);
            }
        }
    }

    static class Interval{
        int buy, sell;
    }

    public List<Interval> buySellStock(int[] price){
        if(price.length == 0){
            return null;
        }
        int n = price.length;
        int i = 0;
        List<Interval> list = new ArrayList<>();
        while(i < n - 1){
            Interval interval = new Interval();
            //buy
            while(i < n - 1 && price[i + 1] <= price[i])
                i++;

            if(i == n - 1)
                break;

            interval.buy = i++;
            //sell

            while(i < n && price[i] >= price[i - 1])
                i++;
            interval.sell = i - 1;
            list.add(interval);
        }
        return list;
    }
}
