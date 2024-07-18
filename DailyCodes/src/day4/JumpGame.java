package day4;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int moves = 0;
        for(int i = 0  ; i < n ; i++){
            moves = Math.max(moves,nums[i]);
            if(moves == 0 && i != n - 1)return false;
            moves--;
        }
        return true;
    }
}
