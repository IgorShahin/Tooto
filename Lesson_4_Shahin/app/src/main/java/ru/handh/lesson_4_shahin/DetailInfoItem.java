package ru.handh.lesson_4_shahin;

import android.graphics.drawable.Drawable;

public class DetailInfoItem extends BaseInfoItem {

    public static final int GRID_TYPE = 0;
    public static final int LINE_TYPE = 1;

    private int type;
    private String textInfo;
    private boolean textInfoWarning;

    public DetailInfoItem(int type, Drawable drawableImage, String textTitle, String textInfo, boolean textInfoWarning) {
        super(drawableImage, textTitle);
        this.type = type;
        this.textInfo = textInfo;
        this.textInfoWarning = textInfoWarning;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public boolean isTextInfoWarning() {
        return textInfoWarning;
    }

    public int getType() {
        return type;
    }
}
