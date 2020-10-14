package review_jz.数组;

/**
 * @author LiXiwen
 * @date 2020/3/16 9:05
 */
public class p30_连续子数组的最大和 {

    public static void main(String[] args) {
        p30_连续子数组的最大和 a = new p30_连续子数组的最大和();
        int[] x = { -2, 11, -4, 13, -5, -2 };
        System.out.println(a.get(x));
        System.out.println(a.FindGreatestSumOfSubArray(x));
        System.out.println(maxSubArray(x));
    }


    int get(int[] a) {
        if (a== null || a.length == 0) {return 0;}
        int len = a.length;
        int[] dp = new int[len];
        int max=Integer.MIN_VALUE;
        dp[0] = a[0];
        for (int i=1;i<len;i++){
            if (dp[i-1] < 0) {
                dp[i] = a[i];
            } else {
                dp[i] = dp[i-1] + a[i];
            }
            max = max>dp[i] ? max : dp[i];
        }
        return max;
    }

    public static int maxSubArray(int[] arr){
        int sum = 0;
        int maxsum = 0;
        for(int i = 0; i < arr.length; i ++){
            if(sum <= 0){
                sum = arr[i];
            }else{
                sum += arr[i];
            }
            if(sum > maxsum){
                maxsum = sum;
            }
        }
        return maxsum;
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int len;
        int[] dp = new int[len = array.length];
        for (int i = 0; i < len; i++) {
            dp[i] = array[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public int FindGreatestSumOfSubArray1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < array.length; i++) {
            if (cur < 0) {
                cur = array[i];
            } else {
                cur += array[i];
            }
            max = Math.max(cur, max);
        }
        return max;
    }
}
