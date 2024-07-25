package day11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TopologicalSorting {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(2);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(3);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(5);
        ArrayList<Integer> l5 = new ArrayList<>();
        l5.add(5);
        adj.add(l1);
        adj.add(l2);
        adj.add(l3);
        adj.add(l4);
        adj.add(l5);
        adj.add(new ArrayList<>());
        int[] res = topoSort(V, adj);
        for(int i : res){
            System.out.print(i + " ");
        }
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] inDegree = new int[V];
        for(int i = 0 ; i < V ;i++){
            for(int node : adj.get(i)){
                inDegree[node]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ; i < V ; i++){
            if(inDegree[i] == 0) queue.add(i);
        }

        int[] topo = new int[V];
        int i = 0 ;
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo[i++] = node;
            for(int neighbours : adj.get(node)){
                inDegree[neighbours]--;
                if(inDegree[neighbours] == 0)queue.add(neighbours);
            }
        }
        return topo;
    }
}
