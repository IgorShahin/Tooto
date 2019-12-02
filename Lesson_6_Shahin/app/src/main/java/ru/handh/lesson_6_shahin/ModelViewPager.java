package ru.handh.lesson_6_shahin;

public class ModelViewPager {

    private int imageView;
    private String title;

    public ModelViewPager(int imageView, String title) {
        this.imageView = imageView;
        this.title = title;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
