package com.jonhbravo.shadowrecycler

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.Shader
import android.util.AttributeSet
import android.util.Log
import androidx.recyclerview.widget.RecyclerView

class ShadowRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private val leftGradientShader: Shader by lazy {
        LinearGradient(
            0f,
            height.toFloat() / 2,
            SHADOW_WIDTH,
            height.toFloat() / 2,
            Color.parseColor("#000000"),
            Color.parseColor("#00000000"),
            Shader.TileMode.CLAMP
        )
    }

    private val rightGradientShader: Shader by lazy {
        LinearGradient(
            width - SHADOW_WIDTH,
            height.toFloat() / 2,
            width.toFloat(),
            height.toFloat() / 2,
            Color.parseColor("#00000000"),
            Color.parseColor("#000000"),
            Shader.TileMode.CLAMP
        )
    }

    private val paint by lazy {
        Paint(ANTI_ALIAS_FLAG)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val extend = computeHorizontalScrollExtent()
        val range = computeHorizontalScrollRange()

        if (!canScrollHorizontally(1) && range <= extend)
            return

        val offset = computeHorizontalScrollOffset()

        val percentage = 100f * (offset / (range - extend.toFloat()))

        Log.i(
            "RecyclerView Data:",
            "Offset: $offset, Extend: $extend, Range: $range, Percentage: $percentage"
        )

        if (percentage > 0) {
            paint.shader = leftGradientShader
            canvas?.drawRect(SHADOW_WIDTH, height.toFloat(), 0f, 0f, paint)
        }

        if (range > extend && percentage < 100) {
            paint.shader = rightGradientShader
            canvas?.drawRect(width - SHADOW_WIDTH, height.toFloat(), width.toFloat(), 0f, paint)
        }
    }

    companion object {
        const val SHADOW_WIDTH = 100f
    }
}