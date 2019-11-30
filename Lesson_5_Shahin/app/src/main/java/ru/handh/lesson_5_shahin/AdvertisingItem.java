package ru.handh.lesson_5_shahin;

public class AdvertisingItem {

    private String imageURL;
    private String title;
    private String info;
    private String address;

    public AdvertisingItem(String imageURL, String title, String info, String address) {
        this.imageURL = imageURL;
        this.title = title;
        this.info = info;
        this.address = address;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
