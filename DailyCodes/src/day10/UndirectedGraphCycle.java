package day10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class UndirectedGraphCycle {
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
        System.out.println(isCycle(V, adj));
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0 ; i < V ;i++){
            if(!vis[i]){
                queue.add(new int[]{-1,i});
                vis[i] = true;
                while(!queue.isEmpty()){
                    int[] data = queue.poll();
                    int cur = data[1];
                    int prev = data[0];
                    for(int neighbour : adj.get(cur)){
                        if(vis[neighbour] && neighbour != prev){
                            return true;
                        }else if(!vis[neighbour]){
                            queue.add(new int[]{cur,neighbour});
                            vis[neighbour] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
