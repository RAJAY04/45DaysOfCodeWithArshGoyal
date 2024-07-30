package day16;

public class ConvertSortedArrayIntoBST {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode node = sortedArrayToBST(nums);
        System.out.println(node.val);
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
    public static TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if(n == 0)return null;
        TreeNode node = formTree(nums,0,n - 1);
        return node;
    }
    public static TreeNode formTree(int[] nums, int s , int e){
        if(s > e)return null;
        int mid = (s + e)/2;
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = formTree(nums,s,mid - 1);
        newNode.right = formTree(nums,mid + 1, e);
        return newNode;
    }
}
