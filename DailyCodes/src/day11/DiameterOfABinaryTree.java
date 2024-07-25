package day11;

import javax.swing.tree.TreeNode;

public class DiameterOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(diameterOfBinaryTree(root));
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static int res;
    public static int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        if(root == null)return res;
        dfs(root);
        return res;
    }
    public static int dfs(TreeNode root){
        if(root == null)return - 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res,left + right + 2);
        return 1 + Math.max(left,right);
    }
}
