package day1;

public class FindDuplicateNumbers {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n ;i++){
            int actualIndex = nums[i] - 1;
            if(nums[actualIndex] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[actualIndex];
                nums[actualIndex] = temp;
                i--;//if swap occurs we have to check that index again
            }
        }
        for(int i = 0; i < n ;i++){
            if(nums[i] != i + 1)return nums[i];
        }
        return -1;
    }
}
