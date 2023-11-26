package com.appx.elementcraft;

import androidx.annotation.NonNull;

public class DropDownItems
{
    private String text;
    private int imageId;
    private int id;
    private static final int NULL_INT = -99;

    public DropDownItems(@NonNull int id, String text)
    {
        this.text =text;
        this.id=id;
        this.imageId = NULL_INT;
    }

    public DropDownItems(@NonNull int id, int imageId,String text)
    {
        this.text = text;
        this.id=id;
        this.imageId=imageId;
    }

    public String getText()
    {
        return text;
    }

    public int getImageId()
    {
        return imageId;
    }

    public int getId() {
        return id;
    }

}
