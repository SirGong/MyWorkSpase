package arrayAlgorithm;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindSumIsKeySequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) {
            return res;
        }
        int small = 1;
        int big = 2;
        int mid = (1 + sum) / 2;
        int curSum = small + big;
        while (small < mid) {
            //如果此时的和已经和sum相等，将此时的small到big的值加入list中
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                res.add(list);
            }
            //如果序列加起来的值大于sum，去掉序列中小的值，使总和减小
            while (curSum > sum && small < mid) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = small; i <= big; i++) {
                        list.add(i);
                    }
                    res.add(list);
                }
            }
            //加和的值小于sum，就调整big的值，使和变大
            big++;
            curSum += big;
        }
        return res;
    }
}
