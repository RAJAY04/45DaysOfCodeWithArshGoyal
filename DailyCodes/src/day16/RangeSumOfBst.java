package day16;

public class RangeSumOfBst {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root,7,15));
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
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        if(root.val < low)
            return rangeSumBST(root.right, low, high);
        else if(root.val > high)
            return rangeSumBST(root.left, low, high);

        return root.val + rangeSumBST(root.right, low, high)+rangeSumBST(root.left, low, high);
    }
}
