package com.example.leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author mengchen
 * @time 19-4-26 下午2:00
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        Integer integer = map.get(key);
        return integer == null ? -1 : integer;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
        }
        else if (map.size() < capacity) {
            map.put(key, value);
        } else {
            Integer removeKey = (Integer) map.keySet().toArray()[0];
            map.remove(removeKey);
//            System.out.println(removeKey);
            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(2);
        lruCache.put(5, 5);
        lruCache.put(6, 6);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);

    }

}
