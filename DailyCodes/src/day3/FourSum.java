package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(fourSum(nums, target));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            for(int ii = i + 1 ; ii < n - 1 ; ii++){
                if(ii > i + 1 && nums[ii] == nums[ii - 1])
                    continue;
                int j = ii + 1, k = n - 1;
                while (j < k) {
                    long sum = (long)nums[i] + (long)nums[ii] + (long)nums[j] + (long)nums[k]; // Use long for sum
                    if (sum == target) {
                        res.add(new ArrayList<>(List.of(nums[i],nums[ii], nums[j], nums[k])));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1])
                            j++;
                        while (k > j && nums[k] == nums[k + 1])
                            k--;
                    } else if (sum > target) {
                        k--;
                    } else
                        j++;
                }
            }
        }
        return res;
    }
}

