package stack.sort_stack;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack(){
            {
                push(4);
                push(2);
                push(1);
                push(3);
            }
        };

        stack = sortStack(stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static Stack<Integer> sortStack(Stack<Integer> stack){
        Stack<Integer> sortedStack = new Stack<Integer>();

        while(!stack.isEmpty()){
            int temp = stack.pop();
            while(!sortedStack.isEmpty() && sortedStack.peek() > temp){
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        return sortedStack;
    }
}
