package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 10, 34, 567, 8589};
//        int index = binarySearch(arr, 0, arr.length - 1, 344);
//        System.out.println(index);

        int[] arr2 = {1, 24, 59, 59, 59, 59, 76, 85, 90};
        List<Integer> resultList = binarySearch2(arr2, 0, arr2.length - 1, 59);
        System.out.println(resultList);

    }
    //二分查找前提是数据已经有序
    //找到时结束递归，或者right>left也需要结束递归

    /**
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 待查找的值
     * @return 找到返回索引，未找到返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        //当left>right时，返回-1
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (midVal > findVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (midVal < findVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
    //二分查找的非递归方法
    /**
     * @param arr     目标数组，升序
     * @param findVal 关键字
     * @return 找到返回下标，未找到返回-1
     */
    public int binarySearchNoRec(int[] arr, int findVal) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == findVal) {
                return mid;
            } else if (arr[mid] < findVal) {//向右
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;//循环结束没有找到
    }

    //找到有重复数据的所有索引并返回
    //在找到mid索引值，不要马上返回，向mid左右两边分别继续扫描，将找到的所有索引值加入到集合中并返回
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        //当left>right时，返回-1
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (midVal > findVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (midVal < findVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> indexList = new ArrayList<Integer>();
            int temp = mid - 1;//已经找到mid为目标索引，向左继续查找
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                indexList.add(temp);
                temp -= 1;
            }
            indexList.add(mid);//将目标索引加入到集合，此时加入保证索引的有序性
            temp = mid + 1;//已经找到mid为目标索引，向左继续查找
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                indexList.add(temp);
                temp += 1;//temp右移
            }
            return indexList;
        }
    }
}
