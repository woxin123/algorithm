package com.example.leetcode;

import com.example.leetcode.util.UndirectedGraphNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 克隆图 |克隆图|dfs|[CloneGraph](CloneGraph.java)|2019-02-18|
 * @author mengchen
 * @time 19-2-18 下午12:34
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(newRoot.label, newRoot);
        cloneGraphHelp(newRoot, map, node.neighbors);
        return newRoot;
    }

    private void cloneGraphHelp(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map, List<UndirectedGraphNode> neighbs) {
        for (UndirectedGraphNode graphNode : neighbs) {
            UndirectedGraphNode newNeighbour;
            if (map.containsKey(graphNode.label)) {
                newNeighbour = map.get(graphNode.label);
            } else {
                newNeighbour = new UndirectedGraphNode(graphNode.label);
                map.put(graphNode.label, newNeighbour);
                if (graphNode.neighbors != null && !graphNode.neighbors.isEmpty()) {
                    cloneGraphHelp(newNeighbour, map, graphNode.neighbors);
                }
            }
            node.neighbors.add(newNeighbour);
        }
    }
}
