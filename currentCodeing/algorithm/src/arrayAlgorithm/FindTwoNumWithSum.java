package arrayAlgorithm;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindTwoNumWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length == 0 || sum <= 0)
            return res;
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int curSum = array[start] + array[end];
            if (curSum < sum) {
                start++;
            } else if (curSum > sum) {
                end--;
            } else {
                res.add(array[start]);
                res.add(array[end]);
                return res;
            }
        }
        return res;
    }
}
