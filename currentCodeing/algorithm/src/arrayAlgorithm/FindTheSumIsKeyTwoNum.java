package arrayAlgorithm;

import java.util.Arrays;

/**
 * 寻找一个递增数组中和为S的两个数
 */
public class FindTheSumIsKeyTwoNum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 11, 15};
        int[] result = new int[2];
        System.out.println(isHavingNum(arr, 88, result));
        System.out.println(Arrays.toString(result));
    }

    /**
     * @param array 数组
     * @param key   关键字
     * @param result 存放结果
     * @return 是否有这两个数
     */
    public static boolean isHavingNum(int[] array, int key, int[] result) {
        if (array == null || array.length == 0) {
            return false;
        }
        //利用首尾指针去寻找
        int left = 0;
        int right = array.length-1;
        while (left <= right) {
            if (array[left] + array[right] > key) {
                right--;
            } else if (array[left] + array[right] < key) {
                left++;
            } else {
                result[0] = array[left];
                result[1] = array[right];
                return true;
            }
        }
        return false;
    }
}
