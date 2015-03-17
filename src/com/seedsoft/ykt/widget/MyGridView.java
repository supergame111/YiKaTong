package com.seedsoft.ykt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class MyGridView extends GridView{


	    public MyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

		@Override
	    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	        // Do not use the highest two bits of Integer.MAX_VALUE because they are
	        // reserved for the MeasureSpec mode
	        int heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
	        super.onMeasure(widthMeasureSpec, heightSpec);
//	        getLayoutParams().height = getMeasuredHeight();
	   }
}
