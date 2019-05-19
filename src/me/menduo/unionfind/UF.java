package me.menduo.unionfind;

import java.util.Arrays;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-05-19 23:16
 **/
public class UF {
    private int node[];
    private int split[];
    private int count;

    public UF(int size) {
        this.node = new int[size];
        for (int i = 0; i < size ; i++) {
            node[i] = i;
        }
        this.split = new int[size];
        Arrays.fill(this.split,1);
        this.count = size;
    }

    private int find(int tmp) {
        while (node[tmp]!=tmp) {
            node[tmp] = node[node[tmp]];
            tmp = node[tmp];
        }
        return tmp;
    }
    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;
        if(split[rootP] < split[rootQ]) {
            node[rootP] = rootQ;
            split[rootQ] += split[rootP];
        }else {
            node[rootQ] = rootP;
            split[rootP] += split[rootQ];
        }
        count--;
    }

    private boolean connection(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
//        UF uf = new UF(8);
//        System.out.println("最差情况：---------start-----");
//        System.out.println("init-count=" + uf.count);
//        uf.union(0,1);
//        System.out.println("first-count=" + uf.count);
//        uf.union(2,3);
//        uf.union(4,5);
//        uf.union(6,7);
//        uf.union(0,2);
//        uf.union(4,6);
//        uf.union(0,4);
//        System.out.println("last-conut=" + uf.count);
//        System.out.println("-----------end-----");

        UF uf = new UF(10);
        System.out.println("一般情况：---------start-----");
        System.out.println("init-count=" + uf.count);
        uf.union(4,3);
        System.out.println("first-count=" + uf.count);
        uf.union(3,8);
        uf.union(6,5);
        uf.union(9,4);
        uf.union(2,1);
        uf.union(5,0);
        uf.union(7,2);
        uf.union(6,1);
        System.out.println("last-conut=" + uf.count);
        System.out.println("-----------end-----");
    }

}
