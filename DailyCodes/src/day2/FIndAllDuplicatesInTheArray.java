package day2;

import java.util.ArrayList;
import java.util.List;

public class FIndAllDuplicatesInTheArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        for(int i = 0 ; i < nums.length; i++){
            int correctIndex = nums[i] - 1;
            if(nums[correctIndex] == nums[i]){
                continue;
            }else{
                swap(nums,i,correctIndex);
                i--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] != i + 1)list.add(nums[i]);
        }
        return list;
    }
    public static void swap(int[] nums,int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
