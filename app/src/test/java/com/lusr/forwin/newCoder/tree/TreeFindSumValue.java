package com.lusr.forwin.newCoder.tree;

import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class TreeFindSumValue {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        preTree(root, new ArrayList(), target);
        return lists;
    }

    void preTree(TreeNode treeNode, ArrayList list, int target) {
        if (treeNode == null) {
            return;
        }

        list.add(treeNode.val);

        if (treeNode.val == target && treeNode.left == null && treeNode.right == null) {
            ArrayList<Integer> list1 = new ArrayList();
            list1.addAll(list);
            lists.add(list1);
        }

        target -= treeNode.val;
        preTree(treeNode.left, list, target);
        preTree(treeNode.right, list, target);
        list.remove(list.size() - 1);
    }
}
