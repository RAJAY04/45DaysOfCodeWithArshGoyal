package day16;

public class SubtreeofAnotherTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);
        System.out.println(isSubtree(root,subRoot));
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
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)return false;
        if(dfs(root,subRoot))return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public static boolean dfs(TreeNode s,TreeNode t){
        if(s == null && t == null)return true;
        if(s == null || t == null)return false;

        if(s.val != t.val)return false;

        return dfs(s.left,t.left) && dfs(s.right,t.right);
    }
}
