package ru.handh.lesson_4_shahin;

import android.graphics.drawable.Drawable;

public class BaseInfoItem {

    private Drawable drawableImage;
    private String textTitle;

    public BaseInfoItem(Drawable drawableImage, String textTitle) {
        this.drawableImage = drawableImage;
        this.textTitle = textTitle;
    }

    public Drawable getDrawableImage() {
        return drawableImage;
    }

    public String getTextTitle() {
        return textTitle;
    }
}
