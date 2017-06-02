package com.lanhun.utils.exif;

import net.coobird.thumbnailator.Thumbnails;

/**
 * Created by Administrator on 2017/6/2.
 */
public class ImageThumbUtils {

    public static void main(String args[])throws Exception{
        Thumbnails.of("C:\\Users\\Administrator\\Desktop\\2.jpg")
                .size(400, 600)
                .toFile("C:\\Users\\Administrator\\Desktop\\2_2.jpg");
    }
}
