package segment_tree;

import java.util.Scanner;

public class SegmentTree {
    int[] nodes;
    public SegmentTree(int[] nums){
        int h = (int) Math.ceil(Math.log(nums.length) / Math.log(2));
        int nodeCount = (int)(2 * Math.pow(2, h) - 1);
        nodes = new int[nodeCount];
        constructSegmentTree(nums);
    }

    public int getSum(int len, int s, int e){
        return getSumUtil(0, len - 1, s, e, 0);
    }

    public int getSumUtil(int ss, int se, int qs, int qe, int si){
        if(qs <= ss && qe >= se){
            return nodes[si];
        }

        if(se < qs || ss > qe)
            return 0;

        int mid = getMidValue(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    public void printSegmentTree(){
        for(int i = 0; i < nodes.length; i++){
            System.out.print(nodes[i] + " ");
        }
    }

    public void constructSegmentTree(int[] nums){
        constructSegmentTree(nums, 0, nums.length - 1, 0);
    }

    public int constructSegmentTree(int[] nums, int s, int e, int treeIndex){
        if(s == e){
            nodes[treeIndex] = nums[s];
            return nodes[treeIndex];
        }

        int mid = getMidValue(s, e);
        nodes[treeIndex] = constructSegmentTree(nums, s, mid, treeIndex * 2 + 1) +
                constructSegmentTree(nums, mid + 1, e, treeIndex * 2 + 2);

        return nodes[treeIndex];
    }

    public int getMidValue(int s, int e){
        int mid = s + (e - s) / 2;
        return mid;
    }

    void updateValueUtil(int ss, int se, int i, int diff, int si)
    {
        if (i < ss || i > se)
            return;

        nodes[si] = nodes[si] + diff;
        if (se != ss) {
            int mid = getMidValue(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    void updateValue(int arr[], int n, int i, int newVal)
    {
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }

        int diff = newVal - arr[i];
        arr[i] = newVal;
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    public static void main(String[]args){
        int[] nums = {1, 3, 5, 7, 9, 11};;
        SegmentTree segmentTree = new SegmentTree(nums);
        System.out.println(segmentTree.getSum(6, 3, 3));
    }
}
