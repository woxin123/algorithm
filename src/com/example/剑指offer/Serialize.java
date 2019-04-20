package com.example.剑指offer;

import java.io.InputStream;
import java.nio.CharBuffer;

/**
 * @author mengchen
 * @time 19-4-19 下午4:37
 */
public class Serialize {

    String Serialize(TreeNode root) {
        if (root == null) {
            return "$,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",").append(Serialize(root.left)).append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        CharBuffer buffer = CharBuffer.wrap(str);
        return DeserializeHelp(buffer);
    }
    TreeNode DeserializeHelp(CharBuffer charBuffer) {
        char ch;
        if ((ch = charBuffer.get()) == '$') {
            charBuffer.get();
            return null;
        }
        int number = ch - '0';
        while ((ch = charBuffer.get()) != ',') {
            number *= 10;
            number += ch - '0';
        }
        TreeNode node = new TreeNode(number);
        node.left = DeserializeHelp(charBuffer);
        node.right = DeserializeHelp(charBuffer);
        return node;
    }
}
