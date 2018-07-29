package com.pince.gif.framesequencedemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.rastermill.FrameSequenceDrawable
import com.pince.gif_glide_extension_using_frame_sequence.GlideApp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlideApp.with(this).`as`(FrameSequenceDrawable::class.java)
                .load("http://img5.duitang.com/uploads/item/201411/29/20141129013744_UJEuu.gif")
                .into(gif_iv)
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
