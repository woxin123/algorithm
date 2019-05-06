package com.example.classic.radix;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author mengchen
 * @time 19-5-4 下午7:54
 */
public class RadixTreeNode<V extends Serializable> implements Iterable<RadixTreeNode<V>>, Comparable<RadixTreeNode<V>> {

    /**
     * 在节点中的前缀
     */
    private String prefix;

    /**
     * 存储在节点中的value
     */
    private V value;

    /**
     * 该节点是否存储一个值，这个值主要由Radix
     */
    private boolean hasValue;

    /**
     * 这个节点的孩子节点。请注意，因为我们这里使用了TreeSet，所以RadixTree的遍历将按照字典顺序排列
     */
    private Collection<RadixTreeNode<V>> children;

    /**
     * 打印节点信息
     */
    public void printInfo() {
        if (children != null) {
            System.out.println("[prefix=" + prefix +
                    ", value="+ value +
                    ", hasValue=" + hasValue +
                    ", numOfChildren" + children.size() + "]");
        } else {
            System.out.println("[prefix=" + prefix +
                    ", value="+ value +
                    ", hasValue=" + hasValue + "]");
        }
    }

    public RadixTreeNode(String prefix) {
        this.prefix = prefix;
        this.hasValue = false;
    }

    public RadixTreeNode(String prefix, V value) {
        this.prefix = prefix;
        this.value = value;
        this.hasValue = true;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public Collection<RadixTreeNode<V>> getChildren() {
        if (children == null) {
            children = new TreeSet<>();
        }
        return children;
    }


    public boolean isHasValue() {
        return hasValue;
    }



    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<RadixTreeNode<V>> iterator() {
        if (children == null) {
            return new Iterator<RadixTreeNode<V>>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public RadixTreeNode<V> next() {
                    return null;
                }
            };
        }
        return children.iterator();
    }


    @Override
    public int compareTo(RadixTreeNode<V> o) {
        return prefix.compareTo(o.getPrefix());
    }

    public void setHasValue(boolean b) {
        this.hasValue = b;
        if (!hasValue) {
            this.value = null;
        }
    }
}
