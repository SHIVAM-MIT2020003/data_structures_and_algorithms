package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProblem {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList(){
            {
                offer(1);
                offer(2);
                offer(3);
                offer(4);
                offer(5);
                offer(6);
                offer(7);
                offer(8);
            }
        };

        /*
        reverseQueue(queue);
        while(!queue.isEmpty()){
            System.out.print(queue.remove() + " ");
        }
        */
        reverseKelements(queue, 3);
        while(!queue.isEmpty()){
            System.out.print(queue.remove() + " ");
        }

    }

    public static void reverseKelements(Queue<Integer> queue, int k){
        if(k < 0 || k == 0){
            throw new IllegalArgumentException("check value of k");
        }


        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < k; i++){
            stack.push(queue.remove());
        }

        while(!stack.isEmpty()){
            queue.offer(stack.pop());
        }

        for(int i = 0; i < queue.size() - k; i++){
            queue.offer(queue.remove());
        }
    }

    public static void reverseQueue(Queue<Integer> queue){
        Stack<Integer> s = new Stack<Integer>();
        while(!queue.isEmpty()){
            s.push(queue.remove());
        }
        while(!s.isEmpty()){
            queue.offer(s.pop());
        }
    }
}
