package com.ycx.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by lixiaoming on 16/4/27.
 */
public class SelectPopWindow extends PopupWindow implements View.OnClickListener {
    private View mMenuView;
    private TextView tvPraisePopWindow;
    private TextView tvReplyPopWindow;
    private TextView tvCopyPopWindow;
    private TextView tvReportPopWindow;
    private int width;
    private int height;

    public SelectPopWindow(Context context, View.OnClickListener listener) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.select_popwindow, null);

        tvPraisePopWindow = (TextView) mMenuView.findViewById(R.id.tvPraisePopWindow);
        tvReplyPopWindow = (TextView) mMenuView.findViewById(R.id.tvReplyPopWindow);
        tvCopyPopWindow = (TextView) mMenuView.findViewById(R.id.tvCopyPopWindow);
        tvReportPopWindow = (TextView) mMenuView.findViewById(R.id.tvReportPopWindow);

        tvPraisePopWindow.setOnClickListener(this);
        tvReplyPopWindow.setOnClickListener(this);
        tvCopyPopWindow.setOnClickListener(this);
        tvReportPopWindow.setOnClickListener(this);

        //设置SelectPicPopupWindow的View
        setContentView(mMenuView);
        //设置SelectPicPopupWindow弹出窗体的宽
        setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
//        //设置SelectPicPopupWindow弹出窗体的高
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        setBackgroundDrawable(dw);
        setFocusable(true);
//        setAnimationStyle(R.style.popwindow_anim_style);
        getContentView().measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        width = getContentView().getMeasuredWidth();
        height = getContentView().getMeasuredHeight();
        this.listener = listener;
    }

    public int getMeasureWidth() {
        return width;
    }

    public int getMeasureHeight() {
        return height;
    }
    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
            dismiss();
        }

    }

    private View.OnClickListener listener;
}
