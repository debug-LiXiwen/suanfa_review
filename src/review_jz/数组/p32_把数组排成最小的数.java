package review_jz.数组;

import java.util.ArrayList;

/**
 * @author LiXiwen
 * @date 2020/3/16 9:26
 */
public class p32_把数组排成最小的数 {

    public static String PrintMinNumber(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }
        list.sort((x, y) -> {
            String s1 = x + "" + y;
            String s2 = y + "" + x;
            return s1.compareTo(s2);
        });
        StringBuilder s = new StringBuilder();
        list.forEach(x -> s.append(x));
        return s.toString();
    }
}