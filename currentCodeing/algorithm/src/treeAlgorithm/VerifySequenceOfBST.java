package treeAlgorithm;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySequenceOfBST {
    public static boolean verifySequenceOfBST(int[] sequence) {
        //对序列不断进行分割，判断所有的右子节点大于根节点，所有左子节点小于根节点
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return helpVerify(sequence, 0, sequence.length - 1);
    }

    public static boolean helpVerify(int[] sequence, int start, int root) {
        if (start >= root) return true;
        int key = sequence[root];
        int i;
        //找到左右子数的分界点
        for (i = start; i < root; i++)
            if (sequence[i] > key)
                break;
        //在右子树中判断是否含有小于root的值，如果有返回false
        for (int j = i; j < root; j++)
            if (sequence[j] < key)
                return false;
        return helpVerify(sequence, start, i - 1) && helpVerify(sequence, i, root - 1);
    }
}
