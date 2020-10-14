package review_jz.字符串;

/**
 * @author LiXiwen
 * @date 2020/3/16 13:53
 */
public class p43_左旋转字符串 {

    public String LeftRotateString(String str, int n) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, str.length() - 1);
        reverse(chars, 0, str.length() - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int l, int h) {
        char t;
        while (l <= h) {
            t = chars[l];
            chars[l] = chars[h];
            chars[h] = t;
            l++;
            h--;
        }
    }

}
/*
abcXYZdef XYZdefabc
 */
