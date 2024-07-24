package day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }
    static List<List<Integer>> res;
    static List<Integer> list;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        int n = nums.length;
        boolean[] vis = new boolean[n];
        Arrays.sort(nums);
        backtrack(nums,vis);
        return res;
    }
    public static void backtrack(int[] nums, boolean[] vis){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(vis[i])continue;
            if(i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])continue;//[1a, 1b, 2a]
            //By using nums[i-1]==nums[i] && !used[i-1], we can make sure that 1b cannot be choosed before 1a
            vis[i] = true;
            list.add(nums[i]);
            backtrack(nums,vis);
            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }
}
