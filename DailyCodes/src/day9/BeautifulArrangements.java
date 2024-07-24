package day9;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangements {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(countArrangement(n));
    }

    static int ans;
    static List<Integer> list;
    public static int countArrangement(int n) {
        ans = 0;
        list = new ArrayList<>();
        boolean[] vis = new boolean[n];
        backtract(n,vis);
        return ans;
    }
    public static void backtract(int n ,boolean[] vis){
        if(!isValid(list))return;
        if(list.size() == n){
            ans++;
            return;
        }
        for(int i = 1; i <= n ; i++){
            if(vis[i - 1])continue;
            list.add(i);
            vis[i - 1] = true;
            backtract(n,vis);
            vis[i - 1] = false;
            list.remove(list.size() - 1);
        }
    }

    public static boolean isValid(List<Integer> list){
        for(int i = 0 ; i < list.size(); i++){
            if(list.get(i) % (i + 1) != 0 && (i + 1) % list.get(i) != 0)return false;
        }
        return true;
    }

}
