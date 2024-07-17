package day2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxValueofEquation {
    public static void main(String[] args) {
        int[][] points = {{1,3},{2,0},{5,10},{6,-10}};
        int k = 1;
        System.out.println(findMaxValueOfEquation(points,k));
    }
    public static int findMaxValueOfEquation(int[][] points, int k) {
        //yj + yi + |xi - xj| = yj + yi + xj - xi
        //yj + xj + yi - xi
        //use a priority queue to store the values of yi - xi,xi

        //step 1 : sort the points based on xj - xi ( already sorted )
        //step 2 : iterate over the points and calculate the value of yj + xj + yi - xi
        //step 3 : store the values of yi - xi,xi in a deque
        //step 4 : if the current value of xj - xi is greater than k then remove the first element from the deque
        //step 5 : if the deque is not empty then calculate the value of yj + yi + xj - xi and update the result
        //step 6 : if the current value of yi - xi is greater than the last element of the deque then remove the last element from the deque
        //step 7 : add the current element to the deque
        //step 8 : return the result
        //step 6 means that we are removing the elements that are inferior to the current element in simple words
        Deque<int[]> deque = new LinkedList<>();
        int res = Integer.MIN_VALUE;

        for (int[] point : points) {
            int xj = point[0];
            int yj = point[1];

            // discard objects that we will never use since too far away
            while (!deque.isEmpty() && xj - deque.peekFirst()[0] > k)//xj - xi > k
                deque.pollFirst();


            int sum_j = xj + yj;

            if (!deque.isEmpty())
                res = Math.max(res, deque.peekFirst()[1] + sum_j);


            int diff_j = yj - xj;

            // discard objects that are inferior (xi is further than xj and it's value is smaller)
            while (!deque.isEmpty() &&  diff_j > deque.peekLast()[1])
                deque.pollLast();//we do this just to do our sorting work which was done in priority q

            //It starts from the end and goes through all the items up until the front of the queue,
            // if any item is less that the diff we have now, we remove it.
            //If we find an item with a greater diff, then we leave it and insert our item after it,
            // now the items are for sure order by (yi-xi) from the front.

            deque.offerLast(new int[]{xj, diff_j});
        }

        return res;
    }

    static class Point {
        int value;
        int x;

        Point(int value, int x) {
            this.value = value;
            this.x = x;
        }
    }

    public static int findMaxValueOfEquation1(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> b.value - a.value);
        int ans = Integer.MIN_VALUE;
        for(int[] point : points){
            int xj = point[0], yj = point[1];


            //since we know that the items are stored in accordance to the descending order of yi-xi we know that the one we stop
            // at is going to be the maximum yi-xi and is at most k distance away. (it doesn't really matter how far is it as long as it is within k).
            while(!pq.isEmpty() && xj - pq.peek().x > k){
                pq.poll();
            }

            int difference = yj - xj;
            if(!pq.isEmpty()){
                int yiMinusxi = pq.peek().value;
                ans = Math.max(ans,xj + yj + yiMinusxi);
            }
            pq.add(new Point(difference,xj));

        }
        return ans;
    }
}
