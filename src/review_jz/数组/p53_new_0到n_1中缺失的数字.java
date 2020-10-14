package review_jz.数组;

/**
 * @author LiXiwen
 * @date 2020/3/17 22:29
 */
public class p53_new_0到n_1中缺失的数字 {

    int test(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) == 0) {
            return -1;
        }
        int l = 0;
        int h = n - 1;
        while (l < h) {
            int mid = l + (h - l) >> 1;
            if (nums[mid] != mid) {
                if (mid == 0 || (nums[mid - 1] == mid - 1)) {
                    return mid;
                }
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l == n ? n : -1;
    }

    int test1(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return -1;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (nums[n-1] <= n) {
            int s = n * (n + 1) / 2;
            if (s == sum) {
                return 0;
            } else {
                return s - sum;
            }
        }
        return -1;
    }

}
