package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
public class Solution {
    public static void main(String[] args) {
        String str = "2*3+3-2";
        System.out.println(infixEvalution(str));
    }
    static Map<Character, Character> map = new HashMap(){
        {
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }
    };

    //valid parenthesis check
    public boolean isValidParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i)) && stack.pop() != map.get(str.charAt(i))){
                return false;
            }else if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{'){
                stack.push(str.charAt(i));
            }
        }
        return true;
    }

    //Infix to postfix conversion.
    public static Map<Character, Integer> priorityTable = new HashMap(){
        {
            put('+', 1);
            put('-', 1);
            put('*', 2);
            put('/', 2);
            put('^', 3);
            put('(', Integer.MAX_VALUE);
        }
    };

    public static String infixToPostfix(String str){
        if(str == null)
            return "";

        String res = "";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(!priorityTable.containsKey(str.charAt(i))){
                res += str.charAt(i);
            }else if(!stack.isEmpty() && priorityTable.get(stack.peek()) < priorityTable.get(str.charAt(i))){
                stack.push(str.charAt(i));
            }else if(stack.isEmpty()) {
                stack.push(str.charAt(i));
            }else if(!stack.isEmpty() && priorityTable.get(stack.peek()) >= priorityTable.get(str.charAt(i))){
                res += stack.pop();
                stack.push(str.charAt(i));
            }else if(str.charAt(i) == ')'){
                while(!stack.isEmpty()){
                    char ch = stack.pop();
                    if(ch == ')'){
                        break;
                    }else{
                        res += ch;
                    }
                }
            }
        }

        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    //postfix evalutation
    interface Operation{
        int performOperation(int a, int b);
    }

    static Map<Character, Operation> operatorHandler = new HashMap(){
        {
            put('+', new Operation(){
                public int performOperation(int a, int b){
                    return a + b;
                }
            });

            put('-', new Operation(){
                public int performOperation(int a, int b){
                    return a - b;
                }
            });

            put('*', new Operation(){
                public int performOperation(int a, int b){
                    return a * b;
                }
            });

            put('/', new Operation(){
                public int performOperation(int a, int b){
                    return a / b;
                }
            });
        }
    };

    public static int postfixEvalution(String str){
        if(str == null || str.length() == 0)
            return -1;
        Stack<Integer> stack = new Stack<>();
      for(int i = 0; i < str.length(); i++){
        if(operatorHandler.containsKey(str.charAt(i))){
            Operation op = operatorHandler.get(str.charAt(i));
            int b = stack.pop();
            int a = stack.pop();
            stack.push(op.performOperation(a, b));
        }else{
            stack.push(Integer.parseInt(str.charAt(i) + ""));
        }
      }
      return stack.pop();
    }

    //infix evaluation.
    public static int infixEvalution(String str){
        if(str == null || str.length() == 0)
            return -1;

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(!operatorHandler.containsKey(str.charAt(i))){
                numStack.push(Integer.parseInt(str.charAt(i) + ""));
            }else if(opStack.isEmpty()){
                opStack.push(str.charAt(i));
            }else if(priorityTable.get(opStack.peek()) < priorityTable.get(str.charAt(i))){
                opStack.push(str.charAt(i));
            }else if(priorityTable.get(opStack.peek()) >= priorityTable.get(str.charAt(i))){
                char op = opStack.pop();
                opStack.push(str.charAt(i));

                int b = numStack.pop();
                int a = numStack.pop();
                numStack.push(operatorHandler.get(op).performOperation(a, b));
            }
        }

        while(!opStack.isEmpty()){
            int b = numStack.pop();
            int a = numStack.pop();
            numStack.push(operatorHandler.get(opStack.pop()).performOperation(a, b));
        }

        return numStack.pop();
    }
}
