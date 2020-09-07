package recursion;

public class Labyrinth {
    public static void main(String[] args) {
        //迷宫问题，创建二维数组模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示无法到达的路径
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //输出
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map,1,1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    //使用递归回溯解决该问题
    //从1，1位置开始找，如果能到6，5的位置及可以到达
    //约定:当map[i][j]为0表示该点没有走过，为1表示墙，2表示通路，3表示走不通
    //策略：先走下，再走右，再走上，最后走左，如果走不通，在回溯
    /**
     * @param map 地图
     * @param i  从哪儿开始找
     * @param j
     * @return 找到路，返回true，否则false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j]==0){
                map[i][j] = 2;
                if(setWay(map,i+1,j)){//向下能走通
                    return true;
                }else if(setWay(map,i,j+1)){//向右能走通
                    return true;
                }else if(setWay(map,i-1,j)){//向上能走通
                    return  true;
                }else if(setWay(map,i,j-1)){//向左能走通
                    return true;
                }else{//都走不通
                    map[i][j] = 3;
                    return false;
                }
            }else { //可能map[i][j]!=0,可能是1，2，3
                return false;
            }
        }
    }
}
