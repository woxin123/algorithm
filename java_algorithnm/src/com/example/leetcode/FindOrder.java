package com.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 课程表 II
 * @author mengchen
 * @time 19-4-1 上午8:28
 */
public class FindOrder {

    private int[] inDegree;

    private boolean[][] graph;

    private boolean [] onQueue;

    private Queue<Integer> queue;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        inDegree = new int[numCourses];
        graph = new boolean[numCourses][numCourses];
        onQueue = new boolean[numCourses];
        queue = new LinkedList<>();
        // 初始化
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]][prerequisites[i][0]] = true;
            inDegree[prerequisites[i][0]]++;
        }

        int[] rt = new int[numCourses];
        int count = 0;
        // 寻找度数为0的节点
        findNextInDegreeZero();
        while (!queue.isEmpty()) {
            int v = queue.poll();
            rt[count++] = v;
            for (int i = 0; i < graph[v].length; i++) {
                if (graph[v][i]) {
                    // 相应节点度数-1
                    inDegree[i]--;
                }
            }
            findNextInDegreeZero();
        }
        if (count == numCourses) {
            return rt;
        }
        return new int[] {};
    }

    private void findNextInDegreeZero() {
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0 && !onQueue[i]) {
                onQueue[i] = true;
                queue.add(i);
            }
        }
    }


}
