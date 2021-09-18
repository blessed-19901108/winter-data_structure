package First_week;

public class Chick {
    public static void main(String[] args) {
        /**如果使用方法来定义，调用方法因为会被分到不同的核中（多核处理），最终的时间结果会是错的
         * 最好是都放在mian中，然后单个运行
         * */
        //二重循环
        /*
        long startTime2 = System.nanoTime();    //开始时间
        int money = 100;    //设置一个money变量，这样每次只要改一个地方就行了
        int fChick, mChick, sChick;
        for (fChick = 0; fChick <= money/5; fChick++)
            for (mChick = 0; mChick <= money / 3; mChick++) {
                sChick = 100 - fChick - mChick;
                if (sChick % 3 == 0 && fChick * 5 + mChick * 3 + sChick / 3 == money&&fChick+mChick+sChick == money) {
                    // System.out.println("公鸡"+fChick+"母鸡"+mChick+"小鸡"+sChick);
                }
            }
        long consumingTime2 = System.nanoTime() - startTime2;
        System.out.println(consumingTime2 );//输出的时候不要带汉字
        */

        //三重循环
        long startTime2 = System.nanoTime();
        int money2 = 10000;
        int fChick, mChick, sChick;
        for (fChick = 0; fChick <= money2; fChick++)
            for (mChick = 0; mChick <= money2; mChick++)
                for (sChick = 0; sChick <= money2 * 3; sChick++) {
                    if (sChick % 3 == 0 && fChick * 5 + mChick * 3 + sChick / 3 == money2 && fChick + mChick + sChick == money2) {
                        // System.out.println("公鸡"+fChick+"母鸡"+mChick+"小鸡"+sChick);
                    }
                }
        long consumingTime2 = System.nanoTime() - startTime2;
        System.out.println(consumingTime2);
    }
}
