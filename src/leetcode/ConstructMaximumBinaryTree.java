package leetcode;

import java.util.Arrays;

/**
 * Created by ZhengHy on 2017-09-21.
 * 根据给出的整数数组构造一棵二叉树，数组中无重复数字
 * 要求：
 * 1. 根必须是数组或子数组中最大的数字
 * 2. 左子树是由最大的数字分割的左边的子数组组成
 * 3. 右子树是由最大的数字分割的有边的子数组组成
 * 已有结构
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 *
 * 1.先找到数组中最大的数字，分割左右子数组，构造一个节点，设置val
 * 2.对左子树应用步骤1，设为步骤1的节点的左子树
 * 3.对右子树应用步骤1，设为步骤1的节点的右子树
 */
public class ConstructMaximumBinaryTree {
    public static  TreeNode constructMaximumBinaryTree(int[] nums) {
        if( nums.length == 0){
            return null;
        }
        int maxIndex = 0;
        for(int i = 1 ; i < nums.length ; i ++){
            if(nums[maxIndex] < nums[i]){
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIndex]);

        if(maxIndex > 0){
            int[] left = Arrays.copyOfRange(nums, 0, maxIndex);
            node.left = constructMaximumBinaryTree(left);
        }else{
            node.left = null;
        }

        if(maxIndex < nums.length - 1){
            int[] right = Arrays.copyOfRange(nums, maxIndex+1, nums.length);
            node.right =  constructMaximumBinaryTree(right);
        }else{
            node.right = null;
        }

        return node;
    }


    public static void main(String[] args){
        int[] array = {3,2,1,6,0,5};
        TreeNode treeNode = constructMaximumBinaryTree(array);
        System.out.print(treeNode.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
