package com.appx.elementcraft;

import android.view.View;
public class CommonUtils {
    public int getVisibilityValue(String vis)
    {
        if(vis.equalsIgnoreCase("gone"))
            return View.GONE;
        return View.VISIBLE;
    }
}
