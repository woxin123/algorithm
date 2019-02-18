package com.example.leetcode.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchen
 * @time 19-2-18 下午12:32
 */
public class UndirectedGraphNode {
    public int label;

    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        this.label = x;
        this.neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
