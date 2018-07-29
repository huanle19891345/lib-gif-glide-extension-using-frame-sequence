package com.pince.gif_glide_extension_using_frame_sequence

import android.graphics.Bitmap
import android.support.rastermill.FrameSequence
import android.support.rastermill.FrameSequenceDrawable
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.ResourceDecoder
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import java.io.InputStream

class GifDecoder: ResourceDecoder<InputStream, FrameSequenceDrawable> {

    private var bitmapPool: BitmapPool

    constructor(bitmapPool: BitmapPool) {
        this.bitmapPool = bitmapPool
    }

    override fun handles(source: InputStream, options: Options): Boolean {
        return true
    }

    override fun decode(source: InputStream, width: Int, height: Int, options: Options): Resource<FrameSequenceDrawable>? {
      val frameSequence = FrameSequence.decodeStream(source)
        val frameSequenceDrawable = FrameSequenceDrawable(frameSequence, object: FrameSequenceDrawable.BitmapProvider {
            override fun acquireBitmap(minWidth: Int, minHeight: Int): Bitmap {
                return bitmapPool.getDirty(minWidth,minHeight, Bitmap.Config.ARGB_8888)
            }

            override fun releaseBitmap(bitmap: Bitmap?) {
               bitmapPool.put(bitmap)
            }
        })
        return GifDrawableResource(frameSequenceDrawable)
    }
}