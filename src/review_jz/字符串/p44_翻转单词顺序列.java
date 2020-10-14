package review_jz.字符串;

/**
 * @author LiXiwen
 * @date 2020/1/26 19:14
 */
public class p44_翻转单词顺序列 {
    public static void main(String[] args) {
        p44_翻转单词顺序列 aa = new p44_翻转单词顺序列();
        System.out.println(aa.ReverseSentence("student. a am I"));
    }

    public static String ReverseSentence(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        String[] s = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            sb.append(s[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 算法思想：先翻转整个句子，然后，依次翻转每个单词。
     *     依据空格来确定单词的起始和终止位置
     * @param str
     * @return
     */
    public String ReverseSentence1(String str) {
        char[] chars = str.toCharArray();
        // 先反转整个句子 student. a am I --> I ma a .tneduts
        reverse(chars, 0, chars.length - 1);
        int begin = -1;
        int end = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int next = i;
                reverse(chars, begin + 1, next - 1);
                begin = next;
            }
        }
        return new String(chars);
    }


    public void reverse(char[] chars,int low,int high){
        while(low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }

}
