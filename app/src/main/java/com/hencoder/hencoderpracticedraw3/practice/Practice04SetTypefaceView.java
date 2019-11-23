package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

// TODO: 2019/11/23 typeface == font 都是字体的意思
public class Practice04SetTypefaceView extends View {
    private static final String ASSETS_TYPEFACE ="Satisfy-Regular.ttf";
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";
    Typeface typeface;

    public Practice04SetTypefaceView(Context context) {
        super(context);
    }

    public Practice04SetTypefaceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04SetTypefaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(60);

        typeface = Typeface.createFromAsset(getContext().getAssets(), "Satisfy-Regular.ttf");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setTypeface() 来设置不同的字体

        // 第一处：填入 null 来设置默认字体
        paint.setTypeface(null);
        canvas.drawText(text, 50, 100, paint);

        // TODO: 2019/11/23  Typeface.SERIF 衬线字体: 笔画开始或者结束有额外的装饰，字体不等宽
        // TODO: 2019/11/23 Typeface.SANS_SERIF  无衬线字体：字体等宽，每一处都是相同的宽度
        // 第二处：填入 Typeface.SERIF 来设置衬线字体（宋体）
        paint.setTypeface(Typeface.SERIF);
        canvas.drawText(text, 50, 200, paint);
        // 第三处：填入 typeface 对象来使用 assets 目录下的 "Satisfy-Regular.ttf" 文件
        final Typeface assetsTypeface = getAssetsTypeface();
        paint.setTypeface(assetsTypeface);
        canvas.drawText(text, 50, 300, paint);
    }


    private Typeface getAssetsTypeface(){
        final AssetManager assets = getContext().getAssets();
        return Typeface.createFromAsset(assets,ASSETS_TYPEFACE);
    }
}
