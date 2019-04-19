package com.niuyi.android.views.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * 底部弹出Dialog
 */
public abstract class NyBottomBaseDialog extends NyBaseDialog {

    public NyBottomBaseDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected Integer setGravity() {
        return Gravity.BOTTOM;
    }

    @Override
    protected Integer setWindowAnimation() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            //底部弹窗需要去除默认margin边框,布局宽度沾满全屏展示
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.horizontalMargin = 0;
            window.setAttributes(lp);
        }
    }
}
