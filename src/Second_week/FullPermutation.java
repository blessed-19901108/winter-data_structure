package Second_week;

public class FullPermutation {
    /**m个数全排列：就是将m个数依次放在第0个位置并固定，剩下的部分再次进行全排列，依次递归，
     * （这个‘递归’就是将剩下的的元素中的第一个放在剩下的元素的第0个位置固定，剩下的部分再次
     * 进行全排列），最后，一个数的全排列作为递归的出口。
     * 有重复元素的全排列，比如{1，2，2，1}这种类型的全排列，基本思路与上述无重复全排列基
     * 本一致，但是如果按照第一种的思路会导致大量的重复组合，因此，每次只需在把某个元素放在
     * 位置0的时候，判断是否重复即可
     * */
    /**
     * clone()用于创建并返回一个对象的拷贝。clone 方法是浅拷贝，对象内属性引用的对象
     * 只会拷贝引用地址，而不会将引用的对象重新分配内存，相对应的深拷贝则会连引用的对象
     * 也重新创建。
     */
    static void permutation(char[] arr, int changePos) {
        for (int pos = changePos; pos < arr.length; pos++) {
            char[] newarr = arr.clone();
            swap(newarr, changePos, pos);
            if (pos != changePos) {
                output(newarr);
            }
            permutation(newarr, changePos + 1);
        }

    }

    /**
     * 交换数组中的两个元素
     */
    static void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 输出一个排列
     */
    static void output(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd'};
        output(arr);
        permutation(arr, 0);
    }
}
