package day4;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums,target));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i< nums.length ;i++){
            int required = target - nums[i];
            if(map.containsKey(required)){
                return new int[]{i,map.get(required)};
            }else{
                map.put(nums[i],i);
            }
        }
        return nums;
    }

}
