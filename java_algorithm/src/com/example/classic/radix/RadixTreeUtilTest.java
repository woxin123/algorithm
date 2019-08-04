package com.example.classic.radix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mengchen
 * @time 19-5-4 下午9:01
 */
public class RadixTreeUtilTest {
    @Test
    public void testDumpTreeRadixTreeNodeOfVString() {

    }

    @Test
    public void testDumpTreeRadixTreeOfV() {
    }

    @Test
    public void testLargestPrefixLength() {
        assertEquals(5, RadixTreeUtil.largestPrefixLength("abcdefg", "abcdexyz"));
        assertEquals(3, RadixTreeUtil.largestPrefixLength("abcdefg", "abcxyz"));
        assertEquals(3, RadixTreeUtil.largestPrefixLength("abcdefg", "abctuvxyz"));
        assertEquals(0, RadixTreeUtil.largestPrefixLength("abcdefg", ""));
        assertEquals(0, RadixTreeUtil.largestPrefixLength("", "abcxyz"));
        assertEquals(0, RadixTreeUtil.largestPrefixLength("xyz", "abcxyz"));
    }

}
