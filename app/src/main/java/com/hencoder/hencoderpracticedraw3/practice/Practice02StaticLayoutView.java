package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Administrator
 */
public class Practice02StaticLayoutView extends View {
    private TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello\nHenCoder";
    StaticLayout mStaticLayout;

    public Practice02StaticLayoutView(Context context) {
        super(context);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        textPaint.setTextSize(60);
        // TODO: 2019/11/18 使用静态的文本布局
        //width 是文字区域的宽度，文字到达这个宽度后就会自动换行；
        final int width = 600;
        //align 是文字的对齐方向；
        final Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        //spacingMult 是行间距的倍数，通常情况下填 1 就好；
        final float spacingMult = 1;
        //spacingAdd 是行间距的额外增加值，通常情况下填 0 就好；
        final float spacingAdd = 0;
        //includePad 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界
        final boolean includePad = true;

//        mStaticLayout = new StaticLayout();
        mStaticLayout = new StaticLayout(text, textPaint,
                width,
                alignment,
                spacingMult,
                spacingAdd,
                includePad
        );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
        // TODO: 2019/11/18
        //canvas.drawText(text, 50, 100, textPaint);
        canvas.save();
        canvas.translate(50,40);
        mStaticLayout.draw(canvas);
        canvas.restore();
    }

}
