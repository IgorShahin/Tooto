package ru.handh.lesson_4_shahin;

import android.graphics.drawable.Drawable;

public class DetailInfoItem extends BaseInfoItem {

    private String textInfo;
    private boolean textInfoWarning;

    public DetailInfoItem(Drawable drawableImage, String textTitle, String textInfo, boolean textInfoWarning) {
        super(drawableImage, textTitle);
        this.textInfo = textInfo;
        this.textInfoWarning = textInfoWarning;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public boolean isTextInfoWarning() {
        return textInfoWarning;
    }
}
