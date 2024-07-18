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
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(arr);
        boolean[] used = new boolean[n];
        backtrack(arr, new ArrayList<>(), used, result);
        return result;
    }

    static void backtrack(ArrayList<Integer> arr, ArrayList<Integer> tempList, boolean[] used, ArrayList<ArrayList<Integer>> result) {
        if (tempList.size() == arr.size()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < arr.size(); i++) {
                if (used[i] || (i > 0 && arr.get(i) == arr.get(i - 1) && !used[i - 1])) continue;
                used[i] = true;
                tempList.add(arr.get(i));
                backtrack(arr, tempList, used, result);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
