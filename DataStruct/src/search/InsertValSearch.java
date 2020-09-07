package search;

import java.util.Arrays;

public class InsertValSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        int index = insertValSearch(arr, 0, arr.length - 1, 1);
        System.out.println(index);
    }

    /**
     * @param arr     原数组
     * @param left
     * @param right
     * @param findVal
     * @return 未找到返回-1，找到返回索引
     */
    public static int insertValSearch(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        //求出mid,该方法为自适应的查找方法
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {
            //向右
            return insertValSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
