package day10;

import java.util.*;

public class BFSofGraph {
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
        System.out.println(bfsOfGraph(V, adj));
    }

    static class Pair {
        List<Integer> lis;
        int node;

        Pair(List<Integer> lis, int node) {
            this.lis = lis;
            this.node = node;
        }
    }
    //can just simply add nodes into que rather than whole adj list
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pair> queue = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();

        boolean[] vis = new boolean[V];


        queue.add(new Pair(adj.get(0), 0));
        vis[0] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            res.add(p.node);
            for (int n : p.lis) {
                if (!vis[n]) {
                    queue.add(new Pair(adj.get(n), n));
                    vis[n] = true;
                }
            }
        }

        return res;
    }

    public static ArrayList<Integer> bfsOfGraph1(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from node 0
        queue.add(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            res.add(currentNode);

            // Process all adjacent nodes
            for (int neighbor : adj.get(currentNode)) {
                if (!vis[neighbor]) {
                    queue.add(neighbor);
                    vis[neighbor] = true;
                }
            }
        }

        return res;
    }
}
