package me.menduo.leetcode;

import java.util.*;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-05-12 15:47
 **/
public class NO210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            indegree[to]++;
            if (!edges.containsKey(from)) {
                List<Integer> tos = new ArrayList<>();
                tos.add(to);
                edges.put(from,tos);
            } else {
                edges.get(from).add(to);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        while(!q.isEmpty()) {
            int tmp = q.poll();
            count++;
            result.add(tmp);
            List<Integer> tos = edges.get(tmp);
            if(tos == null) continue;
            for(int to : tos) {
                indegree[to]--;
                if(indegree[to] == 0) q.offer(to);
            }
        }

        if(count != numCourses) return new int[0];
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        NO210 no210 =new NO210();
        System.out.println(Arrays.toString(no210.findOrder(3, new int[][]{{1, 0}})));
    }
}
