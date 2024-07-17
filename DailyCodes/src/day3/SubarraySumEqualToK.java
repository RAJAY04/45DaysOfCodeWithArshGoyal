package day3;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualToK {
    public static void main(String[] args) {

    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        map.put(0,1);
        int res = 0;
        for(int num : nums){
            preSum += num;
            if(map.containsKey(preSum)){
                res += map.get(preSum);
            }
            map.put(preSum,map.getOrDefault(preSum,0) + 1);
        }
        return res;
    }
}
