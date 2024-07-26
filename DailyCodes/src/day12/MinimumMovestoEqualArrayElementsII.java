package day12;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(minMoves2(nums));
    }
    //most optimal approach would be using quick select algorithm as we just need median
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n % 2 == 1){
            return helper(nums,nums[n/2]);
        }else{
            return Math.min(helper(nums,nums[n/2]),helper(nums,nums[(n/2) - 1]));
        }
    }
    public static int helper(int[] nums,int num){
        int count = 0;
        for(int i = 0 ;i < nums.length;i++){
            count += Math.abs(num - nums[i]);
        }
        return count;
    }
}
