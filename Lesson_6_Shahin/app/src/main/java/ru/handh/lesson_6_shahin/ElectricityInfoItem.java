package ru.handh.lesson_6_shahin;

public class ElectricityInfoItem implements RowType {

    private int image;
    private String textTitle;
    private int serialNumber;
    private String textInfo;
    private boolean textInfoWarning;

    private int indicationDaytime;
    private int indicationNight;
    private int indicationPeak;

    public ElectricityInfoItem(int image, String textTitle, int serialNumber, String textInfo, boolean textInfoWarning) {
        this.image = image;
        this.textTitle = textTitle;
        this.serialNumber = serialNumber;
        this.textInfo = textInfo;
        this.textInfoWarning = textInfoWarning;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public void setTextInfo(String textInfo) {
        this.textInfo = textInfo;
    }

    public boolean isTextInfoWarning() {
        return textInfoWarning;
    }

    public void setTextInfoWarning(boolean textInfoWarning) {
        this.textInfoWarning = textInfoWarning;
    }

    public int getIndicationDaytime() {
        return indicationDaytime;
    }

    public void setIndicationDaytime(int indicationDaytime) {
        this.indicationDaytime = indicationDaytime;
    }

    public int getIndicationNight() {
        return indicationNight;
    }

    public void setIndicationNight(int indicationNight) {
        this.indicationNight = indicationNight;
    }

    public int getIndicationPeak() {
        return indicationPeak;
    }

    public void setIndicationPeak(int indicationPeak) {
        this.indicationPeak = indicationPeak;
    }
}
