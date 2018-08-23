package com.ly.common.widget

import android.content.Context
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Handler
import android.os.Message
import android.support.annotation.RawRes
import android.util.AttributeSet
import android.view.SurfaceView
import android.view.View
import android.widget.ImageButton
import android.widget.RelativeLayout
import com.ly.common.R
import java.lang.ref.WeakReference
import java.util.jar.Attributes

/**
 * 提供Video播放回调，与[android.widget.VideoView]控件相似，但是它有一些播放暂停，快速前进，后退的自定义控制
 */
class MovieView constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    companion object {
        private val TAG = "MovieView"
        /**前进或后退一次的时间量*/
        private val FAST_FORWARD_REWIND_INTERVAL = 5000//ms
        private val TIMEOUT_CONTROLLS = 3000//ms
    }

    /**
     * 监听与[MovieView]相关的所有事件
     */
    abstract class MovieListener {
        /**当Video开始或运行的时候调用*/
        open fun onMovieStarted() {}

        /**当Video暂停或结束的时候调用*/
        open fun onMovieStoped() {}

        /**当View最小化的时候调用*/
        open fun onMovieMinimized() {}
    }

    /**显示Video回调*/
    private val mSurfaceView: SurfaceView

    //控制
    private val mToggle: ImageButton
    private val mShade: View
    private val mFastForward: ImageButton
    private val mFastRewind: ImageButton
    private val mMinimize: ImageButton

    /**用来播放视频，当没有视频被设置的时候为null*/
    internal var mMediaPlayer: MediaPlayer? = null

    /**播放视频的资源Id*/
    @RawRes
    private var mVideoResourceId: Int = 0

    var title: String = ""
    private var mAdjustViewBounds: Boolean = false
    /**处理media控制超时*/
    private var mTimeoutHandler: TimeoutHandler? = null
    internal var mMovieListener: MovieListener? = null

    private var mSavedCurrentPosition: Int = 0

    init {
        setBackgroundColor(Color.BLACK)

        //加载布局内容
        View.inflate(context, R.layout.view_movie, this)
        mSurfaceView = findViewById(R.id.surface)
        mShade = findViewById<View>(R.id.shade)
        mToggle = findViewById(R.id.toggle)
        mFastForward = findViewById(R.id.fast_forward)
        mFastRewind = findViewById(R.id.fast_rewind)
        mMinimize = findViewById(R.id.minimize)

    }

    fun hideControls() {}


    private class TimeoutHandler(view: MovieView) : Handler() {
        private val mMovieViewRef: WeakReference<MovieView> = WeakReference(view)

        override fun handleMessage(msg: Message?) {
            when (msg?.what) {
                MESSAGE_HIDE_CONTROLS -> {
                    mMovieViewRef.get()?.hideControls()
                }
                else -> super.handleMessage(msg)
            }
        }

        companion object {
            internal val MESSAGE_HIDE_CONTROLS = 1
        }

    }

}