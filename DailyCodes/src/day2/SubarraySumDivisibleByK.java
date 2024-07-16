package day2;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {
    public static void main(String[] args) {
          int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(subarraysDivByK(nums,5));
    }
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            int rem = ((sum % k)+k)%k;
            if(map.containsKey(rem)){
                ans += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+ 1);
        }
        return ans;
    }
}
