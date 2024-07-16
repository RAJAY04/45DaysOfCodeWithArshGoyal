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
        //use a priority queue to store the values of yi - xi,xi \

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
            int x_j = point[0];
            int y_j = point[1];

            // discard objects that we will never use since too far away
            while (!deque.isEmpty() && x_j - deque.peekFirst()[0] > k)//x_j - xi > k
                deque.pollFirst();


            int sum_j = x_j + y_j;

            if (!deque.isEmpty())
                res = Math.max(res, deque.peekFirst()[1] + sum_j);


            int diff_j = y_j - x_j;

            // discard objects that are inferior (x_i is further than x_j and it's value is smaller)
            while (!deque.isEmpty() &&  diff_j > deque.peekLast()[1])
                deque.pollLast();

            deque.offerLast(new int[]{x_j, diff_j});
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
        // PriorityQueue to store points in the form (yi - xi, xi)
        // We use a max heap to get the maximum value of (yi - xi) efficiently
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> b.value - a.value);

        int res = Integer.MIN_VALUE;

        for (int[] point : points) {
            int xj = point[0];
            int yj = point[1];

            // Remove points from the heap where the difference in x coordinates is greater than k
            while (!pq.isEmpty() && xj - pq.peek().x > k) {
                pq.poll();
            }

            // If the heap is not empty, calculate the potential maximum value of the equation
            if (!pq.isEmpty()) {
                res = Math.max(res, pq.peek().value + xj + yj);
            }

            // Add the current point in the form (yj - xj, xj) to the heap
            pq.offer(new Point(yj - xj, xj));
        }

        return res;
    }
}
