package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllUniquePermutationsOfArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<ArrayList<Integer>> result = uniquePerms(arr, arr.size());
        for (ArrayList<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        boolean[] visited = new boolean[n];
        Collections.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(arr,n,visited,ans,res);
        return res;
    }
    public static void dfs(List<Integer> arr , int n , boolean[] visited ,ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res){
        if(ans.size() == arr.size()){
            res.add(new ArrayList<>(ans));
        }else{
            for(int i = 0 ; i  < n ; i++){
                if (visited[i] || (i > 0 && arr.get(i) == arr.get(i - 1) && !visited[i - 1])) {
                    continue; // Skip duplicates
                }
                visited[i] = true;
                ans.add(arr.get(i));
                dfs(arr, n, visited, ans, res);
                ans.remove(ans.size() - 1);
                visited[i] = false;
            }
        }
    }

}
