package First_week;

public class Chick1 {
    public static void chick3(int a) {
        int fChick, mChick, sChick;
        for (fChick = 0; fChick <= a; fChick++) {
            for (mChick = 0; mChick <= a; mChick++) {
                for (sChick = 0; sChick <= a * 3; sChick++) {
                    if (sChick % 3 == 0 && fChick * 5 + mChick * 3 + sChick / 3 == a) {
                        // System.out.println("公鸡"+fChick+"母鸡"+mChick+"小鸡"+sChick);
                    }
                }
            }
        }

    }

    public static void chick2(int a) {
        int fChick, mChick, sChick;
        for (fChick = 0; fChick <= a / 5; fChick++) {
            for (mChick = 0; mChick <= a / 3; mChick++) {
                sChick = 100 - fChick - mChick;
                if (sChick % 3 == 0 && fChick * 5 + mChick * 3 + sChick / 3 == a) {
                    // System.out.println("公鸡"+fChick+"母鸡"+mChick+"小鸡"+sChick);
                }
            }
        }
    }

    public static void main(String[] args) {
        long startTime2 = System.nanoTime();    //开始时间
        Chick1.chick2(100);
        long consumingTime2 = System.nanoTime() - startTime2;
        System.out.println("100只鸡二重循环消耗时间--" + consumingTime2 + "纳秒");

        long startTime2_1 = System.nanoTime();    //开始时间
        Chick1.chick2(1000);
        long consumingTime2_1 = System.nanoTime() - startTime2_1;
        System.out.println("1000只鸡二重循环消耗时间--" + consumingTime2_1 + "纳秒");

        long startTime2_2 = System.nanoTime();    //开始时间
        Chick1.chick2(10000);
        long consumingTime2_2 = System.nanoTime() - startTime2_2;
        System.out.println("10000只鸡二重循环消耗时间--" + consumingTime2_2 + "纳秒");


        long startTime3 = System.nanoTime();    //开始时间
        Chick1.chick3(100);
        long consumingTime3 = System.nanoTime() - startTime3;
        System.out.println("100只鸡三重循环消耗时间--" + consumingTime3 + "纳秒");

        long startTime3_1 = System.nanoTime();    //开始时间
        Chick1.chick3(1000);
        long consumingTime3_1 = System.nanoTime() - startTime3_1;
        System.out.println("1000只鸡三重循环消耗时间--" + consumingTime3_1 + "纳秒");

        long startTime3_2 = System.nanoTime();    //开始时间
        Chick1.chick3(10000);
        long consumingTime3_2 = System.nanoTime() - startTime3_2;
        System.out.println("10000只鸡三重循环消耗时间--" + consumingTime3_2 + "纳秒");


    }

}
