package com.example.interview;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * LRU Cache 缓存淘汰策略 最近最少使用
 * LRU 的全称是 Least Recently Used
 *
 * @author mengchen
 * @time 19-4-4 下午7:48
 */
public class LRUCache<K, V> {

    class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Pair<K, V>> lruCache;

    private int maxSize;

    private int size;

    private final int DEFAULT_MAX_SIZE = 16;

    public LRUCache(int size) {
        if (size > 1) {
            this.maxSize = size;
        } else {
            this.maxSize = DEFAULT_MAX_SIZE;
        }
        lruCache = new LinkedList<>();
    }

    public void put(K key, V value) {
        Pair<K, V> pair = new Pair<>(key, value);
        if (size < maxSize) {
            lruCache.add(pair);
            size++;
        } else {
            lruCache.removeFirst();
            lruCache.add(pair);
        }

    }

    public V get(K key) {
        if (size == 0) {
            return null;
        }
        Pair<K, V> tmp = null;
        Iterator<Pair<K, V>> iterator = lruCache.iterator();
        while (iterator.hasNext()) {
            Pair<K, V> pair = iterator.next();
            if (pair.key.equals(key)) {
                iterator.remove();
                tmp = pair;
            }
        }
        lruCache.add(tmp);
        return tmp.value;
    }


    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(3);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

}
