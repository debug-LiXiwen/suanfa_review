package review_jz.数组;

/**
 * @author LiXiwen
 * @date 2020/3/16 11:37
 */
public class p37_数字在排序数组中出现的次数 {

    /**
     * 找到最左边的和最右边的
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        int first = getFirst(array, k);
        int last = getLast(array, k);
        if(first == -1 || last == -1){
            return 0;
        } else {
            return last-first+1;
        }
    }

    int getFirst(int[] array, int k) {
        int l = 0;
        int h = array.length - 1;
        while (l <= h) {
            int mid = l + (h - l) >> 1;
            if (k < array[mid]) {
                h = mid - 1;
            } else if (k > array[mid]) {
                l = mid + 1;
            } else {
                if ((mid > 0 && array[mid - 1] != k) || mid == 0) {
                    return mid;
                } else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }

    int getLast(int[] array, int k) {
        int l = 0;
        int h = array.length - 1;
        while (l <= h) {
            int mid = l + (h - l) >> 1;
            if (k < array[mid]) {
                h = mid - 1;
            } else if (k > array[mid]) {
                l = mid + 1;
            } else {
                if ((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1) {
                    return mid;
                } else {
                    l = mid - 1;
                }
            }
        }
        return -1;
    }
}
