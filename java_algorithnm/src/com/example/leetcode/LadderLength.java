package com.example.leetcode;

import java.util.*;


/**
 * 单词接龙
 * @author mengchen
 * @time 19-2-15 下午5:11
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        createGraph(beginWord, wordList, graph);
        return bfs(beginWord, endWord, graph);
    }

    private boolean isCanConnect(String word1, String word2) {
        boolean flag = false;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (!flag) {
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private void createGraph(String beginWord, List<String> worldList, Map<String, List<String>> graph) {
        worldList.add(beginWord);
        for (int i = 0; i < worldList.size(); i++) {
            graph.put(worldList.get(i), new ArrayList<>());
        }

        for (int i = 0; i < worldList.size(); i++) {
            for (int j = i + 1; j < worldList.size(); j++) {
                if (isCanConnect(worldList.get(i), worldList.get(j))) {
                    graph.get(worldList.get(i)).add(worldList.get(j));
                    graph.get(worldList.get(j)).add(worldList.get(i));
                }
            }
        }
    }

    private int bfs(String beginWorld, String endWorld, Map<String, List<String>> graph) {
        Queue<AbstractMap.SimpleEntry<String, Integer>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<>(beginWorld, 1));
        Set<String> visit = new HashSet<>();
        visit.add(beginWorld);
        while (!queue.isEmpty()) {
            String node = queue.peek().getKey();
            int step = queue.peek().getValue();
            queue.poll();

            if (node.equals(endWorld)) {
                return step;
            }

            List<String> linkedNode = graph.get(node);
            for (String str : linkedNode) {
                if (!visit.contains(str)) {
                    queue.offer(new AbstractMap.SimpleEntry<>(str, step + 1));
                    visit.add(node);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");


        System.out.println(new LadderLength().ladderLength("hit", "cog", list));
    }
}
