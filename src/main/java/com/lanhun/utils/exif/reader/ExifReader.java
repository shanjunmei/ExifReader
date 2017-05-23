package com.lanhun.utils.exif.reader;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.lanhun.utils.exif.model.ExifInfo;

import java.io.File;

/**
 * Created by Administrator on 2017/5/23.
 */
public class ExifReader {

    public static ExifInfo getExifInfo(File file) {
        ExifInfo exifInfo = null;
        try {
            Metadata metadata = JpegMetadataReader.readMetadata(file);
            exifInfo = new ExifInfo();
            exifInfo.setFilePath(file.getParent());
            exifInfo.setFileName(file.getName());

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
                    System.out.println("光圈值: f/" + directory.getString(ExifSubIFDDirectory.TAG_FNUMBER));

                    System.out.println("曝光时间: " + directory.getString(ExifSubIFDDirectory.TAG_EXPOSURE_TIME) + "秒");
                    System.out.println("ISO速度: " + directory.getString(ExifSubIFDDirectory.TAG_ISO_EQUIVALENT));
                    System.out.println("焦距: " + directory.getString(ExifSubIFDDirectory.TAG_FOCAL_LENGTH) + "毫米");

                    System.out.println("拍照时间: " + directory.getString(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL));
                    System.out.println("宽: " + directory.getString(ExifSubIFDDirectory.TAG_EXIF_IMAGE_WIDTH));
                    System.out.println("高: " + directory.getString(ExifSubIFDDirectory.TAG_EXIF_IMAGE_HEIGHT));

                }

                if ("ExifIFD0Directory".equalsIgnoreCase(directory.getClass().getSimpleName())) {
                    exifInfo.setMake(directory.getString(ExifIFD0Directory.TAG_MAKE));
                    exifInfo.setModel(directory.getString(ExifIFD0Directory.TAG_MODEL));
                    exifInfo.setxResolution(directory.getInteger(ExifIFD0Directory.TAG_X_RESOLUTION));
                    exifInfo.setyResolution(directory.getInteger(ExifIFD0Directory.TAG_Y_RESOLUTION));

                    System.out.println("照相机制造商: " + directory.getString(ExifIFD0Directory.TAG_MAKE));
                    System.out.println("照相机型号: " + directory.getString(ExifIFD0Directory.TAG_MODEL));
                    System.out.println("水平分辨率: " + directory.getString(ExifIFD0Directory.TAG_X_RESOLUTION));
                    System.out.println("垂直分辨率: " + directory.getString(ExifIFD0Directory.TAG_Y_RESOLUTION));
                }
            }


        } catch (Exception e) {
            //IGNORE
        }
        return exifInfo;
    }
}
