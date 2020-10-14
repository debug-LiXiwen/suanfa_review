package review_jz.字符串;

import java.util.ArrayList;

/**
 * @author LiXiwen
 * @date 2020/3/14 14:49
 */
public class 字符串的所有子串 {
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> res = new ArrayList<>();
        int n = str.length();

        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                res.add(str.substring(i, j));
            }
        }
        res.forEach(x -> System.out.print(x + " "));
    }
}
