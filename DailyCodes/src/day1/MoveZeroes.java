package day1;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
    public static void moveZeroes(int[] nums) {
        int zero = 0 , nonZero = 0;
        int n = nums.length;
        while(zero < n - 1 && nums[zero] != 0)zero++;
        nonZero = zero + 1;
        while(nonZero < n){
            if(nums[nonZero] != 0){
                int temp = nums[zero];
                nums[zero] = nums[nonZero];
                nums[nonZero] = temp;
                zero++;
                nonZero++;
            }else{
                nonZero++;
            }
        }
    }
}
