package day5;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        int[] ls = findLS(heights);
        int[] rs = findRs(heights);
        int max = 0;
        for(int i = 0 ; i < heights.length; i++){
            int area = (rs[i] - ls[i] + 1) * heights[i];
            max = Math.max(area,max);
        }
        return max;
    }
    public static int[] findLS(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ls = new int[n];
        for(int i = 0 ; i < n ;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ls[i] = 0;
            }else ls[i] = st.peek() + 1;
            st.push(i);
        }
        return ls;
    }
    public static int[] findRs(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] rs = new int[n];
        for(int i =  n - 1; i >= 0 ;i--){
            int num = arr[i];
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rs[i] = n - 1;
            }else rs[i] = st.peek() - 1;
            st.push(i);
        }
        return rs;
    }
}
