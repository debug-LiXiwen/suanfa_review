package review_jz.字符串;

/**
 * @author LiXiwen
 * @date 2020/3/17 21:57
 */
public class p49_把字符串转换成整数 {

    public int StrToInt(String str) {
        int n;
        if (null == str || (n = str.length()) == 0) {
            return 0;
        }
        int sym = str.charAt(0) == '-' ? -1 : 1;
        char c;
        int rs = 0;
        for (int i = (str.charAt(0) == '+' || str.charAt(0) == '-') ? 1 : 0; i < n; i++) {
            if (!((c = str.charAt(i)) >= '0' && c <= '9')) {
                return 0;
            }
            rs = rs * 10 + c - '0';
            boolean a = (sym == 1 && rs>Integer.MAX_VALUE) ||
                    (sym == -1 && rs*(long)(-1) < Integer.MIN_VALUE);
            if (a) {
                return 0;
            }
        }
        return rs * sym;
    }
}
