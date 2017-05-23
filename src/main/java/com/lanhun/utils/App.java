package com.lanhun.utils;

import com.lanhun.utils.exif.model.ExifInfo;
import com.lanhun.utils.exif.reader.ExifReader;

import java.io.File;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {

        File dir = new File("G:\\100CANON");

        list(dir);

        File jpegFile = new File("G:\\100CANON\\IMG_0234.JPG");


        ExifInfo info = ExifReader.getExifInfo(jpegFile);
        System.out.println(info);
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
