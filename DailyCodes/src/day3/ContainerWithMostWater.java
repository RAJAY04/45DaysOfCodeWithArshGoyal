package day3;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int n = height.length;
        int i = 0 , j = n - 1;
        int max = Integer.MIN_VALUE;
        while ( i < j){
            max = Math.max((j - i) * Math.min(height[i],height[j]),max);
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
