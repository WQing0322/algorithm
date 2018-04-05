package com.wqing.demo.algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by weiqing1 on 2018/3/25.
 */
public class FileUtils {


    public static void printListDirectory(File dir) {

        if (!dir.exists()) {
            throw new IllegalArgumentException("目录：" + dir + "不存在");
        }

        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("目录：" + dir + "不是目录");
        }

        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printListDirectory(file);
                } else {
                    System.out.println(file.getName());
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
//        com.wqing.demo.algorithm.FileUtils.printListDirectory(new File("E:\\p2pfile\\良研问卷"));


//        RandomAccessFile raf = new RandomAccessFile(new File("C:\\Users\\weiqing1\\Desktop\\轮播js.txt"), "rw");
//        raf.write(1);
//        System.out.println("one byte:" + raf.readByte());
//        System.out.println(raf.getFilePointer() + "," + raf.length());
//        raf.seek(0);
//        byte[] bytes = new byte[Integer.valueOf(raf.length() + "")];
//        raf.read(bytes);
//        System.out.println(Arrays.toString(bytes));
//
//        raf.close();

//        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("C:\\Users\\weiqing1\\Desktop\\raf.txt"), "rw");
//        System.out.println(randomAccessFile.getFilePointer() + "," + randomAccessFile.length());


        FileInputStream fin = new FileInputStream("C:\\Users\\weiqing1\\Desktop\\轮播js.txt");
        int b;
        int i = 1;//字节
        while ((b = fin.read()) != -1) {
            if (b <= 0xf) {
                //0xf ：16进制 ; 只要比16进制的f小或相等，一个字节转换为16进制就一定只有一位
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + "  ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        fin.close();
    }
}
