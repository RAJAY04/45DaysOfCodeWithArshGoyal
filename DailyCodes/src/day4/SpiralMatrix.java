package day4;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int left = 0 , right = matrix[0].length - 1  , top = 0 , bottom = matrix.length - 1;

        List<Integer> res = new ArrayList<>();
        while(left <= right && top <= bottom){
            for(int c = left; c <= right ; c++){
                res.add(matrix[top][c]);
            }
            top++;

            for(int r = top  ; r <= bottom ; r++){
                res.add(matrix[r][right]);
            }
            right--;

            if(top <= bottom){
                for(int c = right ; c >= left; c--){
                    res.add(matrix[bottom][c]);
                }
                bottom--;
            }

            if(left <= right){
                for(int r = bottom; r >= top ; r--){
                    res.add(matrix[r][left]);
                }
                left++;
            }


        }
        return res;
    }



}
