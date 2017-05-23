package com.lanhun.utils;

import com.lanhun.utils.exif.model.ExifInfo;
import com.lanhun.utils.exif.reader.ExifReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {
        String path="G:\\photos.sql";
        FileOutputStream fos=new FileOutputStream(path);
        PrintStream ps=new PrintStream(fos);
        System.setOut(ps);

        System.out.println("start TRANSACTION; ");
        File dir = new File("G:\\照片");

        list(dir);
        System.out.println("commit; ");
        File jpegFile = new File("G:\\100CANON\\IMG_0234.JPG");


       /* ExifInfo info = ExifReader.getExifInfo(jpegFile);
        System.out.println(info);*/
    }

    public static void list(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                list(f);
            }
        } else {
            String fileName = file.getName();
            fileName = fileName.toLowerCase();
            if (fileName.endsWith(".jpg")) {
                ExifInfo info = ExifReader.getExifInfo(file);
            }

        }
    }

}
