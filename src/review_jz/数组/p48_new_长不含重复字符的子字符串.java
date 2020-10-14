package review_jz.数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author LiXiwen
 * @date 2020/1/29 11:20
 */
public class p48_new_长不含重复字符的子字符串 {

    public static void main(String[] args) {
        p48_new_长不含重复字符的子字符串 a = new p48_new_长不含重复字符的子字符串();
        a.longestSubstringWithoutDuplication("pwwkew");
        a.longestSubstringWithoutDuplication("bbbbb");
        a.longestSubstringWithoutDuplication("abcabcbb");
    }

    public int longestSubstringWithoutDuplication(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < len; j++) {
            if (map.containsKey(chars[j])) {
                map.put(chars[j], map.get(chars[j]) + 1);
            } else {
                map.put(chars[j], 1);
            }
            while (map.get(chars[j]) > 1) {
                map.put(chars[i], map.get(chars[i]) - 1);
                i++;
            }
            max = max > (j - i + 1) ? max : (j - i + 1);
        }
        System.out.println(max);
        return max;
    }

    @SuppressWarnings("Duplicates")
    public int longestSubstringWithoutDuplication1(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, (j - i));
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public int longestSubstringWithoutDuplication3(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < len; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }

            max = Math.max(max, (j - i + 1));
            map.put(s.charAt(j), j + 1);
        }
        return max;
    }

    public int longestSubstringWithoutDuplication2(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] map = new int[128];
        for (int i = 0, j = 0; j < len; j++) {
            i = Math.max(i, map[s.charAt(j)]);
            max = Math.max(max, (j - i + 1));
            map[s.charAt(j)] = j + 1;
        }
        return max;
    }

}
/*
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

假设字符串中只包含从’a’到’z’的字符。

样例
输入："abcabc"

输出：3
 */