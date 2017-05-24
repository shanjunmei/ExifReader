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
        String path = "G:\\photos.sql";
        FileOutputStream fos = new FileOutputStream(path);
        PrintStream ps = new PrintStream(fos);
        PrintStream out=System.out;
        System.setOut(ps);

        System.out.println("start TRANSACTION; ");
        File dir = new File("G:\\照片");
        long t=System.currentTimeMillis();
        list(dir);
        System.out.println("commit; ");
        t=System.currentTimeMillis()-t;
        System.setOut(out);
        System.out.println("take "+t+" ms");
        File jpegFile = new File("G:\\100CANON\\IMG_0234.JPG");


       /* ExifInfo info = ExifReader.getExifInfo(jpegFile);
        System.out.println(info);*/
    }

    public static void list(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {

                for (File f : files) {
                    list(f);
                }
            }
        } else {
            String fileName = file.getName();
            fileName = fileName.toLowerCase();
            // System.out.println(file.getAbsolutePath());
            if (fileName.endsWith(".jpg")) {
                ExifInfo info = ExifReader.getExifInfo(file);
            }

        }
    }

}
