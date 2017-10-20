package huffman_coding;

import sun.reflect.generics.tree.Tree;
import java.util.*;
import java.util.function.BinaryOperator;

public class Solution {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap(){
            {
                put('a', 12);
                put('b', 2);
                put('c', 7);
                put('d', 13);
                put('e', 14);
                put('f', 85);
            }
        };

        PriorityQueue<TreeNode> pq = new Solution().huffmanCoding(map);
        Map<Character, String> m = inorder(pq.poll());
        for(char key : m.keySet()){
            System.out.println(key + ":" + m.get(key));
        }
    }

    public static Map<Character, String> inorder(TreeNode root){
        HashMap<Character, String> map = new HashMap<>();
        inorder(root, map, "");
        return map;
    }

    public static void inorder(TreeNode root, HashMap<Character, String> map, String code){

        if(root == null)
            return;
        if(root != null){
            if(root.ch != '$'){
                map.put(root.ch, code);
            }

            inorder(root.left, map, code + "0");
            inorder(root.right, map, code + "1");
        }
    }

    public PriorityQueue<TreeNode> huffmanCoding(Map<Character, Integer> map){
        PriorityQueue<TreeNode> pq = new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode treeNode, TreeNode t1) {
                return treeNode.freq - t1.freq;
            }
        });

        initPriorityQueue(pq, map);
        while(pq.size() > 1){
            TreeNode temp = pq.poll();
            TreeNode temp2 = pq.poll();
            TreeNode huffmanNode = new TreeNode();
            huffmanNode.left = temp;
            huffmanNode.right = temp2;
            huffmanNode.freq = huffmanNode.left.freq + huffmanNode.right.freq;
            huffmanNode.ch = '$';
            pq.add(huffmanNode);
        }

        return pq;
    }

    public void initPriorityQueue(PriorityQueue<TreeNode> pq, Map<Character, Integer> map){
        for(char key : map.keySet()){
            pq.add(new TreeNode(key, map.get(key)));
        }
    }
}

class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public int freq;
    public char ch;
    public TreeNode(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }

    public TreeNode(){
    }

    public int getFrequency(){
        return this.freq;
    }

    public char getChar(){
        return this.ch;
    }

    public TreeNode getLeft(){
        return this.left;
    }

    public TreeNode getRight(){
        return this.right;
    }
}
