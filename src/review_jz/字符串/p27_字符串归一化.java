package review_jz.字符串;

/**
 * @author LiXiwen
 * @date 2020/3/15 12:15
 */
public class p27_字符串归一化 {
    public static void main(String[] args) {
        int[] c = new int[26];
        String s = "dabcab";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            c[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            if (c[i] == 0) {
                continue;
            } else {
                System.out.print(ch + "" + c[i]);
            }
        }
    }
}

/*
通过键盘输入一串小写字母(a~z)组成的字符串。
请编写一个字符串归一化程序，统计字符串中相同字符出现的次数，并按字典序输出字符及其出现次数。
例如字符串"babcc"归一化后为"a1b2c2"

输入
dabcab
输出
a2b2c1d1
 */