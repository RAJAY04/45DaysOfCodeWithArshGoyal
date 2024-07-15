package day1;

public class SetMatrix0 {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        for(int[] i : matrix){//i am using copilot to generate this main function to save time
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        int zeroZero = 1;

        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m ;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0)
                        matrix[0][j] = 0;
                    else zeroZero = 0;
                }
            }
        }

        for(int i = 1 ; i < n ;i++){
            for(int j = 1 ; j < m ;j++){
                if(matrix[i][j] != 0){
                    if(matrix[0][j] == 0 || matrix[i][0] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }

        }
        if (zeroZero == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }


}
