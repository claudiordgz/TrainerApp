package com.mobileappscompany.android.trainerapplibrary.views.listeners;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Window;
import android.view.WindowManager;

import com.mobileappscompany.android.trainerapplibrary.R;
import com.mobileappscompany.android.trainerapplibrary.views.actionbar.ActionBarColorChange;

import java.io.InputStream;

/**
 * Created by claudio on 15/02/15.
 */
public class ColorChangeListener {

    ActionBarColorChange actionBarColorizer = new ActionBarColorChange();
    Context mContext;
    private ViewPager mViewPager = null;

    public ColorChangeListener(Context context){
        mContext = context;
    }

    public void setViewPager(ViewPager viewPager){
        mViewPager = viewPager;
    }

    public void setActionBar(ActionBar actionBar) {
        actionBarColorizer.setActionBar(actionBar);
    }

    public void notify(int newColor, int newBackgroundColor, int statusBarColor){
        actionBarColorizer.changeColor(newColor, mContext.getResources().getDrawable(R.drawable.actionbar_bottom));
        mViewPager.setBackgroundColor(newBackgroundColor);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Activity parent = (Activity)mContext;
            Window window = parent.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(statusBarColor);
        }
    }
}
