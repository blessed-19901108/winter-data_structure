package Second_week;

import java.util.Arrays;

public class Marquee2D5 {
    public static <E> void OutLayer(E[][] a) {
        //保存数组第一个数，判断是否回到原位
        E x1 = a[0][0];
        do {
            //暂存
            E t = a[0][0];
            //第1列往上移动
            for (int i = 1; i <= a.length - 1; i++) {
                a[i - 1][0] = a[i][0];
            }
            //最后一行往左移动
            for (int i = 1; i <= a.length - 1; i++) {
                a[4][i - 1] = a[4][i];
            }
            //最后一列往下移动
            for (int i = a.length - 1; i > 0; i--) {
                a[i][4] = a[i - 1][4];
            }
            //第1行往右移动  a[0][1]要空出来放原本的a[0][0]
            for (int i = a.length - 1; i > 1; i--) {
                a[0][i] = a[0][i - 1];
            }
            a[0][1] = t;
        } while (a[0][0] != x1);
    }

    public static <E> void InnerLayer(E[][] a) {
        //保存数组第一个数，判断是否回到原位
        E x1 = a[1][1];
        do {
            //暂存
            E t = a[1][1];
            //第1行往左移动
            for (int i = 2; i <= a.length - 2; i++) {
                a[1][i - 1] = a[1][i];
            }
            //最后一列往上移动
            for (int i = 2; i <= a.length - 2; i++) {
                a[i - 1][3] = a[i][3];
            }
            //最后一行往右移动
            for (int i = a.length - 2; i > 1; i--) {
                a[3][i] = a[3][i - 1];
            }
            //第一列往下移动  a[2][1]要空出来放原本的a[1][1]
            for (int i = a.length - 2; i > 1; i--) {
                a[i][1] = a[i - 1][1];
            }
            a[2][1] = t;
        } while (a[1][1] != x1);
    }

    public static <E> void print(E[][] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.println(Arrays.toString(s[i]));
        }
    }


    public static void main(String[] args) {
        Integer[][] s = new Integer[5][5];
        int n = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                s[i][j] = n;
                n++;
            }
        }
        Marquee2D5.print(s);
        System.out.println();
        Marquee2D5.OutLayer(s);
        Marquee2D5.InnerLayer(s);

    }
}
