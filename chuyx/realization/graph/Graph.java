package realization.graph;

import java.util.LinkedList;

/**
 * 无向图
 */
public class Graph {
    /**
     *  顶点的个数
     */
    private int v;

    /**
     * 邻接表
     */
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图一条边存两次
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }
}