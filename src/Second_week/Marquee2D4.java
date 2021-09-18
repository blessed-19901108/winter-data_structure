package Second_week;

import java.util.Arrays;

/**
 * 注释简洁一点，最好一看就懂，不要用坐标描述位置，变量不要一会用i,一会用j,这样给自己添加麻烦
 * 对于二维数组的下标变换，先在现在演算纸上写上数字，再替换成变量
 */
public class Marquee2D4 {
    public static <E> void marquee(E[][] a) {
        //保存数组第一个数，判断是否回到原位
        E x1 = a[0][0];
        E x2 = a[1][1];
        do {
            //暂存
            E t = a[0][0];
            //第1列往上移动
            //下标越界！！！！
//            for(int i = 0;i<a.length-1;i++){
//                a[i][0]=a[i+1][0];
//            }
            for (int i = 1; i <= a.length - 1; i++) {
                a[i - 1][0] = a[i][0];
            }
            //最后一行行往左移动
            for (int i = 1; i <= a.length - 1; i++) {
                a[3][i - 1] = a[3][i];
            }
            //最后一列往下移动
            //下标越界！！！！
//            for(int i = a.length-1;i>0;i--){
//                a[i][3] = a[i-1][3];
//            }
            for (int i = a.length - 1; i > 0; i--) {
                a[i][3] = a[i - 1][3];
            }
            //第1行往右移动  a[0][1]要空出来放原本的a[0][0]
            for (int i = a.length - 1; i > 1; i--) {
                a[0][i] = a[0][i - 1];
            }
            a[0][1] = t;

            t = a[1][1];
            a[1][1] = a[1][2];
            a[1][2] = a[2][2];
            a[2][2] = a[2][1];
            a[2][1] = t;
        } while (a[0][0] != x1 || a[1][1] != x2);
    }

    public static <E> void print(E[][] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.println(Arrays.toString(s[i]));
        }
    }


    public static void main(String[] args) {
        Integer[][] s = new Integer[4][4];
        int n = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                s[i][j] = n;
                n++;
            }
        }
        Marquee2D4.print(s);
        System.out.println();
        Marquee2D4.marquee(s);
        Marquee2D4.print(s);
        System.out.println();
    }
}
