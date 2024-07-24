package day9;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(combine(n,k));
    }

    static List<List<Integer>> res;
    static List<Integer> list;
    public static List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        backtrack(1,n,k);
        return res;
    }

    public static void backtrack(int index ,int n,int k){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index ; i <= n; i++){
            list.add(i);
            backtrack(i + 1,n , k);
            list.remove(list.size() - 1);
        }
    }
}
