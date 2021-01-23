/*
实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }   
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1){
            return false;
        }
        else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(right, left) + 1;
    }
}
