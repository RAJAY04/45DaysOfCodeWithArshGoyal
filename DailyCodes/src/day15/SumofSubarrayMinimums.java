package day15;

import java.util.Stack;

public class SumofSubarrayMinimums {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int[] psee = findPSEE(arr);
        int[] nse = findNSE(arr);
        int n = arr.length;
        long total = 0;
        int mod = (int)(1e9) + 7;

        for (int i = 0; i < n; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;
            total = (total + (left * right * arr[i]) % mod) % mod;
        }
        return (int) total;
    }

    private static int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }

    private static int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
}
