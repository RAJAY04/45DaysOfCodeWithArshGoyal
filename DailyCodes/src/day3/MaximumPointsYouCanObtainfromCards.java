package day3;

public class MaximumPointsYouCanObtainfromCards {
    public static void main(String[] args) {
        int[] cardPoints = {96,90,41,82,39,74,64,50,30};
        int k = 8;
        System.out.println(maxScore(cardPoints,k));
    }
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int i = 0 ;
        int j = n - k;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int idx = n - k ; idx < n;idx++){
            sum += cardPoints[idx];
        }
        if(k == n)return sum;
        while(k > 0){
            max = Math.max(sum,max);
            sum += cardPoints[i];
            sum -= cardPoints[j];
            i++;
            j++;
            k--;
        }
        max = Math.max(max,sum);
        return max;
    }
}
