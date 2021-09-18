package Second_week;

public class Marquee1D {

    //循环右移num位
    public static <E> E[] CycleR(E[] a, int num) {
        E t;
        //外层循环控制移动多少次
        for (int n = 0; n < num; n++) {
            t = a[a.length - 1];
            //内层循环每次移动一位
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = t;
        }
        return a;
    }

    //循环左移num位
    public static <E> E[] CycleL(E[] a, int num) {
        E t;
        for (int n = 0; n < num; n++) {
            t = a[0];
            for (int i = 0; i < a.length - 1; i++) {
                a[i] = a[i + 1];
            }
            a[a.length - 1] = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Integer[] s = new Integer[15];
        for (int i = 0; i < s.length; i++) {
            s[i] = i;
        }
        //输出移位前
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + "  ");
        }
        System.out.println();

        //随机循环移动次数
        int n = (int) (Math.random() * 3 + 1);
        //保存数组第一个数，判断是否回到原位
        int x = s[0];
        do {
            if (n % 2 == 0) {
                Marquee1D.CycleR(s, n);
            } else {
                Marquee1D.CycleL(s, n);
            }
        } while (s[0] != x);
        //输出移位后
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + "  ");
        }
    }
}
