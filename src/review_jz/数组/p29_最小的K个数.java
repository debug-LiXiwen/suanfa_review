package review_jz.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LiXiwen
 * @date 2020/1/23 16:42
 */
public class p29_最小的K个数 {

    public static void main(String[] args) {
        p29_最小的K个数 a = new p29_最小的K个数();
//        int[] arr = {4,5,1,6,2,7,3,8};
//        ArrayList<Integer> list = a.GetLeastNumbers_Solution(arr, 4);
//        list.forEach(x -> System.out.print(x + " "));

        int[] arr1 = {49, 38, 65, 97, 76, 13, 49};
        ArrayList<Integer> list = a.GetLeastNumbers_Solution5(arr1, 2);
        list.forEach(x -> System.out.print(x + " "));
    }

    /**
     * 使用自带的堆，他默认是小顶堆，现在用个排序函数告诉他变为大顶堆
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (k <= 0 || k > input.length) {
            return res;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                queue.offer(input[i]);
            } else {
                if (input[i] < queue.peek()) {
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
        }
        res.addAll(queue);
        return res;
    }


/*
                     4
                  /     \
                 5       1
               /   \    / \
              6     2  7   3
             /
            8

            构造为4个数的大顶堆时：
                    6
                  /   \
                 5     1
                /
               4
           然后就是继续添加元素，如果小于顶，则换掉堆顶，然后下沉堆顶，也就是把较大的元素换到上面去。

*/

    /**
     * 使用大根堆解决，构造一个K大小的堆，堆顶是最大值
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return res;
        }
        int[] target = new int[k];
        int len = input.length;
        for (int i = 0; i < len; i++) {
            if (i < k) {
                target[i] = input[i];
                heapInsertSiftUp(target, i, target[i]);
            } else {
                if (input[i] < target[0]) {
                    target[0] = input[i];
                    siftDown(target, 0, target[0]);
                }
            }
        }
        for (int i : target) {
            res.add(i);
        }
        return res;
    }

    private void heapInsertSiftUp(int[] target, int k, int x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            if (x < target[parent]) {
                break;
            }
            target[k] = target[parent];
            k = parent;
        }
        target[k] = x;
    }

    private void siftDown(int[] target, int k, int x) {
        int half = target.length >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            int c = target[child];
            if (child + 1 < target.length && c < target[child + 1]) {
                child++;
                c = target[child];
            }
            if (c < x) {
                break;
            }
            target[k] = c;
            k = child;
        }
        target[k] = x;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return res;
        }
        int start = 0;
        int end = input.length - 1;
        int i = partition(input, start, end);
        while (i != k - 1) {
            if (i < k - 1) {
                start = i + 1;
                i = partition(input, start, end);
            } else {
                end = i - 1;
                i = partition(input, start, end);
            }
        }
        for (int i1 = 0; i1 < k; i1++) {
            res.add(input[i1]);
        }
        return res;
    }

    @SuppressWarnings("Duplicates")
    private int partition(int[] a, int p, int r) {
        int low = p;
        int high = r;
        int x = a[low];
        while (low < high) {
            while (low < high && a[high] >= x) {
                high--;
            }
            if (low < high) {
                a[low] = a[high];
            }
            while (low < high && a[low] <= x) {
                low++;
            }
            if (low < high) {
                a[high] = a[low];
            }
        }
        a[low] = x;
        return low;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution5(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (k <= 0 || k > input.length) {
            return res;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }
        for (int i = 0; i < input.length; i++) {
            res.add(queue.poll());
        }
        return res;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution4(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return list;
        }
        int[] target = new int[k];
        // 1. 构建最小堆
        for (int i = 0; i < k; i++) {
            target[i] = input[i];
            heapInsert1(target, i, target[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] > target[0]) {
                heapSiftDown1(target, i, k);
            }
        }
        for (int i : input) {
            System.out.print(i);
        }

        return list;
    }

    private void heapSiftDown1(int[] input, int i, int heapSize) {
        int half = heapSize >>> 1;
        int x = input[i];
        while (i < half) {
            int child = (i << 1) + 1;
            int c = input[child];
            int right = child + 1;
            if (right < heapSize && input[right] < input[child]) {
                c = input[child = right];
            }
            if (x <= c) {
                break;
            }
            input[i] = c;
            i = child;
        }
        input[i] = x;
    }

    private void heapInsert1(int[] target, int i, int x) {
        while (i > 0) {
            int parent = (i - 1) >>> 1;
            // 如果新数字 > 父节点，跳出，不用交换
            if (x > target[parent]) {
                break;
            }
            // 往下拉，避免直接上浮覆盖前面的值,
            // 否则，让新数字位置 = 父节点值，更新k，让父节点 = x，较大的那个值。
            target[i] = target[parent];
            i = parent;
        }
        target[i] = x;
    }

}

/*
 */