package Third_week;

import java.util.Arrays;

public class PolynomialMerging {
    /**
     * 合并二项式
     */
    public static void merging(Polynomial a1, Polynomial a2) {
        int[] pow = new int[a1.pow.length + a2.pow.length];
        int[] coef = new int[a1.coef.length + a2.coef.length];
        //pow和coef的下标
        int p = 0, c = 0;
        //a1、a2的下标
        int a1p = 0, a1c = 0,
                a2p = 0, a2c = 0;
        while (a1p < a1.pow.length && a2p < a2.pow.length
                && a1c < a1.coef.length && a2c < a2.coef.length) {
            if (a1.pow[a1p] == a2.pow[a2p]) {
                pow[p++] = a1.pow[a1p++];
                a2p++;
                coef[c++] = a1.coef[a1c++] + a2.coef[a2c++];
            } else if (a1.pow[a1p] > a2.pow[a2p]) {
                pow[p++] = a1.pow[a1p++];
                coef[c++] = a1.coef[a1c++];
            } else {
                pow[p++] = a2.pow[a2p++];
                coef[c++] = a2.coef[a2c++];
            }
        }
        while (a1p == a1.pow.length && a2p < a2.pow.length) {
            pow[p++] = a2.pow[a2p++];
            coef[c++] = a2.coef[a2c++];
        }
        while (a2p == a2.pow.length && a1p < a1.pow.length) {
            pow[p++] = a1.pow[a1p++];
            coef[c++] = a1.coef[a1c++];
        }
//        System.out.println(Arrays.toString(coef));
//        System.out.println(Arrays.toString(pow));
        int i1 = 0, i2 = 0;
        while (coef[i1] != 0 && i1 < coef.length) {
            System.out.print(coef[i1++] + "  ");
        }
        System.out.println();
        while (pow[i2] != 0 && i1 < pow.length) {
            System.out.print(pow[i2++] + "  ");
        }
    }

    public static void main(String[] args) {
        int[] a1c = {1, 10, 6, 7};
        int[] a1p = {5, 4, 2, 0};
        int[] a2c = {3, 4, 4, 1, 8};
        int[] a2p = {5, 3, 2, 1, 0};
        Polynomial a1 = new Polynomial(a1c, a1p);
        Polynomial a2 = new Polynomial(a2c, a2p);
        PolynomialMerging.merging(a1, a2);

    }

}

//coefficient:系数 pow:指数

/**
 * 设置一个对象，保存系数和指数
 */
class Polynomial {
    int[] coef;
    int[] pow;

    Polynomial(int[] coef, int[] pow) {
        this.coef = coef;
        this.pow = pow;
    }
}
