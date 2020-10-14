package review_jz.字符串;

/**
 * @author LiXiwen
 * @date 2020/3/16 10:44
 */
public class 字符串压缩 {

    public String compressString(String S) {
        int len = S.length();
        if (S == null || len <= 1) {
            return S;
        }

        StringBuilder sb = new StringBuilder();
        //快慢前后双指针
        int l = 0, r = 1;
        while(r < len){
            if (S.charAt(l) != S.charAt(r)) {
                sb.append(S.charAt(l));
                sb.append(r - l);
                l = r;
                r += 1;
            } else {
                r++;
            }
        }
        //最后一个相同的字符
        sb.append(S.charAt(l));
        sb.append(r - l);

        //和原字符串比较长度
        return sb.length()>=len?S:sb.toString();
    }

}

/*
字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
你可以假设字符串中只包含大小写英文字母（a至z）。

示例1:

 输入："aabcccccaaa"
 输出："a2b1c5a3"
示例2:

 输入："abbccd"
 输出："abbccd"
 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。

https://leetcode-cn.com/problems/compress-string-lcci
 */