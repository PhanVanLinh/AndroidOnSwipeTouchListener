package vn.linh.androidonswipetouchlistener

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

//        val ACTION_DOWN = 0
//        val ACTION_UP = 1
//        val ACTION_MOVE = 2
//        val ACTION_CANCEL = 3
class MainActivity : AppCompatActivity() {
    val TAG = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<View>(R.id.button).setOnClickListener {
            Log.i(TAG, "onClick")
        }

        findViewById<View>(R.id.rootLayout).setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeRight(): Boolean {
                Log.i(TAG, "onSwipeRight")
                return false
            }

            override fun onSwipeLeft(): Boolean {
                Log.i(TAG, "onSwipeLeft")
                return true
            }
        })
    }
}
