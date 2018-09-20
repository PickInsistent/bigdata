package com.roey.bitmap;

/**
 * Created by LiZhanPing on 2018/9/20.
 */
public class BitMap {

    private byte[] dataBytes;

    public BitMap(int capacity) {
        dataBytes = new byte[1 + capacity / 8];
    }

    public void readData(int num) {
        int bitIndex = num;
        int index = bitIndex / 8;
        int innerIndex = bitIndex % 8;
        System.out.println(num + "在bytes[" + index + "]中的索引：" + innerIndex);
        dataBytes[index] = (byte) (dataBytes[index] | (1 << innerIndex));
    }

    public boolean find(int num) {
        int bitIndex = num;
        int index = bitIndex / 8;
        int innerIndex = bitIndex % 8;
        if (!(((dataBytes[index]) & (1 << innerIndex)) == 0)) {
            return true;
        }
        return false;
    }

    public void output() {
        int count = 0;
        for (int i = 0; i < dataBytes.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (!(((dataBytes[i]) & (1 << j)) == 0)) {
                    count++;
                    int number = i * 8 + j;
                    System.out.println("取出的第  " + count + "\t个数: " + number);
                }
            }
        }
    }

    public static void main(String[] args) {
        int capacity = 40;
        BitMap bitMap = new BitMap(capacity);
        for (int i = 0; i < capacity; i++) {
            int num = (int) (Math.random() * capacity);
            System.out.println("读取了第 " + (i + 1) + "\t个数: " + num);
            bitMap.readData(num);
        }
        System.out.println("2是否存在dataBytes中：" + bitMap.find(2));
        bitMap.output();
    }
}