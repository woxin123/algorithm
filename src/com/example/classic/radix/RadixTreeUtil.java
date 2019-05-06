package com.example.classic.radix;

import java.io.Serializable;

/**
 * @author mengchen
 * @time 19-5-4 下午8:17
 */
public class RadixTreeUtil {

    private RadixTreeUtil() {
    }

    static <V extends Serializable> void dumpTree(RadixTreeNode<V> node, String outputPrefix) {
        if (node.isHasValue()) {
            System.out.format("%s{%s:%s}%n", outputPrefix, node.getPrefix(), node.getValue(), node.getChildren().size());
        } else {
            System.out.format("%s{%s}%n", outputPrefix, node.getPrefix(), node.getChildren().size());
        }
        for (RadixTreeNode<V> child : node) {
            dumpTree(child, outputPrefix + "\t");
        }
    }

//    public static <V extends Serializable> void dumpTree(RadixTree<V> tree) {
//
//    }

    public static int largestPrefixLength(CharSequence a, CharSequence b) {
        int length = 0;

        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                break;
            }
            length++;
        }
        return length;
    }

}
