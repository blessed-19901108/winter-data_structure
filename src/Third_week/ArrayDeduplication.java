package Third_week;

import java.util.Arrays;

public class ArrayDeduplication {

    /**
     * 重复元素置空
     */
    public static void blanking(Integer[] a) {
        //保留原来数组a的数据，以其为基准来置空某个位置
        Integer[] t = Arrays.copyOf(a, a.length);
        //posForward指向“第一个元素” posRear指向“与第一个元素重复的元素”
        int posF = 0;
        int posR = 1;
        while (posR < t.length) {
            if (t[posR].equals(t[posF])) {
                a[posR] = null;
            }
            posF++;
            posR++;
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 将null位置“后移”
     */
    public static void swap(Integer[] a) {
        //posNull指向“空的位置”  posExist指向“存在数的位置”
        //第一个数不可能为空，因为在置空的时候我们是以第一个数为基准的，只可能是第一个数之后才可能为空
        //所以posE设置为1
        int posN = 0;
        int posE = 1;
        while (posE < a.length) {
            //找到“第一个”为空的位置
            while (a[posN] != null) {
                posN++;
            }
            //找到“第一个”不为空的位置
            while (a[posE] == null) {
                posE++;
            }
            //通过两个while循环，可以确定a[posN]==null、a[posE]!=null
            //交换就是在使用这两个位置
            if (a[posN] == null && a[posE] != null) {
                Integer t = a[posE];
                a[posE] = a[posN];
                a[posN] = t;
            }
            //交换之后这两个指针都要下移一位
            posN++;
            posE++;
        }
        System.out.println(Arrays.toString(a));
        int i = 0;
        while (a[i] != null && i < a.length) {
            System.out.print(a[i] + "  ");
            i++;
        }
    }

    public static void main(String[] args) {
        //有序数组
        Integer[] a = {3, 3, 3, 4, 6, 6, 7, 8, 8, 8, 9, 10};
        ArrayDeduplication.blanking(a);
        ArrayDeduplication.swap(a);

    }
}
