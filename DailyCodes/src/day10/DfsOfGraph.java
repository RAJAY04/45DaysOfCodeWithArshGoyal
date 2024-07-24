package day10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DfsOfGraph {
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
        System.out.println(new DfsOfGraph().dfsOfGraph(V, adj));
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        vis[0] = true;
        dfs(0,V,vis,res,adj);
        return res;
    }
    public static void dfs(int node, int n , boolean[] vis, ArrayList<Integer> res,ArrayList<ArrayList<Integer>> adj){
        for(int neighbours : adj.get(node)){
            if(!vis[neighbours]){
                res.add(neighbours);
                vis[neighbours] = true;
                dfs(neighbours,n,vis,res,adj);
            }
        }
    }
}
