package arrayAlgorithm;


public class GetNumberOfKey {
    public int GetNumberOfK(int[] array, int k) {
        int number = 0;
        if (array != null && array.length != 0) {
            int first = getFirstKey(array, 0, array.length - 1, k);
            int last = getLastKey(array, 0, array.length - 1, k);
            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
    }

    //获取第一个k出现的下标
    public static int getFirstKey(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midData = array[midIndex];
        if (midData == k) {
            if (midIndex > 0 && array[midIndex - 1] != k || midIndex == 0) {
                return midIndex;
            } else {
                end = midIndex - 1;
            }
        } else if (midData > k) {//中间的值边关键字大，在数组的前半段
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }
        return getFirstKey(array, start, end, k);
    }

    //获取最后一个k出现的下标
    public static int getLastKey(int[] array, int start, int end, int k) {
        if (start > end)
            return -1;
        int midIndex = (start + end) / 2;
        int midData = array[midIndex];
        if (midData == k) {
            if (midIndex < end && array[midIndex + 1] != k || midIndex == end) {
                return midIndex;
            } else {
                start = midIndex + 1;
            }
        } else if (midData < k) {//向后半段继续查找
            start = midIndex + 1;
        } else {
            end = midIndex - 1;
        }
        return getLastKey(array, start, end, k);
    }
}
