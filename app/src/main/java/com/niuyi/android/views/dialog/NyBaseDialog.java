package com.niuyi.android.views.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

/**
 * Dialog基类
 */
public abstract class NyBaseDialog extends Dialog {

    private Context mContext;

    public NyBaseDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (setLayout() != null) {
            setContentView(setLayout());
        }
        Window window = getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            decorView.setPadding(0, 0, 0, 0);
            if (setGravity() != null) {
                window.setGravity(setGravity());
            } else {
                //设置默认位置中间
                window.setGravity(Gravity.CENTER);
            }
            if (setWindowAnimation() != null) {
                window.setWindowAnimations(setWindowAnimation());
            }
            if (setBackgroundRes() != null) {
                decorView.setBackgroundResource(setBackgroundRes());
            }
        }
        initView();
    }

    protected abstract Integer setLayout();

    protected abstract Integer setGravity();

    protected abstract Integer setBackgroundRes();

    protected abstract Integer setWindowAnimation();

    protected abstract void initView();

    protected void setOnClickListener(int id, View.OnClickListener listener) {
        findViewById(id).setOnClickListener(listener);
    }
}
