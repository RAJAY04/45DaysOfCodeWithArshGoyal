package day1;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        //two pointers approach
        int n = nums.length;
        if(n == 1)return 1;
        int i = 1 , j = 1;
        int curNum = nums[0];
        while(j < n){
            if(nums[j] == curNum){
                nums[j] = -1;
            }else{
                curNum = nums[j];
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
            j++;
        }
        return i;
    }
}
