package com.demo.com.zhangxingbin0903;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/9/3.
 */

public class MyView extends View {
    private int[][]rectheight={{Color.BLUE,276},{Color.BLUE,281},{Color.BLUE,214},{Color.BLUE,227}};

    private int rect_width;
    private int rect_height;
    private Paint paint;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        rect_width = (int) typedArray.getDimension(R.styleable.MyView_rectwidth, 60);
        rect_height = (int) typedArray.getDimension(R.styleable.MyView_rectspace, 60);
        typedArray.recycle();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(50,getHeight()-50,getWidth()-50,getHeight()-50,paint);
        canvas.drawLine(getWidth()-50,getHeight()-50,getWidth()-75,getHeight()-75,paint);
        canvas.drawLine(getWidth()-50,getHeight()-50,getWidth()-75,getHeight()-25,paint);
        paint.setTextSize(24);
        canvas.drawText("管理成本",110,getHeight()-25,paint);
        canvas.drawText("劳务成本",220,getHeight()-25,paint);
        canvas.drawText("销售成本",330,getHeight()-25,paint);
        canvas.drawText("资产盘亏",440,getHeight()-25,paint);
        paint.setTextSize(15);
        canvas.drawText("27.64%",120,getHeight()-336,paint);
        canvas.drawText("28.17%",240,getHeight()-341,paint);
        canvas.drawText("21.48%",360,getHeight()-274,paint);
        canvas.drawText("22.70%",480,getHeight()-287,paint);


        canvas.drawLine(50,getHeight()-50,50,50,paint);
        canvas.drawLine(50,50,25,75,paint);
        canvas.drawLine(50,50,75,75,paint);

        canvas.drawCircle(50,getHeight()-50,5,paint);
        paint.setTextSize(15);
        canvas.drawText("0.00%",10,getHeight()-50,paint);


        canvas.drawCircle(50,getHeight()-100,5,paint);
        canvas.drawText("5.00%",10,getHeight()-100,paint);

        canvas.drawCircle(50,getHeight()-150,5,paint);
        canvas.drawText("10.00%",10,getHeight()-150,paint);

        canvas.drawCircle(50,getHeight()-200,5,paint);
        canvas.drawText("15.00%",10,getHeight()-200,paint);

        canvas.drawCircle(50,getHeight()-250,5,paint);
        canvas.drawText("20.00%",10,getHeight()-250,paint);

        canvas.drawCircle(50,getHeight()-300,5,paint);
        canvas.drawText("25.00%",10,getHeight()-300,paint);

        canvas.drawCircle(50,getHeight()-350,5,paint);
        canvas.drawText("30.00%",10,getHeight()-350,paint);


        Paint rectPaint = new Paint();
        for (int i = 0; i <rectheight.length ; i++) {
            int bottom = getHeight()-50;
            int top = getHeight()-50-rectheight[i][1];
            int left = 50+rect_height*(i+1)+rect_width*i;
            int right = left+rect_width;

            rectPaint.setColor(rectheight[i][0]);
            canvas.drawRect(left,top,right,bottom,rectPaint);

        }
    }
}
