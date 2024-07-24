package day10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(2);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(3);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(2);
        l4.add(0);
        adj.add(l1);
        adj.add(l2);
        adj.add(l3);
        adj.add(l4);
        System.out.println(isBipartite(V, adj));
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        int[] colors = new int[V];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                queue.add(i);
                vis[i] = true;
                colors[i] = 1;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int color = colors[node];
                    for (int neighbours : adj.get(node)) {
                        if (vis[neighbours] && colors[neighbours] == color) {
                            return false;
                        } else if (!vis[neighbours]) {
                            queue.add(neighbours);
                            vis[neighbours] = true;
                            colors[neighbours] = color == 1 ? 2 : 1;
                        }
                    }
                }
            }
        }
        return true;
    }
}

