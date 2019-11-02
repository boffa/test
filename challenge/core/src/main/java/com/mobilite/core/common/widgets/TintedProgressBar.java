package com.mobilite.core.common.widgets;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class TintedProgressBar extends ProgressBar {

    public TintedProgressBar(Context context) {
        super(context);
        init();
    }

    public TintedProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TintedProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        getIndeterminateDrawable().setColorFilter(ColorUtils.getAccentColor(getContext()), PorterDuff.Mode.SRC_IN);
    }
}