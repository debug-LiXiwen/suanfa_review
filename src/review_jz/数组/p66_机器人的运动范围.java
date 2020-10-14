package review_jz.数组;

/**
 * @author LiXiwen
 * @date 2020/3/18 14:00
 */
public class p66_机器人的运动范围 {

    int s = 0;
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 1 || rows < 1 || cols < 1) {
            return s;
        }
        boolean[] used = new boolean[rows * cols];
        movingCountCore(threshold, rows, cols, 0, 0, used);
        return s;
    }

    private void movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] used) {
        if (check(threshold, rows, cols, row, col, used)) {
            ++s;
            used[row*cols + col] = true;
            movingCountCore(threshold, rows, cols, row + 1, col, used);
            movingCountCore(threshold, rows, cols, row - 1, col, used);
            movingCountCore(threshold, rows, cols, row, col + 1, used);
            movingCountCore(threshold, rows, cols, row, col - 1, used);
        }
        return;
    }

    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] used) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && getSum(row, col) <= threshold && !used[row*cols+col]) {
            return true;
        }
        return false;
    }

    private int getSum(int x, int y) {
        int ss = 0;
        while (x > 0) {
            ss += x % 10;
            x = x / 10;
        }
        while (y > 0) {
            ss += y % 10;
            y = y / 10;
        }
        return ss;
    }

}
