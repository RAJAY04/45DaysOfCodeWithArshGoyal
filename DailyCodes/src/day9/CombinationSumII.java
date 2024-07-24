package day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }

    static List<List<Integer>> res;
    static List<Integer> list;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,0,target);
        return res;
    }
    public static void backtrack(int[] nums,int index,int target){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }else if(target < 0)return;
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i - 1] == nums[i])continue;//if its not begenning of interation ( i > index )
            list.add(nums[i]);
            backtrack(nums,i + 1,target - nums[i]);
            list.remove(list.size() - 1);
        }
    }
}
