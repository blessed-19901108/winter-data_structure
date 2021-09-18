package First_week;

public class Recursion {
    //阶乘
    public static int factorial(int n) {
        int sum = 1;
        //System.out.println("N="+n+" "+"SUM="+sum);
        if (n == 1) {
            return 1;
        } else {
            sum = n * factorial(n - 1);
            //System.out.println("N="+n+" "+"SUM="+sum);
            return sum;
        }
    }

    //斐波那契数列 先走大的迭代 e.g:f(5)=f(3)+f(4)-->先算f(4)
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //解一元二次方程组，已知有两个根，范围(-3~-2)和(2~3)，迭代不是递归
    //二分法
    public static double f(double x) {
        return (double) ((x - 2.5) * (x + 2.3));
    }

    public static int dichotomy(double max, double min) {
        if (Recursion.f(max) * Recursion.f(min) < 0) {
            double X = (max + min) / 2;
            double value1 = Math.abs(Recursion.f(X));
            if (value1 < 0.00001) {
                System.out.println("处于该范围的根为：" + X);
            } else {
                if (Recursion.f(max) * Recursion.f(X) < 0) {
                    min = X;
                } else {
                    max = X;
                }
                Recursion.dichotomy(max, min);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("10!是" + Recursion.factorial(10));
        System.out.println("斐波那契数列的第10项是" + Recursion.fibonacci(10));
        Recursion.dichotomy(-3, -2);
        Recursion.dichotomy(2, 3);
    }

}
