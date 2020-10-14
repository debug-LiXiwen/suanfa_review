package review_jz.数组;

/**
 * @author LiXiwen
 * @date 2020/3/18 13:46
 */
public class p65_矩阵中的路径 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] used = new boolean[rows * cols];
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, pathLength, str, i, j, used)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int pathLength, char[] str, int row, int col, boolean[] used) {
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row*cols + col] == str[pathLength] && !used[row*cols + col]) {
            if (pathLength == str.length - 1) {
                return true;
            }
            pathLength++;
            used[row*cols + col] = true;
            hasPath = hasPathCore(matrix, rows, cols, pathLength, str, row + 1, col, used)
                    || hasPathCore(matrix, rows, cols, pathLength, str, row - 1, col, used)
                    || hasPathCore(matrix, rows, cols, pathLength, str, row, col + 1, used)
                    || hasPathCore(matrix, rows, cols, pathLength, str, row, col - 1, used);
            if (!hasPath) {
                pathLength--;
                used[row*cols + col] = false;
            }
        }
        return hasPath;
    }

}
