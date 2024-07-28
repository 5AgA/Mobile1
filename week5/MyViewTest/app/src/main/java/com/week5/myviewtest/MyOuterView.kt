package com.week5.myviewtest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import java.util.Random

class MyOuterView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
                        :super(context, attrs, defStyleAttr)

    var color = Color.BLUE
    val random = Random()
    var newX = random.nextInt(500).toFloat()
    var newY = random.nextInt(500).toFloat()
    var newR = ((random.nextInt(2) + 1) * 100).toFloat()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.LTGRAY)
        val paint = Paint()
        paint.setColor(color)
        canvas?.drawCircle(newX, newY, newR, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Toast.makeText(context, "Touch!!!", Toast.LENGTH_SHORT).show()
        return false  // View 함수(상위 함수)에 너가 처리할 수 있는지 물어봄, true는 처리 완료
    }
}