package review_jz.二叉树;

/**
 * @author LiXiwen
 * @date 2020/1/21 19:57
 */
public class p23_二叉搜索树的后序遍历序列 {
    /**
     * 入口方法+
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return judge(sequence);
    }

    /*左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的最后一个数字是右子树的根，
    它比左子树所有值大，因此我们可以每次只看有子树是否符合条件即可。
    即使到达了左子树，左子树也可以看出由左右子树组成的树还像右子树那样处理。
    对于右子树，左子树的所有值都比右子树的根小可以暂时把他看出右子树的左子树，
    只需看看右子树的右子树是否符合要求即可。*/
    /**
     * 非递归
     * @param sequence
     * @return
     */
    public boolean judge(int[] sequence) {
        int i = 0;
        int size = sequence.length;
        while (--size >= 0) {
            while (sequence[i] < sequence[size]) {
                i++;
            }
            if (i >= size) {
                return true;
            }
            while (sequence[i] > sequence[size]) {
                i++;
            }
            if (i < size) {
                return false;
            }
            i = 0;
        }
        return true;
    }

    public boolean judge(int[] sequence, int l, int r) {
        if (l >= r) {
            return true;
        }
        int i = 0;
        int v = sequence[r];
        for (; i < r; i++) {
            if (sequence[i] >= v) {
                break;
            }
        }
        for (int j = i; j < r; j++) {
            if (sequence[j] < v) {
                return false;
            }
        }
        return judge(sequence, l, i - 1) && judge(sequence, i, r - 1);
    }

}
/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
