package com.example.classic;

/**
 * @author mengchen
 * @time 19-5-4 下午3:17
 */
public class CRC16 {

    private static short[] table = new short[256];

    private static int poly =  1 << 16 | 1 << 12 | 1 << 5 | 1;

    private static void init() {
        for (short i = 0; i < 256; i++) {
            int b = 0;
            int temp = i;
            System.out.println(i);
            for (byte j = 0; j < 8; j++) {
                if (((temp << j) & 0x80) == 0x80) {
                    b = b ^ ((poly << (8 - j - 1)) & 0xffff);
                    temp = temp ^ (((poly << (8 - j - 1)) & 0xffff0000) >> 16);
                }
                System.out.println(Integer.toBinaryString(b));
            }
            table[i] = (short) b;
        }
    }

    public static short CRC16(String s) {
        short res = 0;
        short tabNo = 0;

        for (int i = 0; i < s.length(); i++) {
            tabNo = (short) ((res & 0xFF) ^ (s.charAt(i) & 0xff));
            res = (short) (((res >> 8) & 0xff) ^ table[tabNo]);
        }

        return res;
    }

    public static void main(String[] args) {
        init();
        for (int i = 1; i <= 256; i++) {
            System.out.print(Integer.toHexString(Short.toUnsignedInt(table[i - 1])) + " ");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println(CRC16("data") % 16384);
    }

}
