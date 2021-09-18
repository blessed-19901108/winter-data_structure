package Second_week;

public class InvertedArray {

    //开辟一个数组空间
    public static int[] Inverted1(int[] arr) {
        int[] arr1 = new int[arr.length];
        //arr1的下标
        int j = (arr1.length - 1);
        for (int i = 0; i < arr.length; i++) {
            arr1[j] = arr[i];
            j--;
        }
        return arr1;
    }

    //head tail交换

    /**
     * 数组元素为偶数：到中间的两个交换后，再下一步就跳出循环；
     * 奇数：到中间的一个元素，自己和自己交换，再下一步就跳出循环
     */
    public static int[] Inverted2(int[] arr) {
        int head = 0, tail = arr.length - 1, t = 0;
        while (head < tail) {
            t = arr[head];
            arr[head] = arr[tail];
            arr[tail] = t;
            head++;
            tail--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] arr1 = InvertedArray.Inverted1(arr);
        int[] arr2 = InvertedArray.Inverted2(arr);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
