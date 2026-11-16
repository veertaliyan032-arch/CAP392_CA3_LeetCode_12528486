// LeetCode 73 - Set Matrix Zeroes (Medium)
// Approach: use first row/column as markers; remember separately if they themselves need zeroing.
// Time: O(m*n)  Space: O(1)
import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        for (int j = 0; j < n; j++) if (matrix[0][j] == 0) firstRow = true;
        for (int i = 0; i < m; i++) if (matrix[i][0] == 0) firstCol = true;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;

        if (firstRow) for (int j = 0; j < n; j++) matrix[0][j] = 0;
        if (firstCol) for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        s.setZeroes(a);
        System.out.println(Arrays.deepToString(a) + " (expected [[1,0,1],[0,0,0],[1,0,1]])");
        int[][] b = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        s.setZeroes(b);
        System.out.println(Arrays.deepToString(b) + " (expected [[0,0,0,0],[0,4,5,0],[0,3,1,0]])");
        int[][] c = {{1}};
        s.setZeroes(c);
        System.out.println(Arrays.deepToString(c) + " (expected [[1]])");
    }
}
