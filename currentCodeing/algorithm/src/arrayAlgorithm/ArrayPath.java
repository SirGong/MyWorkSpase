package arrayAlgorithm;

public class ArrayPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //创建一个标志数组
        int[] flag = new int[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (help(matrix, rows, cols, str, 0, flag, i, j))
                    return true;
            }
        }

        return false;

    }

    /**
     * @param matrix 矩阵
     * @param rows   当前坐标的行
     * @param cols   当前坐标的列
     * @param str    路径字符串
     * @param cur    当前需要匹配的字符的位置，是下一个待访问的节点
     * @param flag   标志数组，表示矩阵中的元素是否已经被访问过
     * @param r      表示访问到第几行
     * @param c      表示访问到第几列
     * @return
     */
    public boolean help(char[] matrix, int rows, int cols, char[] str, int cur, int[] flag, int r, int c) {
        int index = cols * r + c;
        if (r >= 0 && r < rows && c >= 0 && c < cols && flag[index] == 0) {
            if (matrix[index] == str[cur]) {
                cur = cur + 1;
                if (cur >= str.length)//路径的字符已经匹配完，说明存在路径。
                    return true;
                //设置标志数组已经被访问
                flag[index] = 1;
                //递归上下左右进行寻找
                if (help(matrix, rows, cols, str, cur, flag, r - 1, c) ||
                        help(matrix, rows, cols, str, cur, flag, r + 1, c) ||
                        help(matrix, rows, cols, str, cur, flag, r, c - 1) ||
                        help(matrix, rows, cols, str, cur, flag, r, c + 1)) {
                    return true;
                }
                flag[index] = 0;//下一个路径未匹配上
                return false;
            }
            //当前未匹配上
            return false;
        }
        //到达边界或者无路可走
        return false;
    }
}
