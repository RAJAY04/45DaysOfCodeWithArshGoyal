package day11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PreRequisiteTasks {
    public static void main(String[] args) {
        int N = 2;
        int P = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(isPossible(N,P,prerequisites));
    }

    public static boolean isPossible(int N,int P, int[][] prerequisites)
    {
        int[] inDegree = new int[N];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            adj.get(pre).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        int[] topo = new int[N];
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo[i++] = node;
            for (int neighbour : adj.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return i == N;
    }
}
