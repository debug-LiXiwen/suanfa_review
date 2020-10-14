package review_jz.数组;

import java.util.HashSet;

/**
 * @author LiXiwen
 * @date 2020/3/17 22:06
 */
public class p50_数组中重复的数字 {

    public int test(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int length = nums.length;
        // 若存在数组元素不在[0, n-1] 的范围内，直接返回false
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0 || nums[i] > length - 1) {
                return 0;
            }
        }
        for (int i = 0; i < length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int t = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = t;
            }
        }
        return 0;
    }

    public int test1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }


}
