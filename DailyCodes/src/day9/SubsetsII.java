package day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    static List<List<Integer>> res;
    static List<Integer> list;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    public static void backtrack(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        backtrack(nums,index + 1);
        list.remove(list.size() - 1);

        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        backtrack(nums,index + 1);

    }
}
