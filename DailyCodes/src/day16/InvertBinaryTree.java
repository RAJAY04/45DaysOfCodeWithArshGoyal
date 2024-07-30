package day16;

public class InvertBinaryTree {
    public static void main(String[] args) {
         TreeNode root = new TreeNode(4);
         root.left = new TreeNode(2);
         root.right = new TreeNode(7);
         root.left.left = new TreeNode(1);
         root.left.right = new TreeNode(3);
         root.right.left = new TreeNode(6);
         root.right.right = new TreeNode(9);
         TreeNode res = invertTree(root);
         System.out.println(res.val);
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
    public static TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    public static void dfs(TreeNode root){
        if(root == null)return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);
    }
}
