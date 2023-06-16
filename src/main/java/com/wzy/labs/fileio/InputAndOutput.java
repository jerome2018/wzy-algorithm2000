package com.wzy.labs.fileio;

import com.sun.org.apache.bcel.internal.util.ClassPath;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FileName: InputAndOutput
 * Description: 文件类输入输出流实验
 * Author: wangzhenyue
 * Date: 2023/2/6 13:45
 */
public class InputAndOutput {

    /**
     * @Description
     * @Param file路径
     * @return void
     * @Author wangzhenyue
     * @Date  2023/2/6 14:31
     **/
    public static void getInput(String path ){

        try (InputStream fis = new FileInputStream(path)) {
            System.out.println("Number of remaining bytes:"
                    + fis.available());
            int content;
            long skip = fis.skip(0);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args){
        System.out.println("---------starting to test file--------");
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(Thread.currentThread().getContextClassLoader().getResource("/").getPath());
        getInput("src/main/resources/input.txt");


    }
}
