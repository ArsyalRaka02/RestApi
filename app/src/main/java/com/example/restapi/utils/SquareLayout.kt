package com.example.restapi.utils

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout

class SquareLayout: RelativeLayout {

    constructor(context: Context): super(context)
    constructor(context: Context, attr: AttributeSet): super(context, attr)
    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int): super(context, attr, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

}