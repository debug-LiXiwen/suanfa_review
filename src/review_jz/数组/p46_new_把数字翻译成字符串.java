package review_jz.数组;

/**
 * @author LiXiwen
 * @date 2020/1/29 10:35
 */
public class p46_new_把数字翻译成字符串 {
    public static void main(String[] args) {
        p46_new_把数字翻译成字符串 aa = new p46_new_把数字翻译成字符串();
        //aa.getTranslationCount(12258);
    }

    public int getTranslationCount(int number) {
        if (number <= 0) {
            return 0;
        }
        char[] chars = String.valueOf(number).toCharArray();
        int len = chars.length;
        int[] dp = new int[len];
        dp[len - 1] = 1;
        dp[len - 2] = isInRange(chars[len - 2], chars[len - 1]) ? 2 : 1;
        for (int i = len - 3; i >= 0; i--) {
            dp[i] = dp[i-1] + (isInRange(chars[i], chars[i + 1]) ? dp[i-2] : 0);
        }
        System.out.println(dp[0]);
        return dp[0];
    }

    private boolean isInRange(char a, char b) {
        int s = (a - '0') * 10 + (b - '0');
        return s >= 10 && s <= 25;
    }
}
/*
https://www.cnblogs.com/yongh/p/9950362.html
 */