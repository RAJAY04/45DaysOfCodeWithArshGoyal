package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterEleI {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(nextGreaterElement(nums1,nums2));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for(int i = 0 ; i < nums1.length; i++){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}
