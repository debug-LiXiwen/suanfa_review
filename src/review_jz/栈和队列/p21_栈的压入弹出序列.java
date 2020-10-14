package review_jz.栈和队列;

import java.util.Stack;

/**
 * @author LiXiwen
 * @date 2020/1/20 20:37
 */
public class p21_栈的压入弹出序列 {
    public static void main(String[] args) {

    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> s = new Stack<>();
        int popI = 0;
        int i = 0;
        while (i < pushA.length) {
            s.push(pushA[i]);
            while (!s.isEmpty() && s.peek() == popA[popI]) {
                popI++;
                s.pop();
            }
            i++;
        }
        return s.isEmpty();
    }
}

/*
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
/*
模拟堆栈操作：将原数列依次压栈，栈顶元素与所给出栈队列相比，如果相同则出栈，
如果不同则继续压栈，直到原数列中所有数字压栈完毕。
检测栈中是否为空，若空，说明出栈队列可由原数列进行栈操作得到。否则，说明出栈队列不能由原数列进行栈操作得到。
 */