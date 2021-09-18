package Third_week;

public class ArraySearch {

    /**
     * 递归查找，找到第一次出现该元素的位置，找到则返回此时的下标，否则返回-1
     * a:所需要查找的数组
     * k:从哪里开始查找
     * x:所需要查找的元素
     */
    public static <E> int search(E[] a, int k, E x) {
        while (k == a.length - 1) {
            return -1;
        }
        if (a[k] == x) {
            return k;
        } else {
            return search(a, k + 1, x);
        }

    }

    public static void main(String[] args) {
        Integer[] a = {3, 3, 3, 4, 6, 6, 7, 8, 8, 8, 9, 10};
        System.out.print(ArraySearch.search(a, 0, 4));
    }
}
