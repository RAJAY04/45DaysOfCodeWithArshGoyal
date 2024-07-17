package day3;

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(4);
        a.add(1);
        a.add(9);
        a.add(56);
        a.add(7);
        a.add(9);
        a.add(12);
        int n = 8;
        int m = 5;
        System.out.println(findMinDiff(a,n,m));
    }

    public static long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        int i = 0 , j = m -1 ;
        long min = Integer.MAX_VALUE;
        while(j < n){
            min = Math.min(a.get(j++) - a.get(i++),min);
        }
        return min;
    }
}
