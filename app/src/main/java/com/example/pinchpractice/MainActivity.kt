package com.example.pinchpractice

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.OnScaleGestureListener
import android.widget.ImageView
import androidx.core.view.GestureDetectorCompat
import android.view.View
var scale = 1f
lateinit var pupper:ImageView

class MainActivity : AppCompatActivity() {
    var detector: ScaleGestureDetector? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pupper = findViewById(R.id.imgPupper)
        detector = ScaleGestureDetector(this,ScaleListener())

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        detector!!.onTouchEvent(event)
        return super.onTouchEvent(event)
    }
    class ScaleListener: ScaleGestureDetector.SimpleOnScaleGestureListener(){
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scale *= detector!!.scaleFactor
            scale = Math.max(.1f, Math.min(scale, 5.0f))
            pupper.scaleX = scale
            pupper.scaleY = scale

            return true
        }
    }
}