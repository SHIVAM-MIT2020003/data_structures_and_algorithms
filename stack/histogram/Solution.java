package stack.histogram;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] height = new int[n];
        for(int i = 0; i < n; i++){
            height[i] = kb.nextInt();
        }

        int area = maxArea(height);
        System.out.println(area);
    }

    public static int maxArea(int[] height){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while(i < height.length){
            if(stack.isEmpty() || height[stack.peek()] <= height[i]){
                stack.push(i++);
            }else{
                int top = stack.pop();
                maxArea = Math.max(maxArea, height[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        while(!stack.isEmpty()){
            int top = stack.pop();
            maxArea = Math.max(maxArea, height[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }

        return maxArea;
    }
}
