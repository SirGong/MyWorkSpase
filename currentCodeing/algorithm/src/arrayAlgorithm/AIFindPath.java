package arrayAlgorithm;

public class AIFindPath {
    public int movingCount(int threshold, int rows, int cols) {
        //边界检查
        if (threshold < 0 || rows <= 0 || cols <= 0)
            return 0;
        //初始化标志数组
        int[] flag = new int[rows * cols];
        return movingCountCore(threshold, rows, cols, flag, 0, 0);
    }

    //用来回溯寻找路径
    public int movingCountCore(int threshold, int rows, int cols, int[] flag, int r, int c) {
        int count = 0;
        if (check(threshold, rows, cols, flag, r, c)) {
            flag[r * cols + c] = 1;
            count = 1 + movingCountCore(threshold, rows, cols, flag, r + 1, c)
                    + movingCountCore(threshold, rows, cols, flag, r - 1, c)
                    + movingCountCore(threshold, rows, cols, flag, r, c + 1)
                    + movingCountCore(threshold, rows, cols, flag, r, c - 1);
        }
        return count;
    }

    //判断机器人能否进入坐标
    public boolean check(int threshold, int rows, int cols, int[] flag, int r, int c) {
        if (r >= 0 && r < rows && c >= 0 && c < cols
                && sum(r) + sum(c) <= threshold
                && flag[r * cols + c] == 0)
            return true;
        return false;
    }

    //用来计算坐标的各位数之和
    public int sum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        AIFindPath aiFindPath = new AIFindPath();
        System.out.println(aiFindPath.movingCount(15, 100, 1));
    }
}
