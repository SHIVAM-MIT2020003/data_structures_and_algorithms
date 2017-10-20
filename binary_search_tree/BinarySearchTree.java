package binary_search_tree;


import java.util.*;

public class BinarySearchTree {
    public Node root = null;
    public BinarySearchTree() {
    }
    public BinarySearchTree(int firstNode) {
        root = new Node(firstNode);
    }

    public Node root() {
        return root;
    }
    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insert(int val) {
        Node next = new Node(val);
        Node y = null;
        Node x = this.root;
        while (x != null) {
            y = x;
            if (next.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        if (y == null) {
            root = next;
            next.parent = null;
        } else if (next.key < y.key) {
            next.parent = y;
            y.left = next;

        } else {
            next.parent = y;
            y.right = next;
        }
    }

    public void insert(Node next) {
        Node y = null;
        Node x = this.root;
        while (x != null) {
            y = x;
            if (next.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        if (y == null) {
            root = next;
            next.parent = null;
        } else if (next.key < y.key) {
            next.parent = y;
            y.left = next;

        } else {
            next.parent = y;
            y.right = next;
        }
    }

    public void insert(Node root, Node next) {
        Node y = null;
        Node x = root;
        while (x != null) {
            y = x;
            if (next.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        if (y == null) {
            root = next;
            next.parent = null;
        } else if (next.key < y.key) {
            next.parent = y;
            y.left = next;

        } else {
            next.parent = y;
            y.right = next;
        }
    }

    public void insert(Node root, int val) {
        Node next = new Node(val);
        Node y = null;
        Node x = root;
        while (x != null) {
            y = x;
            if (next.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        if (y == null) {
            root = next;
            next.parent = null;
        } else if (next.key < y.key) {
            next.parent = y;
            y.left = next;

        } else {
            next.parent = y;
            y.right = next;
        }
    }

    /*
     //Time Complexity O(n^2)
     //Check whether binary binary_tree is valid or not.
     public static boolean isValidBST(Node root){
     if(root == null) return true;
     else return isLessThan(root.left, root.key) &&
     isGreaterThan(root.right, root.key) &&
     isValidBST(root.left) &&
     isValidBST(root.right);
     }
     */
    //successor of root;
    public Node Successor() {
        return maxNode(this.root.right);
    }

    public Node successor(Node root) {
        return maxNode(root.right);
    }

    public Node maxNode() {
        Node y = null;
        Node x = root;
        while (x != null) {
            y = x;
            x = x.right;
        }
        return y;
    }

    public Node maxNode(Node root) {
        Node y = null;
        Node x = root;

        while (x != null) {
            y = x;
            x = x.right;
        }
        return y;
    }

    public Node minNode() {
        Node y = null;
        Node x = root;

        while (x != null) {
            y = x;
            x = x.left;
        }
        return y;
    }

    public Node minNode(Node root) {
        Node y = null;
        Node x = root;

        while (x != null) {
            y = x;
            x = x.left;
        }
        return y;
    }

    private boolean isLessThan(Node left, int val) {
        if (left == null) {
            return true;
        } else {
            return left.key < val && isLessThan(left.left, val) && isLessThan(left.right, val);
        }
    }

    private boolean isGreaterThan(Node right, int val) {
        if (right == null) {
            return true;
        } else {
            return right.key > val && isGreaterThan(right.left, val) && isGreaterThan(right.right, val);
        }
    }

    //Time Complexity O(n)
    //Optimal way to check Time complexity O(n) and space complexity O(logn);
    private boolean isValidBST(Node root) {
        if (root == null) {
            return true;
        } else {
            return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    private boolean isValidBST() {
        if (root == null) {
            return true;
        } else {
            return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    private boolean isValid(Node root, int low, int high) {
        if (root == null) {
            return true;
        } else {
            return root.key > low && root.key < high && isValid(root.left, low, root.key) && isValid(root.right, root.key, high);
        }
    }

    //inorder traversal.
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public void inorder() {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public void preorder(){
        if(root != null){
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void preorder(Node root){
        if(root != null){
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    public void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    //find depth of binary_tree.   height = depth - 1
    public int maxDepthOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepthOfTree(root.left), maxDepthOfTree(root.right)) + 1;
    }

    public int maxDepthOfTree() {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepthOfTree(root.left), maxDepthOfTree(root.right)) + 1;
    }

    /*
     //depth first search.
     public static int minDepthOfTree2(Node root){
     if(root == null) return 0;
     if(root.left == null) return minDepthOfTree2(root.right);
     if(root.right == null) return minDepthOfTree2(root.left);
     return Math.min(minDepthOfTree(root.left),minDepthOfTree(root.right))+1;
     }
     */
    public int minDepth(Node root) {
        if (root == null) {
            return 0; //For empty binary_tree height and depth is 0;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        Node rightMost = root;
        int minDepth = 1;
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            if (node.left == null && node.right == null) {
                break;
            }
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
            if (node == rightMost) {
                minDepth++;
                rightMost = root.right != null ? root.right : root.left;
            }
        }
        return minDepth;
    }

    public int minDepth() {
        if (root == null) {
            return 0; //For empty binary_tree height and depth is 0;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        Node rightMost = root;
        int minDepth = 1;
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            if (node.left == null && node.right == null) {
                break;
            }
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
            if (node == rightMost) {
                minDepth++;
                rightMost = root.right != null ? root.right : root.left;
            }
        }
        return minDepth;
    }

    public boolean isBalance(Node root) {
        if (root == null) {
            return true;
        }

        return Math.abs(maxDepthOfTree(root.left) - maxDepthOfTree(root.right)) <= 1
                && isBalance(root.left)
                && isBalance(root.right);
    }

    public boolean isBalance() {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepthOfTree(root.left) - maxDepthOfTree(root.right)) <= 1
                && isBalance(root.left)
                && isBalance(root.right);
    }

    //convert array to balanced search binary_tree.
    public Node sortedArrayToBBST(int[] nums) {
        return sortedArrayToBBST(nums, 0, nums.length - 1);
    }

    private Node sortedArrayToBBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(nums[mid]);
        node.left = sortedArrayToBBST(nums, start, mid - 1);
        node.right = sortedArrayToBBST(nums, mid + 1, end);
        return node;
    }

    private ListNode list;
    //Linkedlist to balanced binary binary_tree.
    public Node sortedLinkedListToBST(ListNode root) {
        ListNode temp = root;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        list = root;
        return sortedLinkedListToBST(0, length - 1);
        //throw new IllegalArgumentException();
    }

    public Node kthSmallestElement(Node root, int k){
        return kthSmallestElement(root, 0, k);
    }
    public Node kthSmallestElement(Node root, int count, int k){
        if(root == null)
            return null;

        Node left = kthSmallestElement(root.left, count, k);
        if(left != null) {
            return left;
        }

        if(++count == k){
            return root;
        }

        return kthSmallestElement(root.right, count, k);
    }

    private Node sortedLinkedListToBST(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node leftChild = sortedLinkedListToBST(start, mid - 1);
        Node parent = new Node(list.val);
        parent.left = leftChild;
        list = list.next;
        parent.right = sortedLinkedListToBST(mid + 1, end);
        return parent;
    }

    public static void main(String[] args) {
        BinarySearchTree root = null;
        Scanner kb = new Scanner(System.in);
        int nodeCount = kb.nextInt();
        for(int i = 0; i < nodeCount; i++){
            if(i == 0){
                root = new BinarySearchTree(kb.nextInt());
            }else{
                root.insert(kb.nextInt());
            }
        }

        Node kthsmall = root.kthSmallestElement(root.root, 4);
        System.out.println(kthsmall.key);
    }
}

class Node {

    int key;
    Node left;
    Node right;
    Node parent;

    public Node() {
    }

    public Node(int key) {
        this.key = key;
    }
}

class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

