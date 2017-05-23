package com.lanhun.utils.exif.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/23.
 */
public class ExifInfo {

    /**
     * 制造商
     */
    private String make;
    /**
     * 型号
     */
    private String model;
    /**
     * 拍摄时间
     */
    private Date shootTime;
    /**
     * 光圈
     */
    private String aperture;

    /**
     * 快门速度
     */
    private String shutterSpeed;

    /**
     * 焦距
     */
    private String focalLength;

    /**
     * 曝光补偿
     */
    private String exposureBias;

    /**
     * 宽
     */
    private Integer width;
    /**
     * 高
     */
    private Integer height;

    /**
     * 水平分辨率
     */
    private Integer xResolution; //RESOLUTION

    /**
     * 垂直分辨率
     */
    private Integer yResolution;
    /**
     * 感光度
     */
    private String sensitivity;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件名字
     */
    private String fileName;

    /**
     * 文件大小
     */
    private Long size;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getShootTime() {
        return shootTime;
    }

    public void setShootTime(Date shootTime) {
        this.shootTime = shootTime;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public String getShutterSpeed() {
        return shutterSpeed;
    }

    public void setShutterSpeed(String shutterSpeed) {
        this.shutterSpeed = shutterSpeed;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public String getExposureBias() {
        return exposureBias;
    }

    public void setExposureBias(String exposureBias) {
        this.exposureBias = exposureBias;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getxResolution() {
        return xResolution;
    }

    public void setxResolution(Integer xResolution) {
        this.xResolution = xResolution;
    }

    public Integer getyResolution() {
        return yResolution;
    }

    public void setyResolution(Integer yResolution) {
        this.yResolution = yResolution;
    }

    public String getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(String sensitivity) {
        this.sensitivity = sensitivity;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String toString() {
        return "ExifInfo{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", shootTime=" + shootTime +
                ", aperture='" + aperture + '\'' +
                ", shutterSpeed='" + shutterSpeed + '\'' +
                ", focalLength='" + focalLength + '\'' +
                ", exposureBias='" + exposureBias + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", xResolution=" + xResolution +
                ", yResolution=" + yResolution +
                ", sensitivity='" + sensitivity + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", size=" + size +
                '}';
    }
}
