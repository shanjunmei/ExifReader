package com.lanhun.utils.exif.reader;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.lanhun.utils.exif.model.ExifInfo;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/5/23.
 */
public class ExifReader {

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static ExifInfo getExifInfo(File file) {
        ExifInfo exifInfo = null;
        try {

            exifInfo = new ExifInfo();
            exifInfo.setFilePath(file.getParent());
            exifInfo.setFileName(file.getName());
            exifInfo.setSize(file.length());

            Metadata metadata = JpegMetadataReader.readMetadata(file);
            for (Directory directory : metadata.getDirectories()) {

                if ("ExifSubIFDDirectory".equalsIgnoreCase(directory.getClass().getSimpleName())) {
                    exifInfo.setAperture(directory.getString(ExifSubIFDDirectory.TAG_FNUMBER));
                    exifInfo.setShutterSpeed(directory.getString(ExifSubIFDDirectory.TAG_EXPOSURE_TIME));
                    exifInfo.setSensitivity(directory.getString(ExifSubIFDDirectory.TAG_ISO_EQUIVALENT));
                    exifInfo.setFocalLength(directory.getString(ExifSubIFDDirectory.TAG_FOCAL_LENGTH));
                    exifInfo.setShootTime(directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL));
                    exifInfo.setWidth(directory.getInteger(ExifSubIFDDirectory.TAG_EXIF_IMAGE_WIDTH));
                    exifInfo.setHeight(directory.getInteger(ExifSubIFDDirectory.TAG_EXIF_IMAGE_HEIGHT));
                    exifInfo.setExposureBias(directory.getString(ExifSubIFDDirectory.TAG_EXPOSURE_BIAS));

                    //光圈F值=镜头的焦距/镜头光圈的直径
                  /*  System.out.println("光圈值: f/" + directory.getString(ExifSubIFDDirectory.TAG_FNUMBER));

                    System.out.println("曝光时间: " + directory.getString(ExifSubIFDDirectory.TAG_EXPOSURE_TIME) + "秒");
                    System.out.println("ISO速度: " + directory.getString(ExifSubIFDDirectory.TAG_ISO_EQUIVALENT));
                    System.out.println("焦距: " + directory.getString(ExifSubIFDDirectory.TAG_FOCAL_LENGTH) + "毫米");

                    System.out.println("拍照时间: " + directory.getString(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL));
                    System.out.println("宽: " + directory.getString(ExifSubIFDDirectory.TAG_EXIF_IMAGE_WIDTH));
                    System.out.println("高: " + directory.getString(ExifSubIFDDirectory.TAG_EXIF_IMAGE_HEIGHT));*/

                }

                if ("ExifIFD0Directory".equalsIgnoreCase(directory.getClass().getSimpleName())) {
                    exifInfo.setMake(directory.getString(ExifIFD0Directory.TAG_MAKE));
                    exifInfo.setModel(directory.getString(ExifIFD0Directory.TAG_MODEL));
                    exifInfo.setxResolution(directory.getInteger(ExifIFD0Directory.TAG_X_RESOLUTION));
                    exifInfo.setyResolution(directory.getInteger(ExifIFD0Directory.TAG_Y_RESOLUTION));
/*
                    System.out.println("照相机制造商: " + directory.getString(ExifIFD0Directory.TAG_MAKE));
                    System.out.println("照相机型号: " + directory.getString(ExifIFD0Directory.TAG_MODEL));
                    System.out.println("水平分辨率: " + directory.getString(ExifIFD0Directory.TAG_X_RESOLUTION));
                    System.out.println("垂直分辨率: " + directory.getString(ExifIFD0Directory.TAG_Y_RESOLUTION));*/
                }
            }


        } catch (Exception e) {

            //IGNORE
        }
        if (exifInfo != null) {
            String sql = "INSERT INTO `exif`.`exif` (`make`, `model`, `shoot_time`, `aperture`, `shutter_speed`," +
                    " `focal_length`, `exposure_bias`, `width`, `height`, `x_resolution`, `y_resolution`, `sensitivity`, `file_path`, `file_name`, `size`) VALUES " +
                    "( " + getString(exifInfo.getMake()) + ", " + getString(exifInfo.getModel()) + ", " + getString(exifInfo.getShootTime() == null ? null : sdf.format(exifInfo.getShootTime())) + ", " + getString(exifInfo.getAperture()) + ", " + getString(exifInfo.getShutterSpeed()) + "" +
                    ", " +getString( exifInfo.getFocalLength()) + ", " + getString(exifInfo.getExposureBias()) + ", " +getString( exifInfo.getWidth()) + ", " +getString( exifInfo.getHeight()) + "" +
                    ", " + getString(exifInfo.getxResolution()) + ", " + getString(exifInfo.getyResolution()) + ", " + getString(exifInfo.getSensitivity()) + ", " +getString (exifInfo.getFilePath() == null ? null : exifInfo.getFilePath().replace("\\", "\\\\")) + ", " + getString(exifInfo.getFileName()) + ", " + getString(exifInfo.getSize()) + ");";
            System.out.println(sql);
        }
        return exifInfo;
    }

    private static String getString(Object i) {
        if(i!=null){
            i="'"+i+"'";
        }
        return (String)i;
    }
}
