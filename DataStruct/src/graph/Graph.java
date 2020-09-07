package graph;


import sun.java2d.opengl.OGLRenderQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//表示图对应的邻接矩阵
    private int numOfEdges;//表示边的数目
    //定义boolean数组，标记某个元素是否被访问
    boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String[] vertexs = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(5);
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);

        graph.showGraph();
//        System.out.println("深度优先遍历：");
//        graph.dfs();
        System.out.println("广度优先遍历：");
        graph.bfs();


    }

    public Graph(int n) {
        //初始化
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //得到第一个邻接点的下标w
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    private void dfs(boolean[] isVisited, int i) {
        //访问该节点，输出
        System.out.print(getValueByIndex(i) + "->");
        //将该节点设置成已访问
        isVisited[i] = true;
        //查找该节点的第一个邻接节点
        int w = getFirstNeighbor(i);
        while (w != -1) {
            //有邻接结点
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs进行重载，遍历所有的节点
    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //广度优先遍历
    private void bfs(boolean[] isVisited, int i) {
        int u;//队列头结点对应下标
        int w;//邻接点
        //队列，记录访问顺序
        LinkedList queue = new LinkedList();
        //访问节点，输出信息
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;//标记为已访问
        //将节点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            //取出队列头结点下标
            u = (int) queue.removeFirst();
            //得到第一个邻接节点的下标w
            w = getFirstNeighbor(u);
            while (w != -1) {//找到
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    //标记已访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱节点，找w后面的下一个邻接点
                w = getNextNeighbor(u,w);
            }
        }
    }
    //重载bfs
    public void bfs(){
        for (int i = 0; i <getNumOfVertex() ; i++) {
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
    //添加边

    /**
     * @param v1     表示定点的下标
     * @param v2
     * @param weight 边的权值，0不存在边，1 存在边
     */
    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //返回边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回节点i对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示邻接矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
}
