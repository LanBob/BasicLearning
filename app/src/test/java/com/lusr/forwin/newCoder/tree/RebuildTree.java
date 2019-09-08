package com.lusr.forwin.newCoder.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RebuildTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        printTree(reConstructBinaryTree(pre, in));
    }

    static void printTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print("-" + treeNode.val);
        printTree(treeNode.left);
        printTree(treeNode.right);
    }

    static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        int rootVal = pre[0];
        int i = 0;
        while (i < in.length && in[i] != rootVal) {
            ++i;
        }
        int[] leftTreeIn = new int[i];
        int[] leftTreePre = new int[i];
        int[] rightTreeIn = new int[in.length - i - 1];
        int[] rightTreePre = new int[in.length - i - 1];

        for (int j = 0; j < in.length; ++j) {
            if (j < i) {
                leftTreeIn[j] = in[j];
            } else if (j > i) {
                rightTreeIn[j - i - 1] = in[j];
            }

            if (j >= 1 && j < i + 1) {
                leftTreePre[j - 1] = pre[j];
            } else if (j >= i + 1) {
                rightTreePre[j - i - 1] = pre[j];
            }
        }

        if (leftTreePre.length > 0)
            root.left = reConstructBinaryTree(leftTreePre, leftTreeIn);
        if (rightTreeIn.length > 0)
            root.right = reConstructBinaryTree(rightTreePre, rightTreeIn);
        return root;
    }

}
