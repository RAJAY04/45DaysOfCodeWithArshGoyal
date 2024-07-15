package day1;

public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {6,2,7,3,2,10,3,4,2};
        System.out.println(reversePairs(nums));
    }


    public static int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length - 1);
    }
    public static int mergeSort(int[] nums,int s, int e){
        int ans = 0;
        if (s < e) {
            int mid = s + (e - s) / 2;
            ans += mergeSort(nums, s, mid);
            ans += mergeSort(nums, mid + 1, e);
            ans += merge(nums, s, mid, e);
        }
        return ans;
    }

    public static int merge(int[] nums,int s , int mid, int e){
        int i = s, j = mid + 1, k = 0;
        int[] temp = new int[e - s + 1];
        int ans = 0;
        for (i = s; i <= mid; i++) {
            while (j <= e && nums[i] > 2L * nums[j]) {
                j++;
            }
            ans += (j - (mid + 1));
        }

        i = s;
        j = mid + 1;

        while(i <= mid && j <= e){
            if(nums[i] > nums[j]){
                temp[k++] = nums[j++];
            }else{
                temp[k++] = nums[i++];
            }
        }

        while(i <= mid){
            temp[k++] = nums[i++];
        }

        while(j <= e){
            temp[k++] = nums[j++];
        }
        for(int idx = 0 ; idx < temp.length; idx++){
            nums[s + idx] = temp[idx];
        }
        return ans;
    }
}
