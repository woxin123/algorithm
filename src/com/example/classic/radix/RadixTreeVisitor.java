package com.example.classic.radix;

/**
 * @author mengchen
 * @time 19-5-4 下午8:42
 */
public interface RadixTreeVisitor<V, R> {
    void visit(String key, V value);
    R getResult();
}
