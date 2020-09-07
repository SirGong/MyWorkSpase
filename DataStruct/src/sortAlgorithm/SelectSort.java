package sortAlgorithm;

import java.util.Arrays;

public class SelectSort {
    //选择排序
    public static void main(String[] args) {
        int[] array = {5, 2, 4, 8, 6, 9, 7, 1, 3};
        System.out.println("排序之前：");
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println("排序过后：");
        System.out.println(Arrays.toString(array));

    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //选择
            int minIndex = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                    min = array[j];
                }
            }
            //交换
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }
}
