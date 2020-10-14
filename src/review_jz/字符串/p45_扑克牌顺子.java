package review_jz.字符串;

/**
 * @author LiXiwen
 * @date 2020/3/16 14:05
 */
public class p45_扑克牌顺子 {
    public static void main(String[] args) {
        p45_扑克牌顺子 a = new p45_扑克牌顺子();
        int[] arr = {0,3,5,4,1};
        System.out.println(a.isContinuous(arr));
        int[] arr1 = {1,3,0,7,0};
        System.out.println(a.isContinuous(arr1));
        int[] arr2 = {1,0,0,1,0};
        System.out.println(a.isContinuous(arr2));
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return false;
        }
        qsort(numbers);
        int nz = 0;
        int nb = 0;
        int len = numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        for (int i = 0; i < len; i++) {
            if (numbers[i] == 0) {
                nz++;
            }
        }
        int l = nz;
        int h = l + 1;
        while (h < len) {
            if (numbers[l] == numbers[h]) {
                return false;
            }
            nb += numbers[h] - numbers[l] - 1;
            l = h;
            h++;
        }
        return nb <= nz;
    }
    
    private void qsort(int[] nums) {
        int[] map = new int[14];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]]++;
        }
        int j = 0;
        for (int i = 0; i < 14; i++) {
            while (map[i] > 0) {
                nums[j++] = i;
                map[i]--;
            }
        }
    }
}
