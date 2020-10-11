package arrayAlgorithm;

import java.util.Arrays;

/**
 * 从一副扑克牌中抽出五张牌，判断是否是顺子
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 */
public class PlayingCardSequence {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 1)
            return false;
        //首先对牌进行升序排序
        Arrays.sort(numbers);
        int numberOfZero = 0;//记录所有牌中0的个数
        int numberOfGap = 0;//记录数组中的间隔数目
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                numberOfZero++;
        }
        //统计数组中的间隔数目，数组已经升序有序
        int small = numberOfZero;
        int big = small + 1;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big])//出现了对子，不可能是顺子
                return false;
            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return numberOfZero >= numberOfGap;
    }
}
