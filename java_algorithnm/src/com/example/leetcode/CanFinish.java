package com.example.leetcode;

import java.util.*;

/**
 * @author mengchen
 * @time 19-3-22 下午2:21
 */
public class CanFinish {

    private int[] inDegree;
    private boolean[][] graph;
    private Queue<Integer> queue;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        inDegree = new int[numCourses];
        graph = new boolean[numCourses][numCourses];
        queue = new LinkedList<>();
        //初始化
        for (int i = 0; i < prerequisites.length; i++) {
            //初始化每个节点的入度
            inDegree[prerequisites[i][0]]++;
            //构建有向图
            graph[prerequisites[i][1]][prerequisites[i][0]] = true;
        }
        findNextInDegreeZero();
        while (!queue.isEmpty()) {
            int k = queue.poll();
            //把k出发的边的另一个点的入度-1
            for (int l = 0; l < graph[k].length; l++) {
                if (graph[k][l]) {
                    inDegree[l]--;
                }
            }
            findNextInDegreeZero();
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] > 0) {
                return false;
            }
        }
        return true;

    }


    public void findNextInDegreeZero() {
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                inDegree[i] = -1;
                queue.add(i);
            }
        }

    }


    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        int[][] a = new int[][]{
                {0, 1},
        };
        System.out.println(canFinish.canFinish(2, a));
    }


}
