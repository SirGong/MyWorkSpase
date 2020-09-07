package sortAlgorithm;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {4, 2, 5, 8, 6, 9, 7, 1, 3};
        System.out.println("排序之前：");
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println("排序过后：");
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array) {
        //定义待插入的数
        for (int i = 1; i < array.length; i++) {
            int insertVal = array[i];
            int insertIndex = i - 1;
            //insertIndex >= 0 ：防止索引越界
            while (insertIndex >= 0 && insertVal < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            //循环结束，一斤找到插入位置：insertIndex+1
            array[insertIndex+1] = insertVal;
        }

    }
}
