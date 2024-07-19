package day5;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 1, candidate = nums[0];
        for(int i = 1 ; i < n ; i++){
            if(nums[i] != candidate){
                count--;
            }else count++;

            if(count == 0){
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }
}
