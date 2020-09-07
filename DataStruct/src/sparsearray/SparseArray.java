package sparsearray;

/**
 * @author ASUS
 * @Date 2020/4/9 10:55
 * @Version 1.0.0
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建原始的二维数组：11*11
        //0：表示没有 1：表示黑子 2：表示蓝子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[5][6] = 1;
        //输出原始二维数组
        for (int[] row:chessArr) {
            for(int data: row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //遍历原始二维数组，确定稀疏数组的大小
        int sum = 0;
        for(int i = 0;i<chessArr.length;i++){
            for (int j = 0; j <11 ; j++) {
                if (chessArr[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("原始数组的有效数据为："+sum+"个");
        //创建稀疏数组
        int sparesArr[][] = new int [sum+1][3];
        //给稀疏数组赋初值
        sparesArr[0][0] = 11;
        sparesArr[0][1] = 11;
        sparesArr[0][2] = sum;
        //遍历二维数组，将非零的值存放入稀疏数组
        int count = 0;//每找到一个非零数据，就会行増一
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if(chessArr[i][j]!=0){
                    count++;
                    sparesArr[count][0]=i;
                    sparesArr[count][1]=j;
                    sparesArr[count][2]=chessArr[i][j];
                }
            }
        }
        System.out.println("得到的稀疏数组是：");
        //遍历输出稀疏数组
        for(int i = 0;i<sparesArr.length;i++){
            System.out.printf("%d\t%d\t%d\n",sparesArr[i][0],sparesArr[i][1],sparesArr[i][2]);
        }
    }
}
