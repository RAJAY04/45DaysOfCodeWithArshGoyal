package day16;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(binaryTreePaths(root));
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

    static List<String> ans;
    public static List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return ans;
    }
    public static void dfs ( TreeNode root, StringBuilder sb){
        int len = sb.length();
        if(root.left == null && root.right == null){
            sb.append(""+root.val);
            ans.add(sb.toString());
            sb.setLength(sb.length()-1);
            return;
        }

        if(root.left != null){
            sb.append(root.val + "->");
            dfs(root.left,sb);
            sb.setLength(len);
        }
        if(root.right != null){
            sb.append(root.val + "->");
            dfs(root.right,sb);
            sb.setLength(len);
        }

    }
}
