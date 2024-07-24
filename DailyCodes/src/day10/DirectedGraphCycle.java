package day10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DirectedGraphCycle {
    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency lists for each vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        adj.get(6).add(5); // Node 6 → Node 5
        adj.get(5).add(3); // Node 5 → Node 3
        adj.get(3).add(1); // Node 3 → Node 1
        adj.get(1).add(2); // Node 1 → Node 2
        adj.get(2).add(4); // Node 2 → Node 4
        adj.get(4).add(0); // Node 4 → Node 0

        // Print the adjacency list
        System.out.println("Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (Integer neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];//can merge both too by marking 0,1,2 in single array
        boolean[] pathVis = new boolean[V];

        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                if(dfs(i,adj,vis,pathVis))return true;
            }
        }
        return false;
    }
    public static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis){
        vis[node] = true;
        pathVis[node] = true;
        for(int neighbours : adj.get(node)){
            if(vis[neighbours] && pathVis[neighbours]){
                return true;
            }else if(!vis[neighbours]){
                if(dfs(neighbours,adj,vis,pathVis))return true;
            }

        }
        pathVis[node] = false;//backtrack
        return false;
    }
}
