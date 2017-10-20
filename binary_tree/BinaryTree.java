package binary_tree;

import binary_search_tree.BinarySearchTree;


import java.util.*;
import java.util.stream.Collectors;

public class BinaryTree {
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(){
        //........
    }

    public BinaryTree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return this.data;
    }

    public void setLeft(BinaryTree left){
        this.left = left;
    }

    public void setRight(BinaryTree right){
        this.right = right;
    }

    public void inorder(BinaryTree root){
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void preorder(BinaryTree root){
        if(root != null){
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(BinaryTree root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void insert(BinaryTree root, int data){
        BinaryTree newNode = new BinaryTree(data);
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        BinaryTree temp = null;

        while(!queue.isEmpty()){
            temp = queue.remove();
            if(temp.left == null || temp.right == null){
                break;
            }
            queue.add(temp.left);
            queue.add(temp.right);
        }

        if(temp.left == null){
            temp.left = newNode;
        }else{
            temp.right = newNode;
        }
    }

    public BinaryTree insertAtSpecificPosition(BinaryTree root, int searchNode, int side, int data){
        if(root == null){
            BinaryTree node = new BinaryTree(data);
            return node;
        }
        BinaryTree temp = root;
        BinaryTree n = findNode(root, searchNode);
        if(side == 0)//left
        {
            n.left = new BinaryTree(data);
        }else{
            n.right = new BinaryTree(data);
        }
         return root;
    }

    public BinaryTree findNode(BinaryTree root, int searchNode){
        if(root != null){
            if(root.data == searchNode){
                return root;
            }
             BinaryTree left = findNode(root.left, searchNode);
             BinaryTree right = findNode(root.right, searchNode);
             return left != null ? left : right;
        }
        return null;
    }

    //preorder using stack.
    public void preorderUsingStack(BinaryTree root){
        if(root == null){
            return;
        }

        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        stack.push(root);
        while(!stack.isEmpty()){
            BinaryTree node = stack.pop();
            System.out.print(node.data + " ");
            if(node.right != null)
                stack.push(node.left);
            if(node.left != null)
                stack.push(node.right);
        }
    }

    public void inorderUsingStack(BinaryTree root){
        if(root == null){
            return;
        }

        boolean done = false;
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree currentNode = root;
        while(!done){
            if(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }else{
                if(stack.isEmpty()){
                    done = true;
                }else{
                    currentNode = stack.pop();
                    System.out.print(currentNode.data + " ");
                    currentNode = currentNode.right;
                }
            }
        }
    }

    //find max element in binary_tree.
    public int max(BinaryTree root){
        if(root == null){
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(max(root.left), max(root.right)));
    }

    //find max element in binary_tree using bfs algorithms.
    public int maxUsingBFS(BinaryTree root){
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        int max = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            BinaryTree node = queue.poll();
            max = Math.max(max, node.data);

            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return max;
    }

    // search and return node;
    public BinaryTree returnNode(BinaryTree root, int data) {
        if (root == null) {
            return null;
        }

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTree t = queue.poll();
            if(t.data == data){
                return t;
            }

            if(t.left != null){
                queue.add(t.left);
            }

            if(t.right != null){
                queue.add(t.right);
            }
        }
        return null;
    }

    //search element in binary search binary_tree.
    public boolean search(BinaryTree root, int data){
        if(root == null){
            return false;
        }

        if(root.data == data){
            return true;
        }

        return search(root.left, data) || search(root.right, data);
    }
    //search element using BFS
    public boolean searchUsingBFS(BinaryTree root, int data){
        if(root == null){
            return false;
        }

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty()){
            BinaryTree t = queue.poll();
            if(t.data == data){
                return true;
            }
            if(t.left != null)
                queue.add(t.left);

            if(t.right != null)
                queue.add(t.right);
        }
        return false;
    }

    public void delete(BinaryTree root){
        root = null;
        return;
    }

    public int size(BinaryTree root){
        if(root == null)
            return 0;

        return 1 + size(root.left) + size(root.right);
    }

    //Level order reverse..
    public void levelOrderReverse(BinaryTree root){
        if(root == null)
            return;

        Queue<BinaryTree> queue = new LinkedList<>();
        Stack<BinaryTree> stack = new Stack<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            BinaryTree t = queue.poll();
            if(t.left != null)
                queue.offer(t.left);

            if(t.right != null)
                queue.offer(t.right);

            stack.push(t);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().getData() + " ");
        }
    }

    //Height of the binary_tree.
    public int height(BinaryTree root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    //find parent of any node.
    private static BinaryTree par;
    public BinaryTree getParent(BinaryTree root,int data){
        if(parentHelper(root, data)){
            return par;
        }else{
            return null;
        }
    }

    public boolean parentHelper(BinaryTree root, int data){
        if(root == null){
            return false;
        }
        if((root.left != null && root.left.data == data) || (root.right != null && root.right.data == data)){
            par = root;
            return true;
        }
        return parentHelper(root.left, data) || parentHelper(root.right, data);
    }

    public BinaryTree leafNode(BinaryTree root){
        if(root == null){
            return null;
        }

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTree t = queue.poll();
            if(t.left == null && t.right == null){
                return t;
            }
            if(t.left != null){
                queue.add(t.left);
            }
            if(t.right != null){
                queue.add(t.right);
            }
        }
        return null;
    }

    //delete node from binary_tree.

    public boolean delete(BinaryTree root, int data){

        BinaryTree deleteNode = returnNode(root, data);
        BinaryTree leafNode = leafNode(deleteNode.left);
        BinaryTree parent = getParent(root, leafNode.data);

        deleteNode.data = leafNode.data;
        if(parent.left.data == leafNode.data){
            parent.left = null;
        }else{
            parent.right = null;
        }

        return true;
    }

    //number of leaves.
    public int noOfLeaves(BinaryTree root){
        if(root.left == null && root.right == null){
            return 1;
        }

        int left = 0, right = 0;
        if(root.left != null){
            left = noOfLeaves(root.left);
        }

        if(root.right != null){
            right = noOfLeaves(root.right);
        }

        return left + right;
    }

    public int leavesUsingBFS(BinaryTree root){
        if(root == null){
            return 0;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            BinaryTree t = queue.poll();
            if(t.left == null && t.right == null){
                count++;
            }
            if(t.left != null){
                queue.add(t.left);
            }
            if(t.right != null){
                queue.add(t.right);
            }
        }
        return count;
    }

    //No of full nodes using recursion.
    public int fullNodes(BinaryTree root){
        if(root == null){
            return 0;
        }

        int l = 0, r = 0;
        if(root.left != null && root.right != null){
            l = fullNodes(root.left);
            r = fullNodes(root.right);
            return 1 + l + r;
        }


        if(root.left != null){
            l = fullNodes(root.left);
        }

        if(root.right != null){
            r = fullNodes(root.right);
        }

        return l + r;
    }

    //No of full nodes BFS
    public int fullNodesUsingBFS(BinaryTree root){
        if(root == null)
            return 0;

        int count = 0;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTree t = queue.poll();

            if(t.left != null && t.right != null)
                count++;

            if(t.left != null)
                queue.add(t.left);

            if(t.right != null)
                queue.add(t.right);
        }
        return count;
    }

    //Diameter of Binary seach binary_tree.
    public int diameter(BinaryTree root){
        if(root == null)
            return 0;

        int rootDia = height(root.left) + height(root.right) + 1;
        int leftSubTreeDia = diameter(root.left);
        int rightSubTreeDia = diameter(root.right);

        return Math.max(rootDia, Math.max(leftSubTreeDia, rightSubTreeDia));
    }

    //find width of the binary_tree.
    public int width(BinaryTree root){
        if(root == null){
            return 0;
        }

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        int finalWidth = 0;
        int calWidth = 0;
        while(!queue.isEmpty()){
            BinaryTree t = queue.poll();
            if(t == null){
                finalWidth = Math.max(finalWidth, calWidth);
                calWidth = 0;
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                continue;
            }else{
                calWidth++;
            }

            if(t.left != null){
                queue.offer(t.left);
            }

            if(t.right != null){
                queue.offer(t.right);
            }
        }
        return finalWidth;
    }

    //find width using recursion.
    public int widthUsingRecursion(BinaryTree root){
        if(root == null)
            return 0;

        int finalWidth  = 0;
        int calWidth = 0;
        int height = root.height(root);

        for(int i = 0; i < height; i++){
            calWidth = widthUsingRecursion(root, i);
            finalWidth = Math.max(calWidth, finalWidth);
        }
        return finalWidth;
    }

    public int widthUsingRecursion(BinaryTree root, int level){
        if(root == null)
            return 0;

        if(level == 0){
            return 1;
        }
        return widthUsingRecursion(root.left, level - 1) + widthUsingRecursion(root.right, level - 1);
    }

    //two symmetric binary_tree's.
    public boolean isStructurellySame(BinaryTree root1, BinaryTree root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 != null || root2 != null){
            return false;
        }

        return isStructurellySame(root1.left, root2.right) &&
                isStructurellySame(root1.right, root2.left);
    }

    //Printf all path from root to leaf node.
    public void printPaths(BinaryTree root){
        if(root == null)
            return;

        int[] path = new int[256];
        printPaths(root, path, 0);
    }

    public void printPaths(BinaryTree root, int[] paths, int len){
        if(root == null){
            return;
        }

        paths[len++] = root.data;
        if(root.left == null && root.right == null){
            printArray(paths, len);
            System.out.println();
        }else{
            printPaths(root.left, paths, len);
            printPaths(root.right, paths, len);
        }
    }

    public void printArray(int[] paths, int length){
        for(int i = 0; i < length; i++){
            if(i < length - 1){
                System.out.print(paths[i] + ",");
            }else{
                System.out.print(paths[i]);
            }
        }
    }

    public int maxLevelSum(BinaryTree root){
        if(root == null){
            return 0;
        }
        int sum = 0;
        int calSum = 0;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            BinaryTree t = queue.poll();
            if(t != null){
                calSum += t.data;
            }else{
                sum = Math.max(sum, calSum);
                calSum = 0;

                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }
            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right != null){
                queue.offer(root.right);
            }
        }
        return sum;
    }
// has path sum
    public boolean hasPathSum(BinaryTree root, int sum){
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null && root.data == sum){
            return true;
        }

        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }

    //sum of all nodes
    public int addBinaryTree(BinaryTree root){
        if(root == null){
            return 0;
        }

        return root.data + addBinaryTree(root.left) + addBinaryTree(root.right);
    }

    //convert binary_tree into mirror image.
    public void getMirror(BinaryTree root){
        if(root == null)
            return;

        getMirror(root.left);
        getMirror(root.right);
        BinaryTree temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //print all ancestor.
    public boolean ancestors(BinaryTree root, BinaryTree node){
        if(root == null){
            return false;
        }

        if(((root.left != null) && root.left.data == node.data )|| (root.right != null && root.right.data == node.data) || ancestors(root.left, node) || ancestors(root.right, node)){
           System.out.println(root.data);
           return true;
        }

        return false;
    }

    //zig zag traversal
    public ArrayList<ArrayList<BinaryTree>> zigZag(BinaryTree root){
        if(root == null){
            return null;
        }

        ArrayList<ArrayList<BinaryTree>> result = new ArrayList<ArrayList<BinaryTree>>();
        Queue<BinaryTree> queue = new LinkedList<>();
        Stack<BinaryTree> stack = new Stack<>();
        boolean isLeftToRight = true;
        ArrayList<BinaryTree> temp = new ArrayList<BinaryTree>();

        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            BinaryTree t = queue.poll();
            if(t != null) {
                temp.add(t);
                if(t.left != null){
                    queue.add(t.left);
                }

                if(t.right != null){
                    queue.add(t.right);
                }
            }else{
                if(!queue.isEmpty())
                    queue.add(null);
                if(isLeftToRight){
                    isLeftToRight = false;
                    result.add(new ArrayList<>(temp));
                    temp.clear();
                }else{
                    isLeftToRight = true;
                    stack.addAll(temp);
                    temp.clear();
                    ArrayList<BinaryTree> arr = new ArrayList<>();
                    while(!stack.isEmpty()){
                        arr.add(stack.pop());
                    }
                    result.add(arr);
                }
            }
        }
        return result;
    }

    //vertical sum of binary binary_tree.
    public TreeMap<Integer, Integer> verticalSum(BinaryTree root){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        verticalSum(root, 0, map);
        int largestKey = map.lastKey();
        TreeMap<Integer, Integer> result = new TreeMap<>();
        for(int key : map.keySet()){
            result.put(key + largestKey + 1, map.get(key));
        }
        return result;
    }

    private void verticalSum(BinaryTree root, int col, TreeMap<Integer, Integer> map) {
        if(root == null)
            return;

        verticalSum(root.left, col - 1, map);
        verticalSum(root.right, col + 1, map);

        if(map.containsKey(col)){
            map.put(col, map.get(col) + root.data);
        }else{
            map.put(col, root.data);
        }
    }

    //Is given binary_tree isomorphic of another one or not.
    public boolean isIsomorphic(BinaryTree root1, BinaryTree root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null)
            return false;

        return (root1.data == root2.data) &&(
                (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right))
                        || (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left)));
    }

    //Print Binary Tree via List

    public List<List<String>> printTreeViaList(BinaryTree root){
        String[][] mat = printTree(root);
        List<List<String>> lists = new ArrayList<>();
        for(int i = 0; i < mat.length; i++){
            lists.add(new ArrayList<String>(Arrays.stream(mat[i]).collect(Collectors.toList())));
        }
        return lists;
    }

    public String[][] printTree(BinaryTree root){
        int rows = height(root);
        int cols = (int)(Math.pow(2, rows)) - 1;
        String[][] mat = new String[rows][cols];
        fillMatrix(mat, "\"\"");
        int rootPos = cols / 2;
        fillTreeElements(root, 0, rootPos, mat[0].length, 0, mat);
        return mat;
    }

    public static void fillTreeElements(BinaryTree root, int s, int p, int e, int l, String[][] mat){
        if(root == null || p < 0 || p >= mat[0].length){
            return;
        }

        mat[l][p] = String.valueOf(root.data);
        fillTreeElements(root.left, s, (s + p) / 2, p, l + 1, mat);
        fillTreeElements(root.right, p + 1, (p + 1 + e) / 2, e, l + 1, mat);
    }

    public static void fillMatrix(String[][] mat, String ele){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                mat[i][j] = ele;
            }
        }
    }

    static class UpdatedNode{
        public BinaryTree node;
        public int dis;
        public UpdatedNode(BinaryTree node, int dis){
            this.node = node;
            this.dis = dis;
        }
    }

    //Bottom View.
    public void bottomView(BinaryTree root)
    {
        List<List<UpdatedNode>> levels = new ArrayList<>();
        List<UpdatedNode> temp = new ArrayList<>();
        UpdatedNode node = new UpdatedNode(root, 0);
        Queue<UpdatedNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);

        while(!queue.isEmpty()){
            UpdatedNode t = queue.poll();
            if(t == null){
                levels.add(new ArrayList<>(temp));
                temp.clear();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }else{
                temp.add(t);
                if(t.node.left != null){
                    queue.add(new UpdatedNode(t.node.left, t.dis - 1));
                }

                if(t.node.right != null){
                    queue.add(new UpdatedNode(t.node.right, t.dis + 1));
                }
            }
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = levels.size() - 1; i >= 0; i--) {
            List<UpdatedNode> t = levels.get(i);
            for(UpdatedNode n : t){
                if(!map.containsKey(n.dis))
                    map.put(n.dis, n.node.data);
            }
        }
        for(int key : map.keySet()){
            System.out.print(map.get(key) + " ");
        }

    }

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int nodes = scanner.nextInt();
        BinaryTree root = null;
        for(int i = 0; i < nodes; i++){
            int searchNode = scanner.nextInt();//for first node use -1
            int side = scanner.nextInt(); // for first node side -1; left : 0 and right : 1;
            int data = scanner.nextInt();
            if(i == 0 && root == null){
                root = new BinaryTree(data);
            }else{
                root.insertAtSpecificPosition(root, searchNode, side, data);
            }
        }

        root.inorder(root);
        System.out.println();
        new BinaryTree().bottomView(root);
    }
}
