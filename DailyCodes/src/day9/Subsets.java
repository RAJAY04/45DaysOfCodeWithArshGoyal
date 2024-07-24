package day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> res;
    static List<Integer> list;

    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
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
        backtrack(nums,index + 1);

    }
}
